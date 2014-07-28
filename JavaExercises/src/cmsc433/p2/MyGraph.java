package cmsc433.p2;
import java.util.Set;

import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * The Class MyGraph. Provided.
 */
public class MyGraph {

	/** The real graph. */
	DirectedGraph<MyNode, MyEdge> realGraph;

	/**
	 * Instantiates a new my graph.
	 */
	public MyGraph() {
		realGraph = new DefaultDirectedGraph<MyNode, MyEdge>(MyEdge.class);
	}

	/**
	 * Adds the MyNode to this MyGraph.
	 * 
	 * @param n the n
	 */
	public void addNode(MyNode n) {
		realGraph.addVertex(n);
	}

	/**
	 * Adds the MyEdge to MyGraph.
		 * 
		 * @param e the e
	 */
	public void addEdge(MyEdge e) {
		realGraph.addEdge(e.getParent(), e.getChild(), e);
	}

	/**
	 * Gets the set of MyNodes in this MyGraph.
	 * 
	 * @return the node set
	 */
	public Set<MyNode> getNodeSet() {
		return realGraph.vertexSet();
	}

	/**
	 * Gets the set of MyEdges in this MyGraph.
	 * 
	 * @return the edge set
	 */
	public Set<MyEdge> getEdgeSet() {
		return realGraph.edgeSet();
	}

	/**
	 * Gets the set of MyEdges exiting a MyNode.
	 * 
	 * @param n the n
	 * 
	 * @return the out edges
	 */
	public Set<MyEdge> getOutEdges(MyNode n) {
		return realGraph.outgoingEdgesOf(n);
	}

	/**
	 * Gets the set of MyEdges entering a MyNode.
	 * 
	 * @param n the n
	 * 
	 * @return the in edges
	 */
	public Set<MyEdge> getInEdges(MyNode n) {
		return realGraph.incomingEdgesOf(n);
	}

	/**
	 * Gets the parent MyNode in a MyEdge.
	 * 
	 * @param e the e
	 * 
	 * @return the parent
	 */
	public MyNode getParent(MyEdge e) {
		return realGraph.getEdgeSource(e);
	}

	/**
	 * Gets the child MyNode in a MyEdge.
	 * 
	 * @param e the e
	 * 
	 * @return the child
	 */
	public MyNode getChild(MyEdge e) {
		return realGraph.getEdgeTarget(e);
	}

}
