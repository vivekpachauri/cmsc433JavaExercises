package cmsc433.p2;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class DagChecker. Checks that ACDG is 
 * cycle free.
 */
public class DagChecker implements ACDGVisitor {

        private ACDG acdg;
        private Boolean lastCheckResult;
	/**
	 * Instantiates a new DagChecker.
	 * 
	 * @param a the ACDG
	 */
	public DagChecker(ACDG a) {
	    this.acdg = a;
	    this.lastCheckResult = Boolean.FALSE;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.ComponentNode)
	 */
	public void visit(ComponentNode n) {
	    this.dagCheckerLogic(n);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationAndNode)
	 */
	public void visit(RelationAndNode n) {
	    this.dagCheckerLogic(n);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationXorNode)
	 */
	public void visit(RelationXorNode n) {
	    this.dagCheckerLogic(n);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#doCheck()
	 */
	public void doCheck() {
	    /*
	     * need to think about the logic of dag check.
	     * to check this if I am starting from a certain node then what I have to do is
	     * start with that node, start following the out edges and at every step keep checking if 
	     * we end up with the same node, seems very inefficient but since we have to do it what the hell
	     * but the overall logic of this method is going to be the same, iterate over all the nodes
	     * and call the accept method
	     */
	    this.lastCheckResult = Boolean.TRUE;
	    /*
	     * need to have an explicit test for a graph with a single node
	     */
	    if ( this.acdg.getNodeSet().size() == 1 )
	    {
	        this.lastCheckResult = Boolean.FALSE;
	        return;
	    }
            /* visit every node of the acdg */
             for ( MyNode node : this.acdg.getNodeSet())
             {
                 node.accept(this);
                 if ( this.isOk() == false )
                 {
                     return;
                 }
             }
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#isOk()
	 */
	public boolean isOk() {
	    return this.lastCheckResult.booleanValue();
	}
	       
        private void dagCheckerLogic(final MyNode n)
        {

            /*
             * I can see that the logic of dag checker is going to be the same for all the different types of
             * nodes therefore I can just implement it in this single method
             */
            
            /*
             * get the set of of outgoing edges
             */
            Set<MyEdge> outgoingEdges = this.acdg.getGraph().getOutEdges(n);
            
            /* while outgoing edges are not empty */
            while ( (outgoingEdges != null)  && (outgoingEdges.isEmpty() == false) )
            {
                Set<MyEdge> outgoingChildEdges = new HashSet<MyEdge>();
                for ( MyEdge edge : outgoingEdges )
                {
                    if ( edge.getChild().equals(n) == true )
                    {
                        this.lastCheckResult = Boolean.FALSE;
                        return;
                    }
                    else
                    {
                        /*
                         * for every outgoing edge get the child node
                         */
                        outgoingChildEdges.addAll(this.acdg.getGraph().getOutEdges(edge.getChild()));
                    }
                }
                outgoingEdges = outgoingChildEdges;
            }
        }
}