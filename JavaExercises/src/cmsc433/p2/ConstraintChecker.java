package cmsc433.p2;

import java.util.List;

/**
 * The Class ConstraintChecker.
 */
class ConstraintChecker implements ConstraintVisitor {

        private ACDG acdg;
        private ACDG configAcdg;
        private ConOp conOp;
        private Boolean lastCheckResult;
        private Boolean isUndefined;
        private String id;
        private MyNode componentNode;
	/**
	 * Instantiates a new constraint checker.
	 * 
	 * @param acdg the original acdg
	 * @param config the configuration subgraph ACDG
	 */
	ConstraintChecker(ACDG acdg, ACDG configAcdg) {
	    /* how the hell is thing going to reference into the ACDG, I can't think that
	     * string match is going to be the only thing that will help me do the checking 
	     */
	    /* light at the end of the tunnel */
	    /* implement the visit method using the parameter acdg(s) to make sure that
	     * the two conforms
	     * still need to think about and identify if the second param is 
	     */
	    if ( (acdg == null ) || (configAcdg == null ))
	    {
	        throw new IllegalArgumentException("null constructur parameter(s) received");
	    }
	    this.acdg = acdg;
	    this.configAcdg = configAcdg;
	    this.conOp = null;
	    this.componentNode = null;
	    this.lastCheckResult = Boolean.TRUE;
	    this.isUndefined = Boolean.FALSE;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.SELECTED)
	 */
	public void visit(SELECTED n) {
	    System.out.println("visiting " + n.toString());
	    /* the logic is that if node n is not a node in the acdg then UNDEF else
	     * TRUE if ComponentNode is included in the current configuration. Otherwise FALSE.
	     * so it i sstarting to make sense now, if n is not in the original acdg then undef
	     * else if n is in the second (current config) acdg then true otherwise false
	     */
	    /*
	     * except for the fact that n is not a component node and I can't figure out how 
	     * to associate the node n with a component node in either of the two acdg(s)
	     * ;oaijfea;oijfeoi092183092183098213jfoaijfoiejo;eajg
	     * the secret lies in n.accept(this)
	     * this can contain any private attributes which will still be set when the visitor
	     * finish
	     * hehehehahaha
	     */
	    /*
	     * first visit the operands so that the name of the node could be identified
	     */
	    selectedVisitLogic(n);
	}
	
	

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.NOTSELECTED)
	 */
	public void visit(NOTSELECTED n) {
	    System.out.println("visiting " + n.toString());
	    /*
	     * undef if this node is not in the original acdg else not of selected logic
	     */
	    /* use the existing logic of selected to do the usual processing */
	    this.selectedVisitLogic(n);
	    /* negate the result of lastCheckResult to get the result of !SELECTED*/
	    this.lastCheckResult = this.lastCheckResult ^ Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.VERSION)
	 */
	public void visit(VERSION n) {
	    System.out.println("visiting " + n.toString());
	    /*
	     * so version node will contain an id in it but the id is the name of one of 
	     * the component node and not the actual conceptual version version
	     */
	    /*
	     * so I guess while visiting this node I have to iterate over the nodes in the config acdg
	     * and find the node in there and retrieve the version of that node
	     */
	    /*
	     * so I guess I should visit the operands of which there should be only one, after visiting I should have the
	     * component node name and I should use that name to find the node in the config acdg and retrieve the version
	     * information from it and set it as the class member
	     */
	    assert(n.getOperands().size() == 1);
	    /*
	     * first visit the operand so that the id would be set
	     */
	    /*
	     * UPDATE - changing the logic to depend on the logic of a 'SELECTED' constraint to do most of this
	     * work since all of this is already done in 'selected' and I've realized that selected is required
	     * logic for version
	     */
//	    n.getOperands().iterator().next().accept(this);
	    /*
             * now find the node in the config acdg whose name is the same as this id
             */
/*            String nodeVersion = null;
            assert(this.id != null);
            for ( MyNode node : this.configAcdg.getGraph().getNodeSet() )
            {
                if ( node.getName().equals(this.id) == true )
                {
                    nodeVersion = node.getVersions().iterator().next();
                }
            }
            if ( nodeVersion == null )
            {
                this.lastCheckResult = Boolean.FALSE;
            }
            else
            {
                this.lastCheckResult = Boolean.TRUE;
                this.id = nodeVersion;
            }*/
	    /*
	     * so the vesion operator contains an id op in it and that id op captures the information of the name of the 
	     * component node so we can simply take the component operator(s) of this version op and create a new selected
	     * operator with that
	     */
	    SELECTED sel = new SELECTED();
	    for (ConOp op : n.getOperands() )
	    {
	        sel.addOperand(op);
	    }
	    sel.accept(this);
	    /* now at this point the last check boolean value should be set, undef should be set, and the operator node should be set */
	    /* I don't see any need to do anything else at this point, can simply return */
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.EQ)
	 */
	public void visit(EQ n) {
	    System.out.println("visiting " + n.toString());
	    /*
	     * its operands could be two version ops or a version and an id op
	     */
	    /*
	     * so let's work on the first case that one of the operator is a verison and another is an id
	     */
	    /*
	     * we have to go through the selected logic to make sure that the the component node inside the version operator
	     * passes the selected constraint and then after that it will be easy to do comparison on the
	     * component version and id value that will be produced when visiting the version and id operators
	     */
	    /*
	     * the only thing left to identify is how to create and check the selected operator logic
	     */
	    /*
	     * should the selected check be happening inside the version operator visit??
	     */
	    /*
	     * yes
	     */
	    /* retrieve the two operands, visit them one by one, after visiting each check to make sure that UNDEF is not triggered,
	     * and capture the temporary id, then after visiting both compare the resulting ids for equality, and also need to keep
	     * in mind that if one of the operator is ID op then we have to check the version list to make sure that that id is in
	     * the version list
	     */
	    assert(n.getOperands().size() == 2);
	    ConOp firstOp = n.getOperands().get(0);
	    ConOp secondOp = n.getOperands().get(1);
	    firstOp.accept(this);
	    if ( this.isUndefined == true )
	    {
	        this.lastCheckResult = Boolean.FALSE;
	        return;
	    }
	    String firstVersion = this.id;
	    MyNode firstNode = this.componentNode;
	    this.componentNode = null;
	    secondOp.accept(this);
	    if ( this.isUndefined == true )
	    {
	        this.lastCheckResult = Boolean.FALSE;
	        return;
	    }
	    String secondVersion = this.id;
	    MyNode secondNode = this.componentNode;
	    /* if only one of the two node params are not null then one was an id and need to be one of the possible version of the
	     * component node
	     */
	    if ( firstNode == null )
	    {
	        if ( secondNode.getVersions().contains(firstVersion) == false )
	        {
	            this.lastCheckResult = Boolean.FALSE;
	            return;
	        }
	    }
	    else if ( secondNode == null )
	    {
	        if ( firstNode.getVersions().contains(secondVersion) == false )
	        {
	            this.lastCheckResult = Boolean.FALSE;
	            return;
	        }
	    }
	    /* now check the two versions and that should be the end of this method */
	    this.lastCheckResult = firstVersion.equals(secondVersion);
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.NEQ)
	 */
	public void visit(NEQ n) {
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.LEQ)
	 */
	public void visit(LEQ n) {
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.GEQ)
	 */
	public void visit(GEQ n) {
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.ID)
	 */
	public void visit(ID n) {
	    System.out.println("visiting " + n.toString());
	    /*
	     * nothing much to do other than to set the id in this node as the id class attribute and return
	     */
	    this.lastCheckResult = Boolean.TRUE;
	    this.id = n.toString();
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#visit(cmsc433.p2.IMPLIES)
	 */
	public void visit(IMPLIES n) {
	    System.out.println("visiting " + n.toString());
	    /*
	     * this conOp should contain two nested conOp(s) in it, if either of them is UNDEFINED then
	     * this is UNDEFINED otherwise evaluate the nested operators according to the general logic
	     */
	    List<ConOp> operators = n.getOperands();
	    ConOp first = operators.get(0);
	    ConOp second = operators.get(1);
	    /*
	     * visit the first, depending on the result maybe check the second
	     */
	    first.accept(this);
	    if ( this.isUndefined == true )
	    {
	        this.lastCheckResult = Boolean.FALSE;
	        return;
	    }
	    else
	    {
	        /* if the first part of the operator is not coming back undefined then the result of the test so far decide
	         * what should happen when testing the second part
	         */
	        boolean currentResult = this.isOk();
	        second.accept(this);
	        if ( this.isUndefined == true )
	        {
	            this.lastCheckResult = Boolean.FALSE;
	            return;
	        }
	        else
	        {
	            //if second check is also not undefined
	            if ( currentResult == true )
	            {
	                if ( this.lastCheckResult == true )
	                {
	                    return;
	                }
	            }
	            else
	            {
	                //if the first part was not true then the second part doesn't matter and the whole could be considered valid
	                this.lastCheckResult = Boolean.TRUE;
	                return;
	            }
	        }
	    }
	}

	public void setConstraint (ConOp c) {
	    this.conOp = c;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#doCheck()
	 */
	public void doCheck() {
	    /*
	     * okay so how do we do this, we have the original acdg, we have the
	     * new config acdg, now we have to iterate over all of the con-op
	     * and make sure they hold
	     */
	    /*
	     * the con-op(s) form a tree so we have to do this with the tree
	     * structure and implicit recursion in mind
	     */
	    /*
	     * I don't see and particular hierarchy in constraints as where was
	     * in the acdg due to which I had to visit them in a bfs order with
	     * the bottom node first, here i can visit them without worrying
	     * about any sturcture
	     */
	    /*
	     * I still can't properly grasp why I need both the original and config
	     * acdg to do this - got it, because the definition of some of the basic constraints
	     * like selected, notselected etc require checking the original acdg to check 
	     * whether the result could be UNDEF (if the component being checked does not
	     * exist in the original acdg)
	     */
	    /*
	     * okay so at this point I have the constraint tree that give me the information I need to check
	     * , I have the original and config acdg which will somehow help me decide if the constraint
	     * tree is satisfied by the config acdg or not, this is the part that I can't make any sense
	     * of, if I happen to run into a constaint sub-tree which is EQ(version(B), v0.4)
	     */
	    Constraints constraints = this.acdg.getConstraints();
	    for ( ConOp op : constraints.getConstraints() )
	    {
	        op.accept(this);
	    }
	    /* if someone used the setOp() method as well then check that operator as well */
	    if ( this.conOp != null )
	    {
	        this.conOp.accept(this);
	    }
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitor#isOk()
	 */
	public boolean isOk() {
	    return this.lastCheckResult;
	}
	
        private boolean checkIfNodeExistsByNameInACDG(String nodeName, ACDG acdg)
        {
    
            boolean found = false;
            for (MyNode node : acdg.getNodeSet())
            {
                if (node.getName().equals(nodeName) == true)
                {
                    found = true;
                }
            }
            return found;
        }
        
        private MyNode findNodeByNameInACDG(String nodeName, ACDG acdg)
        {
            MyNode node = null;
            for (MyNode n : acdg.getNodeSet())
            {
                if (n.getName().equals(nodeName) == true)
                {
                    node = n;
                }
            }
            return node;
        }
        
        /*
         * moving the logic of visiting a selected con-op out of the visit method so that this could be called
         * from the not-selected method as well
         */
        private void selectedVisitLogic(ConOp n)
        {
            if ( n.getOperands().size() != 1)
            {
                this.lastCheckResult = Boolean.FALSE;
                return;
            }
            n.getOperands().iterator().next().accept(this);
            if ( this.isOk() == false )
            {
                return;
            }
            String nodeName = this.id;
            /*
             * now that we have the name, iterate over all the node in the original acdg to check for UNDEF
             */
            if ( checkIfNodeExistsByNameInACDG(nodeName, this.acdg) == false )
            {
                this.isUndefined = Boolean.TRUE;
                return;
            }
            else
            {
                //found it in original acdg, now try to find it in the config
                if ( checkIfNodeExistsByNameInACDG(nodeName, this.configAcdg) == true )
                {
                    this.isUndefined = Boolean.FALSE;
                    this.lastCheckResult = Boolean.TRUE;
                    /* 
                     * should this node be the node from the original acdg or the config acdg??
                     * seems like if we are capturing the information of the version of this node
                     * in the current config acdg then we should be using the original acdg because
                     * that way we will not be losing any information and will only be returning more
                     * information
                     */
                    /* update the private id param to be the id of this node from the config acdg */
                    /* the name information of the node will be available through the componentNode member */
                    this.id = this.findNodeByNameInACDG(nodeName, configAcdg).getVersions().iterator().next();
                    this.componentNode = this.findNodeByNameInACDG(nodeName, this.acdg);
                }
                else
                {
                    this.isUndefined = Boolean.FALSE;
                    this.lastCheckResult = Boolean.FALSE;
                }
            }
        }
}