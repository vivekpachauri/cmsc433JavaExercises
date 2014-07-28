package cmsc433.p2;

/**
 * Represents a not equals operator. Provided.
 */
public class NEQ extends ConOp {
	
	/**
	 * Instantiates a new NEQ.
	 */
	NEQ() {
		operator = "NEQ";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}