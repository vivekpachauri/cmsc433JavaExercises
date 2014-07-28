package cmsc433.p2;

/**
 * The Class LEQ. Provided.
 */
public class LEQ extends ConOp {
	
	/**
	 * Instantiates a new LEQ.
	 */
	LEQ() {
		operator = "LEQ";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}