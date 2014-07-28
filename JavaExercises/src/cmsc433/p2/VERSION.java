package cmsc433.p2;

/**
 * The Class VERSION. Provided.
 */
public class VERSION extends ConOp {
	
	/**
	 * Instantiates a new vERSION.
	 */
	VERSION() {
		operator = "VERSION";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}