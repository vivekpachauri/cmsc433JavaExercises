package cmsc433.p2;

/**
 * The Class MyEdge. Provided.
 */
public class MyEdge {
	
	/** The parent & child nodes. */
	private final MyNode parent, child;

	/**
	 * Instantiates a new MyEdge.
	 * 
	 * @param p the parent MyNode
	 * @param c the child MyNode
	 */
	public MyEdge(MyNode p, MyNode c) {
		parent = p;
		child = c;
	}

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public MyNode getParent() {
		return parent;
	}

	/**
	 * Gets the child.
	 * 
	 * @return the child
	 */
	public MyNode getChild() {
		return child;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		MyEdge test = (MyEdge) obj;
		return ((parent != null && parent.equals(test.parent)) && (child != null && child
				.equals(test.child)));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == parent ? 0 : parent.hashCode());
		hash = 31 * hash + (null == child ? 0 : child.hashCode());
		return hash;
	}
	
	public String toString()
	{
	    return this.parent.toString() + "->" + this.child.toString();
	}
}