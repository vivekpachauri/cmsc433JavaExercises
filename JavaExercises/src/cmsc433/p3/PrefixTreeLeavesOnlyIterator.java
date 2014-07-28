package cmsc433.p3;

import java.util.List;

public class PrefixTreeLeavesOnlyIterator extends PrefixTreePathIterator {

	private PrefixTree pt;
	
	public PrefixTreeLeavesOnlyIterator(PrefixTree pt) {
		this.pt = pt;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BuildEntry> nextPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
