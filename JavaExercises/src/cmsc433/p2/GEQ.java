package cmsc433.p2;

/**
 * Represents a greater than or equals operator. Provided.
 */
public class GEQ extends ConOp {
	
	/**
	 * Instantiates a new GEQ.
	 */
	GEQ() {
		operator = "GEQ";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ConstraintVisitable#accept(cmsc433.p2.ConstraintVisitor)
	 */
	public void accept(ConstraintVisitor v) {
		v.visit(this);
	}
}