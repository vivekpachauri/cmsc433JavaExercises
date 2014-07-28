package cmsc433.p2;

/**
 * The Interface ConstraintVisitor. Provided.
 */
public interface ConstraintVisitor {
	
	/**
	 * Visit SELECTED.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(SELECTED n);

	/**
	 * Visit NOTSELECTED.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(NOTSELECTED n);

	/**
	 * Visit VERSION.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(VERSION n);

	/**
	 * Visit EQ.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(EQ n);

	/**
	 * Visit NEQ n.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(NEQ n);

	/**
	 * Visit LEQ.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(LEQ n);

	/**
	 * Visit GEQ.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(GEQ n);

	/**
	 * Visit ID.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(ID n);

	/**
	 * Visit IMPLIES.
	 * 
	 * @param n the ConOp  to visit
	 */
	public void visit(IMPLIES n);

	/**
	 * Check whether a constraint holds over a configuration.
	 * Assumes setConstraint() has already been called.
	 */
	public void doCheck();

	/**
	 * Returns result of last doCheck() run.
	 * 
	 * @return true, if constraint holds (is not violated)
	 */
	public boolean isOk();

	/**
	 * Sets the root ConOp. The root ConOp represents
	 * the constraint to be checked.
	 */
	public void setConstraint(ConOp lc);
}
