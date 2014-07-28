package cmsc433.p2;

/**
 * The Interface ACDGVisitor. Provided.
 */
public interface ACDGVisitor {
	
	/**
	 * Visit.
	 * 
	 * @param n the MyNode
	 */
	public void visit(ComponentNode n);

	/**
	 * Visit.
	 * 
	 * @param n the MyNode
	 */
	public void visit(RelationAndNode n);

	/**
	 * Visit.
	 * 
	 * @param n the MyNode
	 */
	public void visit(RelationXorNode n);

	/**
	 * Run the visitor.
	 */
	public void doCheck();

	/**
	 * Returns result of last doCheck() run.
	 */
	public boolean isOk();
}
