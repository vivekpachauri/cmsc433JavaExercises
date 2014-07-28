package cmsc433.p2;

/**
 * Represents a notselected operator. Provided.
 */
public class NOTSELECTED extends ConOp {
	
	/**
	 * Instantiates a new NOTSELECTED.
	 */
	NOTSELECTED() {
		operator = "NOTSELECTED";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}