package cmsc433.p2;

/**
 * The Interface ConstraintVisitable. Provided.
 */
public interface ConstraintVisitable {
	
	/**
	 * The visitor accept() method.
	 * 
	 * @param v the visitor
	 */
	public void accept(ConstraintVisitor v);
}