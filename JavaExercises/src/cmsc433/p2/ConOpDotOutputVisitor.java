package cmsc433.p2;

/**
 * The Class ConOpDotOutputVisitor. Outputs ConOp as a DOT graph. Called by 
 * Conop.exportGraph().
 * Note: Can use ConOp.getID() to create unique node names for
 * DOT output. 
 */

public class ConOpDotOutputVisitor implements ConstraintVisitor {

        private ConOp conOp;
        private Boolean lastCheckResult;
        private static Integer conOpNumber = new Integer(0);
	/**
	 * Instantiates a new dot output visitor.
	 * 
	 * @param acdg
	 *            the acdg
	 */
	ConOpDotOutputVisitor() {
	    this.conOp = null;
	    this.lastCheckResult = Boolean.FALSE;
	}

    /**
     * Sets the ConOp to be output
     * @param c the ConOp to output
     */
	public void setConstraint(ConOp c) {
	    this.conOp = c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitor#doCheck()
	 */
	public void doCheck() {
	    this.lastCheckResult = Boolean.TRUE;
	    /* generate the header */
	    System.out.println("Digraph \"ConOp" + conOpNumber++ + "\"{");
	    this.conOp.accept(this);
	    System.out.println("}");
	}

	/**
	 * returns true is visit successfully completed.
	 * 
	 * @see cmsc433.p2.ACDGVisitor#isOk()
	 */
	public boolean isOk() {
	    return this.lastCheckResult.booleanValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.SELECTED)
	 */
	public void visit(SELECTED n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(NOTSELECTED n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(VERSION n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(EQ n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(NEQ n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(LEQ n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(GEQ n) {
	       /* print this node info and for every child op, generate an edge from this to child op */
            /* print node info */
            System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
            /* print edge info */
            for ( ConOp op : n.getOperands() )
            {
                System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
                op.accept(this);
            }
	}

	public void visit(ID n) {
	    System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.toString() + "\"]");
	}

	public void visit(IMPLIES n) {
	    /* print this node info and for every child op, generate an edge from this to child op */
	    /* print node info */
	    System.out.println(n.getOperator() + n.getID() + " [ label = \"" + n.getOperator() + "\"]");
	    /* print edge info */
	    for ( ConOp op : n.getOperands() )
	    {
	        System.out.println(n.getOperator() + n.getID() + " -> " + op.getOperator() + op.getID());
	        op.accept(this);
	    }
	}
}