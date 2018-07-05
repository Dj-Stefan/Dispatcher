//klasa proces sa svojim atributima i metodama get i set
package Package;
public class Process
{
	private int ID;
	private String name;
	private int priority;
	private int timeExecutionProcess;
	public Process() 
	{
		super();
	}
	
	public Process(int ID,String name, int priority, int timeExecutionProcess) 
	{
		super();
		this.ID=ID;
		this.name = name;
		this.priority = priority;
		this.timeExecutionProcess = timeExecutionProcess;
	}

	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeExecutionProcess() {
		return timeExecutionProcess;
	}

	public void setTimeExecutionProcess(int timeExecutionProcess) {
		this.timeExecutionProcess = timeExecutionProcess;
	}

	@Override
	public String toString() {
		return "ID: " + ID + ", " + name + ", " + priority + ", "+ timeExecutionProcess+"\n";
	}

	
}
