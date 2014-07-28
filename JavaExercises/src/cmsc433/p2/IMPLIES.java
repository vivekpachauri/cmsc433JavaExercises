package cmsc433.p2;

/**
 * Represents an IMPLIES operator. Provided.
 */
public class IMPLIES extends ConOp {

	/**
	 * Instantiates a new IMPLIES.
	 */
	IMPLIES() {
		operator = "IMPLIES";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}
