package cmsc433.p2;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ConOp. Provided.
 */
public abstract class ConOp implements ConstraintVisitable {
	
	/** The operator. */
	String operator;
	
	/** The operands. */
	List<ConOp> operands = new ArrayList<ConOp>();

	static int ref;
	private int ID; 
	/**
	 * Instantiates a new ConOp. Sets Unique ID.
	 */
	public ConOp() {
		this.ID = ref++; 
	}

	/**
	 * Gets the operands.
	 * 
	 * @return the operands
	 */
	public List<ConOp> getOperands() {
		return operands;
	}

	/**
	 * 
	 * @return the String representation of the 
	 * operator, Component Name or Version ID
	 * as appropriate. 
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Adds the operand.
	 * 
	 * @param op a ConOp to be added as an operand of this.
	 */
	public void addOperand(ConOp op) {
		operands.add(op);
	}

	/**
	 * @return ConOp ID
	 */
	public int getID () {
		return ID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 */
	public String toString() {
		String outStr = operator + "(";
		for (int i = 0; i < operands.size() - 1; i++) {
			outStr += operands.get(i) + ",";
		}
		outStr += operands.get(operands.size() - 1) + ")";
		return outStr;
	}
	
	/**
	 * Uses ConOpDotOutputVisitor to write the DOT-formatted ConOp to standard out. 
	 */
	public void exportGraph() {
		ConOpDotOutputVisitor pv = new ConOpDotOutputVisitor();
		pv.setConstraint(this);
		pv.doCheck();
	}
}