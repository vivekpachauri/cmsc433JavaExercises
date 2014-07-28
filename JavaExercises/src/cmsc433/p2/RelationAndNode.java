package cmsc433.p2;


/**
 * Represents an AND Relation Node. Provided.
 */
public class RelationAndNode extends MyNode {

	/**
	 * Instantiates a new Relation:And MyNode.
	 * 
	 * @param n
	 *            the n
	 */
	public RelationAndNode(String n) {
		Name = n;
		Type = "Relation:And";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.MyNode#clone()
	 */
	public RelationAndNode clone() {
		RelationAndNode tmp = new RelationAndNode(Name);
		return tmp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Name + Type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmsc433.p2.ACDGVisitable#accept(cmsc433.p2.ACDGVisitor)
	 */
	public void accept(ACDGVisitor v) {
		v.visit(this);
	}
}