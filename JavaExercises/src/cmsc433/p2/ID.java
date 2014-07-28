package cmsc433.p2;

/**
 * Represents a Component Name or Version ID. Provided.
 */
public class ID extends ConOp {
	
	/** The val. */
	String val;

	/**
	 * Instantiates a new ID.
	 * 
	 * @param val the literal Component Name or Version ID
	 */
	public ID(String val) {
		operator = "ID";
		this.val = val;
	}

	/**
	 * @return the literal Component Name or Version ID
	 */
	public String toString() {
		return val;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}