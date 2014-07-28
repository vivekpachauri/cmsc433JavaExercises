package cmsc433.p2;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class TopChecker. Checks that all ACDG nodes
 * are reachable from TOP.
 */
public class TopChecker implements ACDGVisitor {

        private ACDG acdg;
        private Boolean previousCheckResult;
	/**
	 * Instantiates a new top checker.
	 * 
	 * @param acdg the acdg
	 */
	public TopChecker(ACDG acdg) {
	    this.acdg = acdg;
	    this.previousCheckResult = Boolean.FALSE;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.ComponentNode)
	 */
	public void visit(ComponentNode n) {
	    if ( n.equals(this.acdg.getTop()) == true )
	    {
	        return;
	    }
	    else
	    {
	        topCheckLogic(n);
	    }
	}
	
	private void topCheckLogic(MyNode node)
	{

            /* check if this node could be reached from the top node */
            Set<MyEdge> inEdges = this.acdg.getGraph().getInEdges(node);
            
            /* keep looping while we have a parent to this node */
            while ( inEdges != null && (inEdges.isEmpty() == false ))
            {
                Set<MyEdge> inEdgesForParents = new HashSet<MyEdge>();
                /* for every in edge check if the source node is same as the top node */
                for ( MyEdge edge : inEdges )
                {
                    if ( edge.getParent().equals(this.acdg.getTop()) == true )
                    {
                        /* if so then simply return */
                        return;
                    }
                    else
                    {
                        /* else add the in edges for the parent node to the right in edges variable */
                        inEdgesForParents.addAll(this.acdg.getGraph().getInEdges(edge.getParent()));
                    }
                }
                /* in the end of the loop update the inedges */
                inEdges = inEdgesForParents;
            }
            /* if the loop ended and we haven't touched the top node then set error condition */
            inEdges = null;
            this.previousCheckResult = Boolean.FALSE;
        
	}
	
	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationAndNode)
	 */
	public void visit(RelationAndNode n) {
	    this.topCheckLogic(n);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationXorNode)
	 */
	public void visit(RelationXorNode n) {
	    this.topCheckLogic(n);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#doCheck()
	 */
	public void doCheck() {
	    /* set the check result to true, if anything goes wrong during the check then this
	     * will be set to false, otherwise if everything goes well then this will remain true
	     */
	    this.previousCheckResult = Boolean.TRUE;
	       /* visit every node of the acdg */
	    for ( MyNode node : this.acdg.getNodeSet())
	    {
	        node.accept(this);
	    }
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#isOk()
	 */
	public boolean isOk() {
	    return this.previousCheckResult.booleanValue();
	}

}