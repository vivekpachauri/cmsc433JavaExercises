package cmsc433.p2;

/**
 * Represents a selected operator. Provided.
 */
public class SELECTED extends ConOp {
	
	/**
	 * Instantiates a new SELECTED.
	 */
	SELECTED() {
		operator = "SELECTED";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}

}