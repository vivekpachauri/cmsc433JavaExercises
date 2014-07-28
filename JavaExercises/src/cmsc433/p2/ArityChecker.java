package cmsc433.p2;


/**
 * The Class ArityChecker. Checks that MyNodes have 
 * appropriate numbers of incoming and outgoing edges.
 */
public class ArityChecker implements ACDGVisitor {
    
        private ACDG acdg;
        private Boolean lastCheckResult;
        
	/**
	 * Instantiates a new ArityChecker.
	 * 
	 * @param acdg the ACDG to be checked.
	 */
	public ArityChecker(ACDG acdg) {
	    this.acdg = acdg;
	    this.lastCheckResult = Boolean.FALSE;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.ComponentNode)
	 */
	public void visit(ComponentNode n) {
	    /* if incoming edge set is not of size one or 0 then error */
	    int incomingEdgesNum = this.acdg.getGraph().getInEdges(n).size();
	    if ( (incomingEdgesNum != 1) && (incomingEdgesNum != 0))
	    {
	        this.lastCheckResult = Boolean.FALSE;
	    }
            int outgoingEdgesNum = this.acdg.getGraph().getOutEdges(n).size();	    
	    /* if outgoing edge set is not of size one or 0 then error */
            if ( (outgoingEdgesNum != 1) && (outgoingEdgesNum != 0))
	    {
	        this.lastCheckResult = Boolean.FALSE;
	    }
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationAndNode)
	 */
	public void visit(RelationAndNode n) {
	    this.relationNodeLogic(n);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationXorNode)
	 */
	public void visit(RelationXorNode n) {
	    this.relationNodeLogic(n);
	}
	
	private void relationNodeLogic(MyNode n)
	{
            if (this.acdg.getGraph().getInEdges(n).isEmpty())
            {
                this.lastCheckResult = Boolean.FALSE;
            }

            if (this.acdg.getGraph().getOutEdges(n).isEmpty())
            {
                this.lastCheckResult = Boolean.FALSE;
            }
	}

	/* (non-Javadoc)
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
	 * @see cmsc433.p2.ACDGVisitor#isOk()
	 */
	public boolean isOk() {
	    return this.lastCheckResult.booleanValue();
	}
}