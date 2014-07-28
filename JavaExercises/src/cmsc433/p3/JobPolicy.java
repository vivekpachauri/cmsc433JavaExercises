package cmsc433.p3;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * The class JobPolicy. Provided.
 * 
 * Parent class for implementations of job-level policies.
 * 
 * Note: The cacheVM() method models the act of building
 * a partial configuration in a VM and storing a VM for
 * possible later use. Even though this VM could contain a build
 * of multiple components, our simulation will only cache
 * the last BuildEntry in the partial configuration.
 */
public abstract class JobPolicy {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JobPolicy.class);
	
	/**
	 * Factory class. Build class instance based on Class object.
	 * Works correctly only for CompileFromScratch,LimitDuplicateJobsPolicy,
	 * ReuseIfAvailableNow and ReuseIfAvailableNowCacheEnabled.
	 * 
	 * @param c the Class
	 * 
	 * @return the job policy
	 */
	public static JobPolicy factory(Class<? extends JobPolicy> c) {
		if (logger.isDebugEnabled()) {
			logger.info("factory(Class) - start");
		}
		JobPolicy returnJobPolicy = null;
		if (c == CompileFromScratch.class) {
			returnJobPolicy = new CompileFromScratch();
		} else if (c == LimitDuplicateJobsPolicy.class) {
			returnJobPolicy = new LimitDuplicateJobsPolicy();
		} else if (c == ReuseIfAvailableNow.class) {
			returnJobPolicy = new ReuseIfAvailableNow();
		} else if (c == ReuseIfAvailableNowCacheEnabled.class) {
			returnJobPolicy = new ReuseIfAvailableNowCacheEnabled();	
		}
		if (logger.isDebugEnabled()) {
			logger.debug("factory(Class) - end");
		}
		return returnJobPolicy;
	}
	
	/**
	 * Sets the BuildClient in which JobPolicy operates.
	 * 
	 * @param bc the containing BuildClient
	 */
	abstract public void setContainer(BuildClient bc);

	/**
	 * Process one job.
	 * 
	 * @param jobs the BuildEntry list
	 */
	abstract public void processJob(List<BuildEntry> jobs);
}
