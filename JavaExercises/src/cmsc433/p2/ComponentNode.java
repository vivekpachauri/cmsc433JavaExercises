package cmsc433.p2;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Component Node in the ACDG. Provided.
 */
public class ComponentNode extends MyNode {

	/**
	 * Instantiates a new Component Node.
	 * 
	 * @param n the n
	 */
	public ComponentNode(String n) {
		Name = n;
		Type = "Component";
		Versions = new ArrayList<String>();
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.MyNode#clone()
	 */
	public ComponentNode clone() {
		ComponentNode tmp = new ComponentNode(Name);
		for (String v : Versions) {
			tmp.addVersion(v);
		}
		return tmp;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.MyNode#addVersion(java.lang.String)
	 */
	public void addVersion(String v) {
		if (Versions == null) {
			Versions = new ArrayList<String>();
		}
		Versions.add(v);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Name + Type + Versions;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.MyNode#getName()
	 */
	public String getName() {
		return Name;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.MyNode#getType()
	 */
	public String getType() {
		return Type;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.MyNode#getVersions()
	 */
	public List<String> getVersions() {
		return Versions;
	}

	/* (non-Javadoc)
	 * @see cmsc433.p2.ACDGVisitable#accept(cmsc433.p2.ACDGVisitor)
	 */
	public void accept(ACDGVisitor v) {
		v.visit(this);
	}
}