package cmsc433.p3;

public class TenToOne extends BuildPolicy {

	@Override
	public void compile(BuildEntry be) {
		this.sleepFor(100);
	}

	@Override
	public void transfer(BuildEntry be) {
		this.sleepFor(10);
	}

	@Override
	public void getLocal(BuildEntry be) {
		this.sleepFor(1);
	}

}
