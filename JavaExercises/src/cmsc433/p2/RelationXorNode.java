package cmsc433.p2;

/**
 * Represents an Xor Relation Node. Provided.
 */
public class RelationXorNode extends MyNode {

	/**
	 * Instantiates a new Relation:Xor node.
	 * 
	 * @param n the n
	 */
	public RelationXorNode(String n) {
		Name = n;
		Type = "Relation:Xor";
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.MyNode#clone()
	 */
	public RelationXorNode clone() {
		RelationXorNode tmp = new RelationXorNode(Name);
		return tmp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Name + Type;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitable#accept(cmsc433.p2.ACDGVisitor)
	 */
	public void accept(ACDGVisitor v) {
		v.visit(this);
	}
}