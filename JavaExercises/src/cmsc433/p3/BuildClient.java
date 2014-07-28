package cmsc433.p3;

import java.util.concurrent.CountDownLatch;

public class BuildClient implements Runnable {

	private CountDownLatch startGate, endGate;
	private JobPolicy jobPolicyFactory;
	private BuildPolicy buildPolicyFactory;
	private int cacheSize;
	
	public BuildClient(CountDownLatch startGate, CountDownLatch endGate,
			JobPolicy factory, BuildPolicy factory2, int cacheSize) {
		this.startGate = startGate;
		this.endGate = endGate;
		this.buildPolicyFactory = factory2;
		this.jobPolicyFactory = factory;
		this.cacheSize = cacheSize;
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException();
	}

}
