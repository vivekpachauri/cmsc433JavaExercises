package cmsc433.p2;

import java.util.Iterator;

/**
 * The Class DotOutputVisitor.
 */
public class ACDGDotOutputVisitor implements ACDGVisitor {

        private ACDG acdg;
        private static Integer acdgNumber = new Integer(0);
        private Boolean lastCheckResult;
	/**
	 * Instantiates a new ACDG dot output visitor.
	 * 
	 * @param acdg the acdg
	 */
	ACDGDotOutputVisitor(ACDG acdg) {
	    this.acdg = acdg;
	    this.lastCheckResult = Boolean.FALSE;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.ComponentNode)
	 */
	public void visit(ComponentNode n) {
	    System.out.print(n.getName() + " [label = \"" + n.getName() + " \\n Component \\n[");
	    Iterator<String> iter = n.getVersions().iterator();
	    while ( iter.hasNext() == true)
	    {
	        System.out.print(iter.next());
	        if ( iter.hasNext() == true )
	        {
	            System.out.print(",");
	        }
	    }
	    System.out.println("]\"]");
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationAndNode)
	 */
	public void visit(RelationAndNode n) {
            System.out.println(n.getName() + " [label = \""+ n.getName() + " \\n " + n.getType() + "\"]");
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#visit(cmsc433.p2.RelationXorNode)
	 */
	public void visit(RelationXorNode n) {
            System.out.println(n.getName() + " [label = \""+ n.getName() + " \\n " + n.getType() + "\"]");
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitor#doCheck()
	 */
	public void doCheck() {
	    this.lastCheckResult = Boolean.TRUE;
	    /* generate the header info */
	    System.out.println("Digraph \"ACDG" + acdgNumber++ + "\"{");
	    /* generate the constraint info */
	    System.out.println("graph [");
	    System.out.print("label = \"");
	    /* top */
	    System.out.print("TOP:" +this.acdg.getTop().getName() + "\\n");
	    
	    /* botton */
	    System.out.print("BOTTOM:" + this.acdg.getBottom().getName() + "\\n");
	    
	    /*constraints*/
	    Iterator<ConOp> iterator = this.acdg.getConstraints().getConstraints().iterator();
	    if ( iterator.hasNext() == true )
	    {
	        System.out.print("Constraints:\\n");
	        while (iterator.hasNext() == true )
	        {
	            System.out.print(iterator.next().toString());
	            if ( iterator.hasNext() == true )
	            {
	                System.out.print(",");
	            }
	        }
	    }
	    /* \n and terminate the line */
	    System.out.println("\\n\"");
	    /* close off the ] */
	    System.out.println("]\n\n");
	    
	    for ( MyNode node : this.acdg.getNodeSet() )
            {
                node.accept(this);
            }
            
            for ( MyEdge edge : this.acdg.getEdgeSet() )
            {
                System.out.println(edge.getParent().getName() + " -> " + edge.getChild().getName());
            }
            System.out.println("}");
	}

	/**
	 * returns true if last doCheck() successfully completed.
	 */
	public boolean isOk() {
	    return this.lastCheckResult.booleanValue();
	}

}