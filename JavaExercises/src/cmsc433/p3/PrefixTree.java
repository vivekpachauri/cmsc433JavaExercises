package cmsc433.p3;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class PrefixTree. Partially provided.
 * 
 * A tree of configurations with build order information.
 */
public class PrefixTree {

	/** Log4J Logger for this class. */
	private static final Logger logger = Logger.getLogger(PrefixTree.class);

	/** The singleton instance of PrefixTree. */
	public static PrefixTree instance = null;
	
	private MyGraph graph = new MyGraph();

	/**
	 * Creates a singleton PrefixTree.
	 * 
	 * @param fileName
	 *            the file name in which the PrefixTree is stored.
	 */
	public static void create(String fileName) {
	}

	/**
	 * Instantiates a new prefix tree.
	 * 
	 * @param fileName
	 *            the file name
	 */
	private PrefixTree(String fileName) {
	}

	/**
	 * Adds a path iterator. PrefixTree can contain only one path iterator at a
	 * time.
	 * 
	 * @param pi
	 *            the pi
	 */
	public void addPathIterator(PrefixTreePathIterator pi) {
	}

	/**
	 * Creates a node (as opposed to path) iterator.
	 * 
	 * 
	 * @return the iterator< BuildEntry>
	 */

	/**
	 * Gets the root.
	 * 
	 * @return the root
	 */
	public BuildEntry getRoot() {
		throw new UnsupportedOperationException();
	}


	public Iterator<BuildEntry> createIterator() {
		if (logger.isDebugEnabled()) {
			logger.info("createIterator() - start");
		}

		Iterator<BuildEntry> returnIterator = graph.createIterator();
		if (logger.isDebugEnabled()) {
			logger.info("createIterator() - end");
		}
		return returnIterator;
	}

	/**
	 * Adds the BuildEntry to this PrefixTree.
	 * 
	 * @param be
	 *            the BuildEntry
	 */
	public void addNode(BuildEntry be) {
		if (logger.isDebugEnabled()) {
			logger.info("addNode(BuildEntry) - start");
		}
		graph.addNode(be);
		if (logger.isDebugEnabled()) {
			logger.info("addNode(BuildEntry) - end");
		}
	}

	/**
	 * Adds the BuildEntryEdge to PrefixTree.
	 * 
	 * @param bee
	 *            the BuildEntryEdge to insert
	 */
	public void addEdge(BuildEntryEdge bee) {
		if (logger.isDebugEnabled()) {
			logger.info("addEdge(BuildEntryEdge) - start");
		}
		graph.addEdge(bee);
		if (logger.isDebugEnabled()) {
			logger.info("addEdge(BuildEntryEdge) - end");
		}
	}

	/**
	 * Gets the set of MyNodes in this PrefixTree.
	 * 
	 * @return the node set
	 */
	public Set<BuildEntry> getNodeSet() {
		if (logger.isDebugEnabled()) {
			logger.info("getNodeSet() - start");
		}
		Set<BuildEntry> returnSet = graph.getNodeSet();
		if (logger.isDebugEnabled()) {
			logger.info("getNodeSet() - end");
		}
		return returnSet;
	}

	/**
	 * Gets the set of MyEdges in this PrefixTree.
	 * 
	 * @return the edge set
	 */
	public Set<BuildEntryEdge> getEdgeSet() {
		if (logger.isDebugEnabled()) {
			logger.info("getEdgeSet() - start");
		}
		Set<BuildEntryEdge> returnSet = graph.getEdgeSet();
		if (logger.isDebugEnabled()) {
			logger.info("getEdgeSet() - end");
		}
		return returnSet;
	}

	/**
	 * Gets the set of MyEdges exiting a BuildEntry.
	 * 
	 * @param be
	 *            the BuildEntry
	 * 
	 * @return the out edges
	 */
	public Set<BuildEntryEdge> getOutEdges(BuildEntry be) {
		if (logger.isDebugEnabled()) {
			logger.info("getOutEdges(BuildEntry) - start");
		}
		Set<BuildEntryEdge> returnSet = graph.getOutEdges(be);
		if (logger.isDebugEnabled()) {
			logger.info("getOutEdges(BuildEntry) - end");
		}
		return returnSet;
	}

	/**
	 * Gets the set of MyEdges entering a BuildEntry.
	 * 
	 * @param be
	 *            the BuildEntry
	 * 
	 * @return the in edges
	 */
	public Set<BuildEntryEdge> getInEdges(BuildEntry be) {
		if (logger.isDebugEnabled()) {
			logger.info("getInEdges(BuildEntry) - start");
		}
		Set<BuildEntryEdge> returnSet = graph.getInEdges(be);
		if (logger.isDebugEnabled()) {
			logger.info("getInEdges(BuildEntry) - end");
		}
		return returnSet;
	}

	/**
	 * Gets the parent BuildEntry in a BuildEntryEdge.
	 * 
	 * @param bee
	 *            the BuildEntryEdge
	 * 
	 * @return the parent
	 */
	public BuildEntry getParent(BuildEntryEdge bee) {
		if (logger.isDebugEnabled()) {
			logger.info("getParent(BuildEntryEdge) - start");
		}
		BuildEntry returnBuildEntry = graph.getParent(bee);
		if (logger.isDebugEnabled()) {
			logger.info("getParent(BuildEntryEdge) - end");
		}
		return returnBuildEntry;
	}

	/**
	 * Gets the child BuildEntry in a BuildEntryEdge.
	 * 
	 * @param bee
	 *            the BuildEntryEdge
	 * 
	 * @return the child
	 */
	public BuildEntry getChild(BuildEntryEdge bee) {
		if (logger.isDebugEnabled()) {
			logger.info("getChild(BuildEntryEdge) - start");
		}
		BuildEntry returnBuildEntry = graph.getChild(bee);
		if (logger.isDebugEnabled()) {
			logger.info("getChild(BuildEntryEdge) - end");
		}
		return returnBuildEntry;
	}

	/**
	 * Contains node.
	 * 
	 * @param be
	 *            the BuildEntry
	 * 
	 * @return true, if successful
	 */
	public boolean containsNode(BuildEntry be) {
		if (logger.isDebugEnabled()) {
			logger.info("containsNode(BuildEntry) - start");
		}
		boolean returnboolean = graph.containsNode(be);
		if (logger.isDebugEnabled()) {
			logger.info("containsNode(BuildEntry) - end");
		}
		return returnboolean;
	}

	/**
	 * Contains and edge from e1 to e2. e1 (parent) -> e2 (child)
	 * 
	 * @param e1
	 *            the e1
	 * @param e2
	 *            the e2
	 * 
	 * @return true, if e1 -> e2 edge is in prefix tree.
	 */
	public boolean containsEdge(BuildEntry e1, BuildEntry e2) {
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntry, BuildEntry) - start");
		}
		boolean returnboolean = graph.containsEdge(e1, e2);
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntry, BuildEntry) - end");
		}
		return returnboolean;
	}

	/**
	 * Contains edge.
	 * 
	 * @param bee
	 *            the BuildEntryEdge
	 * 
	 * @return true, if successful
	 */
	public boolean containsEdge(BuildEntryEdge bee) {
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntryEdge) - start");
		}
		boolean returnboolean = graph.containsEdge(bee);
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntryEdge) - end");
		}
		return returnboolean;
	}

	/**
	 * Gets the next job. Returns null when no new jobs are available.
	 * 
	 * @return the List<BuildEntry> representing a path in the PrefixTree
	 */
	public List<BuildEntry> nextJob() {
		throw new UnsupportedOperationException();
	}
}
