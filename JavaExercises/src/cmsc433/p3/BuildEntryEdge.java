package cmsc433.p3;

import org.apache.log4j.Logger;

/**
 * The Class BuildEntryEdge. Provided.
 * 
 * One entry in the PrefixTree. Models one software component and version in a
 * configuration.
 */
public class BuildEntryEdge {
	
	/** Log4J Logger for this class. */
	private static final Logger logger = Logger.getLogger(BuildEntryEdge.class);

	/** The child. */
	private BuildEntry parent, child;

	/**
	 * Instantiates a new BuildEntryEdge.
	 * 
	 * @param child the child
	 * @param parent the parent
	 */
	public BuildEntryEdge(BuildEntry parent, BuildEntry child) {
		this.child = child;
		this.parent = parent;
	}

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public BuildEntry getParent() {
		if (logger.isDebugEnabled()) {
			logger.info("getParent() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.info("getParent() - end");
		}
		return parent;
	}

	/**
	 * Gets the child.
	 * 
	 * @return the child
	 */
	public BuildEntry getChild() {
		if (logger.isDebugEnabled()) {
			logger.info("getChild() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.info("getChild() - end");
		}
		return child;
	}
}
