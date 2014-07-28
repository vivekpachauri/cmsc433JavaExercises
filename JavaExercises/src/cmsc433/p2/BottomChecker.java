package cmsc433.p2;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class BottomChecker. Checks that all 
 * MyNodes reach BOTTOM.
 */
public class BottomChecker implements ACDGVisitor {

        private ACDG acdg;
        private Boolean lastCheckResult;
	/**
	 * Instantiates a new bottom checker.
	 * 
	 * @param acdg the ACDG to be checked.
	 */
	public BottomChecker(ACDG acdg) {
	    this.acdg = acdg;
	    this.lastCheckResult = Boolean.FALSE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.ComponentNode)
	 */
	public void visit(ComponentNode n) {
	    /* the only thing different when visiting a component node as compared to
	     * relation node is that we have to check if this node is itself the bottom node
	     */
	    if ( n.equals(this.acdg.getBottom()) == true )
	    {
	        return;
	    }
	    else
	    {
	        //else do the logic of checking if we can reach the bottom node from this node
	        this.bottomCheckerLogic(n);
	    }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationAndNode)
	 */
	public void visit(RelationAndNode n) {
	    this.bottomCheckerLogic(n);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationXorNode)
	 */
	public void visit(RelationXorNode n) {
	    this.bottomCheckerLogic(n);
	}
	
	private void bottomCheckerLogic(MyNode node)
	{
            /* check if this node could be reached from the top node */
            Set<MyEdge> outEdges = this.acdg.getGraph().getOutEdges(node);
            
            /* keep looping while we have a parent to this node */
            while ( outEdges != null && (outEdges.isEmpty() == false ))
            {
                Set<MyEdge> outEdgesForChilds = new HashSet<MyEdge>();
                /* for every edge check if the target node is same as the bottom node */
                for ( MyEdge edge : outEdges )
                {
                    if ( edge.getChild().equals(this.acdg.getBottom()) == true )
                    {
                        /* if so then simply return */
                        return;
                    }
                    else
                    {
                        /* else add the in edges for the parent node to the right in edges variable */
                        outEdgesForChilds.addAll(this.acdg.getGraph().getOutEdges(edge.getChild()));
                    }
                }
                /* in the end of the loop update the inedges */
                outEdges = outEdgesForChilds;
            }
            /* if the loop ended and we haven't touched the bottom node then set error condition */
            outEdges = null;
            this.lastCheckResult = Boolean.FALSE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitor#doCheck()
	 */
	public void doCheck() {

            /* set the check result to true, if anything goes wrong during the check then this
             * will be set to false, otherwise if everything goes well then this will remain true
             */
            this.lastCheckResult = Boolean.TRUE;
               /* visit every node of the acdg */
            for ( MyNode node : this.acdg.getNodeSet())
            {
                node.accept(this);
            }
        
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitor#isOk()
	 */
	public boolean isOk() {
	    return this.lastCheckResult.booleanValue();
	}
}