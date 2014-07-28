package cmsc433.p3;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Class SimDriver. Driver for build test process simulation. Provided.
 */
public class SimDriver {

	/** Log4J Logger for this class. */
	private static final Logger logger = Logger.getLogger(SimDriver.class);

	/**
	 * The main method.
	 * 
	 * @param args
	 *            args:fileNames containing PrefixTrees
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

	    // uncomment for use with chainsaw log viewer
	    // Logger.getRootLogger().addAppender(new SocketAppender("localhost", 4560)); 
	    
	    FileAppender appender = null;
	    try {
		appender = new FileAppender(new PatternLayout(),"log.txt");
	    } catch(Exception e) {}
	    Logger.getRootLogger().addAppender(appender);
        
	    // uncomment for logging to System.out
	    //BasicConfigurator.configure(); 

	    if (logger.isDebugEnabled()) {
		logger.info("main(String[]) - start");
	    }
	    System.out.println("File\tClients\tCache\tIter\tJobPol\tBuildPol\tTime\tWork");
	    for (int idx = 0; idx < args.length; idx++) {
		for (int numBuildClients : new int[] { 1, 2, 4, 8, 16 }) {
		    for (int cacheSize : new int[] { 0, 4, 8, 16 }) {
			for (Class<PrefixTreePathIterator> pi : new Class[] {
				PrefixTreeDepthFirstIterator.class,
				PrefixTreeLeavesOnlyIterator.class }) {
			    for (Class<JobPolicy> jp : new Class[] {
				    CompileFromScratch.class,
				    LimitDuplicateJobsPolicy.class,
				    ReuseIfAvailableNow.class,
				    ReuseIfAvailableNowCacheEnabled.class }) {
				for (Class<BuildPolicy> bp : new Class[] {
					RelativelySlowComputer.class,
					RelativelySlowNetwork.class, TenToOne.class }) {
				    PrefixTree.create(args[idx]);
				    PrefixTree.instance
					.addPathIterator(PrefixTreePathIterator
							 .factory(pi,PrefixTree.instance));
				    final CountDownLatch startGate = new CountDownLatch(1);
				    final CountDownLatch endGate = new CountDownLatch(numBuildClients);
				    System.out.print(args[idx] + "\t" + numBuildClients
						     + "\t" + cacheSize + "\t" + pi + "\t" + jp
						     + "\t" + bp + "\t");
				    ExecutorService executor = Executors.newFixedThreadPool(numBuildClients);
				    for (int i = 0; i < numBuildClients; i++) {
					executor.execute(new BuildClient(startGate,
									 endGate, 
									 JobPolicy.factory(jp),
									 BuildPolicy.factory(bp),
									 cacheSize));
				    }
				    executor.shutdown();
				    long start = System.currentTimeMillis();
				    startGate.countDown();
				    endGate.await();
				    long end = System.currentTimeMillis();
				    System.out.print(end - start + "\t");
				    long tot = 0;
				    for (BuildEntry be : PrefixTree.instance.getNodeSet()) {
					tot += be.getWorkDone();
				    }
				    System.out.println(tot);
				}
			    }
			}
		    }
		}
	    }
	    if (logger.isDebugEnabled()) {
		logger.info("main(String[]) - end");
	    }
	}
}