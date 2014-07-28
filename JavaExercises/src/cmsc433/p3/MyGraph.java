package cmsc433.p3;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Set;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.DepthFirstIterator;

/**
 * The Class MyGraph. Provided.
 */
public class MyGraph {
	
	/** Log4J Logger for this class. */
	private static final Logger logger = Logger.getLogger(MyGraph.class);

	/** The real graph. */
	DirectedGraph<BuildEntry, BuildEntryEdge> realGraph;

	/**
	 * Instantiates a new my graph.
	 */
	public MyGraph() {
		realGraph = new DefaultDirectedGraph<BuildEntry, BuildEntryEdge>(BuildEntryEdge.class);
	}

	/**
	 * Adds the BuildEntry to this MyGraph.
	 * 
	 * @param n the n
	 */
	public void addNode(BuildEntry n) {
		if (logger.isDebugEnabled()) {
			logger.info("addNode(BuildEntry) - start");
		}

		realGraph.addVertex(n);

		if (logger.isDebugEnabled()) {
			logger.info("addNode(BuildEntry) - end");
		}
	}

	/**
	 * Adds the BuildEntryEdge to MyGraph.
	 * 
	 * @param e the e
	 */
	public void addEdge(BuildEntryEdge e) {
		if (logger.isDebugEnabled()) {
			logger.info("addEdge(BuildEntryEdge) - start");
		}

		realGraph.addEdge(e.getParent(), e.getChild(), e);

		if (logger.isDebugEnabled()) {
			logger.info("addEdge(BuildEntryEdge) - end");
		}
	}

	/**
	 * Gets the set of BuildEntrys in this MyGraph.
	 * 
	 * @return the node set
	 */
	public Set<BuildEntry> getNodeSet() {
		if (logger.isDebugEnabled()) {
			logger.info("getNodeSet() - start");
		}

		Set <BuildEntry> returnSet = realGraph.vertexSet();
		if (logger.isDebugEnabled()) {
			logger.info("getNodeSet() - end");
		}
		return returnSet;
	}

	/**
	 * Gets the set of BuildEntryEdges in this MyGraph.
	 * 
	 * @return the edge set
	 */
	public Set<BuildEntryEdge> getEdgeSet() {
		if (logger.isDebugEnabled()) {
			logger.info("getEdgeSet() - start");
		}

		Set <BuildEntryEdge> returnSet = realGraph.edgeSet();
		if (logger.isDebugEnabled()) {
			logger.info("getEdgeSet() - end");
		}
		return returnSet;
	}

	/**
	 * Gets the set of BuildEntryEdges exiting a BuildEntry.
	 * 
	 * @param n the n
	 * 
	 * @return the out edges
	 */
	public Set<BuildEntryEdge> getOutEdges(BuildEntry n) {
		if (logger.isDebugEnabled()) {
			logger.info("getOutEdges(BuildEntry) - start");
		}

		Set <BuildEntryEdge> returnSet = realGraph.outgoingEdgesOf(n);
		if (logger.isDebugEnabled()) {
			logger.info("getOutEdges(BuildEntry) - end");
		}
		return returnSet;
	}

	/**
	 * Gets the set of BuildEntryEdges entering a BuildEntry.
	 * 
	 * @param n the n
	 * 
	 * @return the in edges
	 */
	public Set<BuildEntryEdge> getInEdges(BuildEntry n) {
		if (logger.isDebugEnabled()) {
			logger.info("getInEdges(BuildEntry) - start");
		}

		Set <BuildEntryEdge> returnSet = realGraph.incomingEdgesOf(n);
		if (logger.isDebugEnabled()) {
			logger.info("getInEdges(BuildEntry) - end");
		}
		return returnSet;
	}

	/**
	 * Gets the parent BuildEntry in a BuildEntryEdge.
	 * 
	 * @param e the e
	 * 
	 * @return the parent
	 */
	public BuildEntry getParent(BuildEntryEdge e) {
		if (logger.isDebugEnabled()) {
			logger.info("getParent(BuildEntryEdge) - start");
		}

		BuildEntry returnBuildEntry = realGraph.getEdgeSource(e);
		if (logger.isDebugEnabled()) {
			logger.info("getParent(BuildEntryEdge) - end");
		}
		return returnBuildEntry;
	}

	/**
	 * Gets the child BuildEntry in a BuildEntryEdge.
	 * 
	 * @param e the e
	 * 
	 * @return the child
	 */
	public BuildEntry getChild(BuildEntryEdge e) {
		if (logger.isDebugEnabled()) {
			logger.info("getChild(BuildEntryEdge) - start");
		}

		BuildEntry returnBuildEntry = realGraph.getEdgeTarget(e);
		if (logger.isDebugEnabled()) {
			logger.info("getChild(BuildEntryEdge) - end");
		}
		return returnBuildEntry;
	}
	
	/**
	 * Contains node.
	 * 
	 * @param be the be
	 * 
	 * @return true, if successful
	 */
	public boolean containsNode(BuildEntry be) {
		if (logger.isDebugEnabled()) {
			logger.info("containsNode(BuildEntry) - start");
		}

		boolean returnboolean = realGraph.containsVertex(be);
		if (logger.isDebugEnabled()) {
			logger.info("containsNode(BuildEntry) - end");
		}
		return returnboolean;
	}
	
	/**
	 * Contains and edge from e1 to e2.
	 * e1 (parent) -> e2 (child)
	 * 
	 * @param e1 the e1
	 * @param e2 the e2
	 * 
	 * @return true, if e1 -> e2 edge is in prefix tree.
	 */
	public boolean containsEdge(BuildEntry e1, BuildEntry e2) {
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntry, BuildEntry) - start");
		}

		boolean returnboolean = realGraph.containsEdge(e1, e2);
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntry, BuildEntry) - end");
		}
		return returnboolean;
	}

	/**
	 * Contains edge.
	 * 
	 * @param bee the BuildEntryEdge
	 * 
	 * @return true, if successful
	 */
	public boolean containsEdge(BuildEntryEdge bee) {
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntryEdge) - start");
		}

		boolean returnboolean = realGraph.containsEdge(bee);
		if (logger.isDebugEnabled()) {
			logger.info("containsEdge(BuildEntryEdge) - end");
		}
		return returnboolean;
	}
	
	/**
	 * Creates a node (as opposed to path) iterator.
	 * 
	 * @return the iterator< build entry>
	 */
	public Iterator<BuildEntry> createIterator() {
		if (logger.isDebugEnabled()) {
			logger.info("createIterator() - start");
		}

		Iterator <BuildEntry> returnIterator = new DepthFirstIterator<BuildEntry, BuildEntryEdge>(
			realGraph);
		if (logger.isDebugEnabled()) {
			logger.info("createIterator() - end");
		}
		return returnIterator;
	}

}
