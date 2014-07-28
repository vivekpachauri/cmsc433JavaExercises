package cmsc433.p3;

public class BuildEntry {

	private String name;
	private BuildState state;
	private long workDone;
	
	public BuildEntry(String name)
	{
		this.name = name;
		this.state = BuildState.New;
		this.workDone = 0;
	}
	
	public long getWorkDone() {
		return this.workDone;
	}
	
	public void addWorkDone(long newWork)
	{
		this.workDone += newWork;
	}
	
	public void setState(BuildState state)
	{
		this.state = state;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public BuildState getState()
	{
		return this.state;
	}
	
	public void waitFor(BuildState st)
	{
		while ( this.state != st)
		{
			
		}
	}
	
	public String toString()
	{
		return "[" + getName() + "," + getState() + "," + getWorkDone() + "]";
	}

}
