package cmsc433.p2;

/**
 * Represents an equals operator. Provided.
 */
public class EQ extends ConOp {
	
	/**
	 * Instantiates a new EQ.
	 */
	EQ() {
		operator = "EQ";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}