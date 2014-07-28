package cmsc433.p2;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class MyNode. Provided.
 */
public abstract class MyNode implements ACDGVisitable, Cloneable {
	
	/** The Name. */
	protected String Name;
	
	/** The Type. */
	protected String Type;
	
	/** The Versions. */
	protected List<String> Versions = new ArrayList<String>();

	/** 
	 * Creates a duplicate copy of this.
	 * @return the duplicate
	 */
	public abstract MyNode clone();

	/**
	 * Adds the version.
	 * 
	 * @param v the v
	 */
	public void addVersion(String v) {
	    this.Versions.add(v);
	}

	/**
	 * Removes the all versions.
	 */
	public void removeAllVersions() {
		Versions.clear();
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Gets the versions.
	 * 
	 * @return the versions
	 */
	public List<String> getVersions() {
		return Versions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		MyNode test = (MyNode) obj;
		return Name.equals(test.Name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == Name ? 0 : Name.hashCode());
		return hash;
	}
}