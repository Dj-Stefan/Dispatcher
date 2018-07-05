package Package;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;

public class TaskManager extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskManager frame = new TaskManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	LinkedList <Process> readyProcessM = new LinkedList<>();
	LinkedList <Process> readyProcessAdd = new LinkedList<>();

	ArrayList<Process> finished=new ArrayList<Process>();
	
	Random r=new Random(); 
	JTextArea txtAreaExecutedP = new JTextArea();
	JButton btnRun = new JButton("RUN");
	JTextArea txtAreaReadyP = new JTextArea();
	
	private JTextField txtCore1;
	private JTextField txtCore2;
	private JTextField txtCore3;
	private JTextField txtCore4;
	int nextProcessID= 22;
	//JScrollPane jsp= new JScrollPane(txtAreaExecutedP, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	JButton btnAddProcess = new JButton("Add new process");
	JButton btnKillProcess = new JButton("Kill Process");
	JButton btnRunAgain = new JButton("RUN AGAIN");
	JComboBox comboBox = new JComboBox();
	JRadioButton rdbtnRandom = new JRadioButton("Random");
	JRadioButton rdbtnInput = new JRadioButton("Keyboard");
	private JTextField txtFieldID;
	private JTextField txtInput = new JTextField();;

	public TaskManager() {
		setTitle("Task Manager");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtAreaReadyP.setEnabled(false);
				txtAreaExecutedP.setEnabled(false);
				txtCore1.setEnabled(false);
				txtCore2.setEnabled(false);
				txtCore3.setEnabled(false);
				txtCore4.setEnabled(false);
								
				btnRun.setEnabled(false);
				btnRunAgain.setEnabled(false);	
				btnKillProcess.setEnabled(false);
				btnAddProcess.setEnabled(false);
				txtFieldID.setEnabled(false);
				rdbtnInput.setEnabled(false);
				rdbtnRandom.setEnabled(false);
				txtInput.setEnabled(false);
			}
		});
		txtCore1 = new JTextField();
		txtCore2 = new JTextField();
		txtCore3 = new JTextField();
		txtCore4 = new JTextField();
		txtFieldID = new JTextField();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 509);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnRun.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnRun.setForeground(new Color(128, 0, 0));
		btnRun.setBackground(new Color(211, 211, 211));
		btnRun.setBounds(281, 401, 72, 27);
		btnRun.addActionListener(new ActionListener() 
		{
		  public void actionPerformed(ActionEvent arg0) 
			{
			
			    Process p0= new Process(1,"CCC.exe",r.nextInt(20)+80,r.nextInt(2000)+750);				//kreiraju se unapred formirani procesi
				Process p1= new Process(2,"Winamp.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p2= new Process(3,"System.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p3= new Process(4,"Eclipse.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p4= new Process(5,"Chrome.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p5= new Process(6,"iTunes.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p6= new Process(7,"Server.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p7= new Process(8,"jucheck.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p8= new Process(9,"RAVBg64.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				
				readyProcessM.add(p0);				//dodavanje u listu
				readyProcessM.add(p1);
				readyProcessM.add(p2);
				readyProcessM.add(p3);
				readyProcessM.add(p4);
				readyProcessM.add(p5);
				readyProcessM.add(p6);
				readyProcessM.add(p7);
				readyProcessM.add(p8);
							
				Process p9 = new Process(10,"ShellHost.exe",r.nextInt(20)+80,r.nextInt(2000)+750);			//procesi koji se automatski dodaju
				Process p10 = new Process(11,"Defender.exe",r.nextInt(20)+80,r.nextInt(2000)+750);	
				Process p11 = new Process(12,"AVG.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p12 = new Process(13,"Notepad.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p13 = new Process(14,"Total Comander.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p14 = new Process(15,"AndridStudio.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p15 = new Process(16,"Opera.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p16 = new Process(17,"Facebook.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p17 = new Process(18,"LoL.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p18 = new Process(19,"C#.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p19 = new Process(20,"YouTube.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				Process p20 = new Process(21,"Chrome_2.exe",r.nextInt(20)+80,r.nextInt(2000)+750);
				
				readyProcessAdd.add(p9);
				readyProcessAdd.add(p10);
				readyProcessAdd.add(p11);
				readyProcessAdd.add(p12);
				readyProcessAdd.add(p13);
				readyProcessAdd.add(p14);
				readyProcessAdd.add(p15);
				readyProcessAdd.add(p16);
				readyProcessAdd.add(p17);
				readyProcessAdd.add(p18);
				readyProcessAdd.add(p19);
				readyProcessAdd.add(p20);
				
				Processor pr1 = new Processor(btnAddProcess,btnKillProcess,btnRunAgain,readyProcessM,txtAreaReadyP,txtCore1,finished,txtAreaExecutedP,getName(),530,0,2); //kreiranje niti
				Processor pr2 = new Processor(btnAddProcess,btnKillProcess,btnRunAgain,readyProcessM,txtAreaReadyP,txtCore2,finished,txtAreaExecutedP,getName(),524,1,3);
				Processor pr3 = new Processor(btnAddProcess,btnKillProcess,btnRunAgain,readyProcessM,txtAreaReadyP,txtCore3,finished,txtAreaExecutedP,getName(),507,4,6);
				Processor pr4 = new Processor(btnAddProcess,btnKillProcess,btnRunAgain,readyProcessM,txtAreaReadyP,txtCore4,finished,txtAreaExecutedP,getName(),513,5,7);
				  
				if(comboBox.getSelectedItem().equals("Single core")) //u zavisnosti od combobox izbora vrse se odredjene promene na formi i porecu se odgovarajuce niti
				{
					txtCore1.setBackground(new Color(144, 238, 144));
					txtCore2.setBackground(new Color(250, 128, 114));
					txtCore3.setBackground(new Color(250, 128, 114));
					txtCore4.setBackground(new Color(250, 128, 114));
					Processor pr1_1=new Processor(btnAddProcess,btnKillProcess,btnRunAgain,readyProcessM,txtAreaReadyP,txtCore1,finished,txtAreaExecutedP,getName(),530,0,1);
					pr1_1.start();
					txtCore2.setText("");
					txtCore3.setText("");
					txtCore4.setText("");
				}
				if(comboBox.getSelectedItem().equals("Dual core") || comboBox.getSelectedItem().equals("i3"))
				{
					txtCore1.setBackground(new Color(144, 238, 144));
					txtCore2.setBackground(new Color(144, 238, 144));
					txtCore3.setBackground(new Color(250, 128, 114));
					txtCore4.setBackground(new Color(250, 128, 114));
					pr1.start();
					pr2.start();
					txtCore3.setText("");
					txtCore4.setText("");
				}
								
				if(comboBox.getSelectedItem().equals("Quad core") || comboBox.getSelectedItem().equals("i5"))
				{
					txtCore1.setBackground(new Color(144, 238, 144));
					txtCore2.setBackground(new Color(144, 238, 144));
					txtCore3.setBackground(new Color(144, 238, 144));
					txtCore4.setBackground(new Color(144, 238, 144));
					pr1.start();
					pr2.start();
					pr3.start();
					pr4.start();				
				}

				btnRun.setEnabled(false);
				btnAddProcess.setEnabled(true);
				btnKillProcess.setEnabled(true);
				txtFieldID.setEnabled(true);
				rdbtnInput.setEnabled(true);
				rdbtnRandom.setEnabled(true);				
			}
		});
		contentPane.add(btnRun);		
		JLabel lblProcesiZaIzvrsenje = new JLabel("Processes for execution:");
		lblProcesiZaIzvrsenje.setBackground(new Color(230, 230, 250));
		lblProcesiZaIzvrsenje.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblProcesiZaIzvrsenje.setForeground(Color.BLACK);
		lblProcesiZaIzvrsenje.setBounds(10, 54, 246, 33);
		contentPane.add(lblProcesiZaIzvrsenje);		
		JLabel lblIzvrseniProcesi = new JLabel("Executed processes:");
		lblIzvrseniProcesi.setBackground(new Color(230, 230, 250));
		lblIzvrseniProcesi.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblIzvrseniProcesi.setForeground(Color.BLACK);
		lblIzvrseniProcesi.setBounds(508, 37, 220, 33);
		contentPane.add(lblIzvrseniProcesi);
		txtCore1.setBackground(UIManager.getColor("CheckBox.light"));
		txtCore1.setDisabledTextColor(new Color(0, 0, 0));
		txtCore1.setSelectionColor(new Color(51, 153, 204));
		txtCore1.setBounds(281, 131, 180, 28);
		contentPane.add(txtCore1);
		txtCore1.setColumns(10);
		txtCore2.setBackground(UIManager.getColor("CheckBox.light"));
		txtCore2.setDisabledTextColor(new Color(0, 0, 0));
		txtCore2.setBounds(281, 188, 180, 28);
		contentPane.add(txtCore2);
		txtCore2.setColumns(10);
		txtCore3.setBackground(UIManager.getColor("CheckBox.light"));
		txtCore3.setDisabledTextColor(new Color(0, 0, 0));
		txtCore3.setBounds(281, 245, 180, 28);
		contentPane.add(txtCore3);
		txtCore3.setColumns(10);
		txtCore4.setBackground(UIManager.getColor("CheckBox.light"));
		txtCore4.setDisabledTextColor(new Color(0, 0, 0));
		txtCore4.setBounds(281, 302, 180, 28);
		contentPane.add(txtCore4);
		txtCore4.setColumns(10);
		JLabel lblKilledProces = new JLabel("");
		lblKilledProces.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		JLabel lblCore1 = new JLabel("Core 1:");
		lblCore1.setBounds(281, 113, 46, 14);
		contentPane.add(lblCore1);		
		JLabel lblCore2 = new JLabel("Core 2:");
		lblCore2.setBounds(281, 170, 46, 14);
		contentPane.add(lblCore2);		
		JLabel lblCore3 = new JLabel("Core 3:");
		lblCore3.setBounds(281, 227, 46, 14);
		contentPane.add(lblCore3);
		JLabel lblCore4 = new JLabel("Core 4:");
		lblCore4.setBounds(281, 284, 46, 14);
		contentPane.add(lblCore4);
		
		btnAddProcess.addActionListener(new ActionListener()
		{			
			public void actionPerformed(ActionEvent e) 
			{		
				int randomProcessID = r.nextInt(12)+10; 	// jer je u tom opsegu id random procesa
				
				if(rdbtnRandom.isSelected()==true)			//ako je selektovan "Random" radioButton 
				{
					for(int i=0;i<readyProcessAdd.size();i++)	//prolazi kroz procese koji su primpremljeni za random dodavanje		
					
						if(readyProcessAdd.get(i).getID()==randomProcessID) 	//proverava random ID procesa i radnom broja
									
							for(int j=0; j<readyProcessM.size();j++)	//prolazi kroz procese koji su na cekanju
					
								if(readyProcessM.get(j).getID()!=randomProcessID) //da li random proces postoji u listi cekanja
								{
									readyProcessM.add(readyProcessAdd.get(i));
									readyProcessAdd.remove(readyProcessAdd.get(i));
									break;
								}
					if(readyProcessAdd.size()==0)  //kraj liste radnom procesa
					{			
						JOptionPane.showMessageDialog(null,	"No processes available!");
					
					}
				}
				
				else
					if(rdbtnInput.isSelected()==true) 		//radioButoom za rucni unos procesa
					{
						String ProcesName = txtInput.getText();
						if(ProcesName!=null && ProcesName.length()>0)	//Da li je ispravno uneto ime procesa
						{
							Process p21= new Process();
									
							p21.setName(ProcesName+".exe");
							p21.setID(nextProcessID);
							p21.setPriority(r.nextInt(30)+80); 	//ne sme da bude manji od 80 zbog prioriteta ostalih procesa
							p21.setTimeExecutionProcess(r.nextInt(2000)+750);
							readyProcessM.add(p21);
							nextProcessID++;
							txtInput.setText("");
							lblKilledProces.setText("The process was added!");
							lblKilledProces.setForeground(new Color(0, 102, 255));
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Enter the process name!");  //zastita od pucanja progama
						}					
				}
				else JOptionPane.showMessageDialog(null, "Select the type of add!"); //zastita od pucanja progama
			}
	});		
		btnAddProcess.setBackground(new Color(211, 211, 211));
		btnAddProcess.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnAddProcess.setBounds(10, 392, 139, 23);
		contentPane.add(btnAddProcess);	
		btnKillProcess.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) 
			{
				int j=0;
				String IDs = txtFieldID.getText();
				try
					{
						int ID = Integer.parseInt(IDs);  //u try bloku da bi proverili parsiranje
					
							for(int i=0;i<readyProcessM.size();i++)
								{
								j=0;	//pomocni parametar koji se pre svake provere vraca na 0
									if(readyProcessM.get(i).getID()==ID) //ukoliko se poklapa sa unetim ID-om sa tastature
										{
											readyProcessM.remove(readyProcessM.get(i));
											j++;		
											break;
										}	
								}							
							if(j==0)
							{
								lblKilledProces.setText("No process was found with thih ID!");
								lblKilledProces.setForeground(new Color(153, 0, 0));
							}
							else if(j==1) 
							{
								lblKilledProces.setText("The process was killed!");
								lblKilledProces.setForeground(new Color(0, 102, 0));
							}
					}
				catch (Exception e)
						{
							JOptionPane.showMessageDialog(null, "ID must be of taype int!");				
						}

				txtFieldID.setText("");					
			}	
	});
		btnKillProcess.setBackground(new Color(211, 211, 211));
		btnKillProcess.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnKillProcess.setBounds(86, 417, 119, 23);
		contentPane.add(btnKillProcess);
		btnRunAgain.setBackground(new Color(211, 211, 211));
		btnRunAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setEnabled(true);
				txtAreaReadyP.setText("");
				txtAreaExecutedP.setText("");
			
				btnRunAgain.setEnabled(false);
				finished.clear();	
				txtInput.setEnabled(false);
				txtInput.setBackground(new Color(204,204,204));
				lblKilledProces.setText("");
				rdbtnInput.setSelected(false);
				rdbtnRandom.setSelected(false);
				rdbtnInput.setEnabled(false);
				rdbtnRandom.setEnabled(false);
			}
		});			
		btnRunAgain.setForeground(new Color(128, 0, 0));
		btnRunAgain.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnRunAgain.setBounds(352, 401, 109, 27);
		contentPane.add(btnRunAgain);
		JLabel lblNumberOfCores = new JLabel("Number of cores:");
		lblNumberOfCores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNumberOfCores.setBounds(10, 21, 111, 14);
		contentPane.add(lblNumberOfCores);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				btnRun.setEnabled(true);
				btnRunAgain.setEnabled(false);
				comboBox.setEnabled(false);
			}
		});
		comboBox.setForeground(new Color(128, 0, 0));
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Single core", "Dual core", "i3", "Quad core", "i5"}));
		comboBox.setBounds(114, 18, 97, 20);
		contentPane.add(comboBox);		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("Java_logo_icon.png"));
		lblImage.setBounds(293, 7, 146, 79);
		contentPane.add(lblImage);		
		txtFieldID.setBackground(new Color(204, 204, 204));
		txtFieldID.setBounds(45, 417, 40, 23);
		contentPane.add(txtFieldID);
		txtFieldID.setColumns(10);
		lblKilledProces.setForeground(new Color(0, 102, 0));
		lblKilledProces.setBounds(44, 447, 259, 14);
		contentPane.add(lblKilledProces);
		rdbtnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				rdbtnInput.setSelected(false);
				txtInput.setEnabled(false);
				txtInput.setBackground(new Color(250, 128, 114));
			}
		});
		rdbtnRandom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		rdbtnRandom.setOpaque(false);
		rdbtnRandom.setBounds(52, 364, 72, 23);
		contentPane.add(rdbtnRandom);
		rdbtnInput.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rdbtnRandom.setSelected(false);
				txtInput.setEnabled(true);
				txtInput.setBackground(new Color(144, 238, 144));
			}
		});
		rdbtnInput.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		rdbtnInput.setOpaque(false);
		rdbtnInput.setBounds(131, 364, 92, 23);
		contentPane.add(rdbtnInput);
		txtInput.setBackground(new Color(204, 204, 204));
		txtInput.setBounds(151, 392, 92, 23);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setVerifyInputWhenFocusTarget(false);
		scrollPane_2.setOpaque(false);
		scrollPane_2.setBackground(new Color(153, 153, 153));
		scrollPane_2.setBounds(507, 81, 233, 347);
		contentPane.add(scrollPane_2);
		scrollPane_2.setViewportView(txtAreaExecutedP);
		txtAreaExecutedP.setBackground(new Color(153, 153, 153));
		txtAreaExecutedP.setDisabledTextColor(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(153, 153, 153));
		scrollPane.setBounds(10, 98, 233, 259);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(txtAreaReadyP);
		txtAreaReadyP.setBackground(new Color(153, 153, 153));
		txtAreaReadyP.setDisabledTextColor(Color.BLACK);
	}
}
