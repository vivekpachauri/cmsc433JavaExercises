package cmsc433.p2;
import java.util.*;

/**
 *Represents a set of configuration constraints. Provided.
 */
public class Constraints {
	
	/** The set of constraints. */
	private Set<ConOp> constraints = new HashSet<ConOp>();

	/**
	 * Adds a constraint.
	 * 
	 * @param c the ConOp
	 */
	public void addConstraint(ConOp c) {
		constraints.add(c);
	}

	/**
	 * Gets the set of constraints.
	 * 
	 * @return the constraints
	 */
	public Set<ConOp> getConstraints() {
		return constraints;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 */
	public String toString() {
		String outStr = "";
		for (ConOp c : constraints) {
			outStr = c.getOperator() + "(";
			for (int i = 0; i < c.getOperands().size() - 1; i++) {
			    outStr += c.getOperands().get(i) + ",";
			}
			outStr += c.getOperands().get(c.getOperands().size() - 1) + ")\n";
		}
		return outStr;
	}
}
