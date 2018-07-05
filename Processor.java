package Package;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Processor implements Runnable
{
	LinkedList <Process> readyProcessCPU= new LinkedList<>();
	JTextField TxtFieldCurrentProcess= new JTextField();	
	JTextArea TxtAreaReadyProcess= new JTextArea();	
	ArrayList<Process> finishedProcessCPU = new ArrayList<Process>();
	JTextArea TxtFinishedProcessCPU=new JTextArea();
	JButton Retray= new JButton();
	JButton KillProcess= new JButton();
	JButton AddProcess= new JButton();
	private Thread t;
	private int sleepTime;
	int i,j;

	public Processor(JButton AddProcess, JButton KillProcess, JButton Retray,LinkedList<Process> readyProcessCPU,JTextArea TxtAreaReadyProcess ,
			JTextField TxtFieldCurrentProcess, 	ArrayList<Process> finishedProcessCPU,JTextArea txtFinishedProcessCPU, String name, int sleepTime, int i, int j) 
	{
		super();
		this.AddProcess=AddProcess;
		this.KillProcess=KillProcess;
		this.Retray=Retray;
		this.readyProcessCPU = readyProcessCPU;
		this.TxtAreaReadyProcess=TxtAreaReadyProcess;
		this.TxtFieldCurrentProcess = TxtFieldCurrentProcess;
		this.finishedProcessCPU = finishedProcessCPU;
		TxtFinishedProcessCPU = txtFinishedProcessCPU;
		t= new Thread(this, name);
		this.sleepTime = sleepTime;
		this.i = i;
		this.j = j;
	}

	public void start()
	{
		t.start();
	}	
	
	public void run()
	{	
		Dispatcher dispatcherOne = new  Dispatcher(readyProcessCPU,TxtAreaReadyProcess ,TxtFieldCurrentProcess,i,j,finishedProcessCPU,TxtFinishedProcessCPU);		
		for(;readyProcessCPU.size()>0;)
		{
    		try
			{				 
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e)
			{}	
    			dispatcherOne.fire();
		}
		
		TxtAreaReadyProcess.setText("The processor has successfully fininshed all the processes!");
		TxtFieldCurrentProcess.setText("This core is free!");
		Retray.setEnabled(true);
		KillProcess.setEnabled(false);
		AddProcess.setEnabled(false);
		
		
	}
	

}	
			
	






