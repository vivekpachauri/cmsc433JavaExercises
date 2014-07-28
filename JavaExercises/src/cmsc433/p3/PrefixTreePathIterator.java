package cmsc433.p3;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * The Class PrefixTreePathIterator. Provided.
 * 
 * The parent class for implemenations of PrefixTreePathIterator.
 */
public abstract class PrefixTreePathIterator {

	/** Log4J Logger for this class. */
	static final Logger logger = Logger.getLogger(PrefixTreePathIterator.class);

	/**
	 * Factory class. Build class instance based on Class object.
	 * Works correctly only for PrefixTreeLeavesOnlyIterator and 
	 * PrefixTreeDepthFirstIterator.
	 * 
	 * @param c
	 *            the Class to be instantiated
	 * @param pt
	 *            the pt
	 * 
	 * @return the prefix tree path iterator
	 */
	public static PrefixTreePathIterator factory(
			Class<? extends PrefixTreePathIterator> c, PrefixTree pt) {
		if (logger.isDebugEnabled()) {
			logger.debug("factory(Class, PrefixTree) - start");
		}
		PrefixTreePathIterator returnPrefixTreePathIterator = null;
		if (c == PrefixTreeLeavesOnlyIterator.class) {
			returnPrefixTreePathIterator = new PrefixTreeLeavesOnlyIterator(pt);
		} else if (c == PrefixTreeDepthFirstIterator.class) {
			returnPrefixTreePathIterator = new PrefixTreeDepthFirstIterator(pt);
		}
		return returnPrefixTreePathIterator;
	}

	/**
	 * Checks for next.
	 * 
	 * @return true, if successful
	 */
	abstract public boolean hasNext();

	/**
	 * Next path.
	 * 
	 * @return the list< build entry>
	 */
	abstract public List<BuildEntry> nextPath();
}
