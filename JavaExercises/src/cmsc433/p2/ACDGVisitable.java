package cmsc433.p2;

/**
 * The Interface ACDGVisitable. Provided.
 */
public interface ACDGVisitable {
	
	/**
	 * Accept.
	 * 
	 * @param v the visitor
	 */
	public void accept(ACDGVisitor v);
}