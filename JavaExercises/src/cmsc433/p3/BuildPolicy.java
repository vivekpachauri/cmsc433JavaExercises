package cmsc433.p3;

import org.apache.log4j.Logger;

/**
 * The BuildPolicy parent class. Provided.
 * 
 * The parent class for implementations of BuildPolicy.
 * BuildPolicy objects simulate 3 operations: compile
 * locally, transfer VM over the network, and get the
 * VM from the local cache.
 * 
 * BuildPolicy implementation simulate these operations by putting
 * the calling thread to sleep for a period of time
 * specified by the implementation.
 */
public abstract class BuildPolicy {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BuildPolicy.class);
	
	/**
	 * Factory class. Build class instance based on Class object.
	 * Works correctly only for RelativelySlowComputer,
	 * RelativelySlowNetwork and TenToOne. 
	 * 
	 * @param c the c
	 * 
	 * @return the build policy
	 */
	public static BuildPolicy factory(Class<? extends BuildPolicy> c) {
		if (logger.isDebugEnabled()) {
			logger.debug("factory(Class) - start");
		}
		BuildPolicy returnBuildPolicy = null;
		if (c == RelativelySlowComputer.class) {
			returnBuildPolicy = new RelativelySlowComputer();
		} else if (c == RelativelySlowNetwork.class) {
			returnBuildPolicy = new RelativelySlowNetwork();
		} else if (c == TenToOne.class) {
			returnBuildPolicy = new TenToOne();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("factory(Class) - end");
		}
		return returnBuildPolicy;
	}
	
	/**
	 * Model compiling component locally. Increments
	 * total work done for BuildEntry
	 * 
	 * @param be the be
	 */
	abstract public void compile(BuildEntry be);

	/**
	 * Model transferring VM over network. Increments
	 * total work done for BuildEntry
	 * 
	 * @param be the be
	 */
	abstract public void transfer(BuildEntry be);

	/**
	 * Model getting a VM locally. Increments
	 * total work done for BuildEntry
	 * 
	 * @param be the be
	 */
	abstract public void getLocal(BuildEntry be);
	
	protected void sleepFor(long time)
	{
		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
