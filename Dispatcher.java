//predstavlja resenje problema i poziva se u klasi Processor
package Package;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Dispatcher 
{
	LinkedList <Process> readyProcess= new LinkedList<>();
	
	ArrayList<Process> finishedProcess = new ArrayList<>();
	
	JTextField TxtFieldExe = new JTextField();
	JTextArea TxtAreaFinished = new JTextArea();
	JTextArea TxtAreaReady = new JTextArea();
	int i,j;
		public Dispatcher(LinkedList <Process> readyProcess,JTextArea TxtAreaReady, JTextField TxtFieldExe, int i, int j, ArrayList<Process> finishedProcess,
				JTextArea TxtAreaFinished)
			{
				super();
				this.readyProcess = readyProcess;
				this.TxtAreaReady=TxtAreaReady;
				this.TxtFieldExe = TxtFieldExe;
				this.i=i;
				this.j=j;
				this.finishedProcess = finishedProcess;
				this.TxtAreaFinished=TxtAreaFinished;
			}
		
		public void fire()
		{
			TxtAreaReady.setText(readyProcess+"");
		
    		Process pom;
    		int s,t;
    		
    		for (s=0;s<readyProcess.size()-1;s++)		//procesi koji su spremni za obradu sortiraju se u svakoj iteraciji, tako da je najveci prioritet uvek na prvom mestu
    			for(t=s+1;t<readyProcess.size();t++)
    				
    				if(readyProcess.get(s).getPriority() >= readyProcess.get(t).getPriority())
    				{
    					pom = readyProcess.get(s);
    					readyProcess.set(s,readyProcess.get(t));
    					readyProcess.set(t, pom);							
    				} 
    		
			int p=0,l=0;
			
			if(j>readyProcess.size()-1)		//proverava da li postoje procesi u listi cekanja, (i) i (j) parametri koji su znacajni za broj jezgara
				{ i=0; 	j=0; }
			else 
			{
				if(readyProcess.get(i).getPriority()<=readyProcess.get(j).getPriority()) //posto su sortirani provera se vrsi samo na dva susedna procesa
				{
					readyProcess.get(i).setPriority(readyProcess.get(i).getPriority()+1);
					readyProcess.get(i).setTimeExecutionProcess(readyProcess.get(i).getTimeExecutionProcess()-200);
					
					
					
					if(readyProcess.get(i).getTimeExecutionProcess()<=0)	//ukoliko je proces zavrsen
					{
						readyProcess.get(i).setTimeExecutionProcess(0);
						for(int k=0;k<finishedProcess.size();k++)
						{
							if(readyProcess.get(i).getName()==(finishedProcess.get(k).getName()))	//proverava da li postoje isti proces u listi cekanja kao i u listi zavesenih
								{						
									l=1;	
									break; 	//zaustavlja se petlja
								}
							else 
								{
									l=0;	
									p++;	
								}
						}					
						
						if(l==0) 
						{
							finishedProcess.add(readyProcess.get(i));
							TxtAreaFinished.append(finishedProcess.get(p).toString()+"");
							readyProcess.remove(i);	
						
						}
					}
					else
						TxtFieldExe.setText(readyProcess.get(i)+"");
					
				}
			}
					
		}				
}	