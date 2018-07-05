//sluzi za logovanje, postoji mogucnost pamcenja korisnickog imena, ako je uspesno logovanje pojavljuje se druga forma
package Package;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Login {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JLabel lblPassword;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(51, 0, 153));
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setBounds(100, 100, 440, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 404, 364);
		frame.getContentPane().add(panel);
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(86, 11, 63, 15);
		lblUsername.setForeground(new Color(51, 0, 153));
		lblUsername.setBackground(new Color(51, 204, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(86, 42, 73, 14);
		lblPassword.setForeground(new Color(51, 0, 153));
		lblPassword.setBackground(new Color(51, 204, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		JCheckBox chckbxRememberUsername = new JCheckBox("Remember username");
		chckbxRememberUsername.setBounds(88, 73, 185, 23);
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(51, 204, 255));
		chckbxRememberUsername.setForeground(new Color(51, 0, 153));
		chckbxRememberUsername.setBackground(new Color(51, 204, 255));
		chckbxRememberUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(169, 11, 104, 20);
		textFieldUserName.setBackground(new Color(51, 204, 255));
		textFieldUserName.setColumns(10);
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(88, 103, 185, 35);
		btnLogin.setForeground(new Color(51, 0, 153));
		btnLogin.setBackground(new Color(51, 204, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.setLayout(null);
		panel.add(chckbxRememberUsername);
		panel.add(lblUsername);
		panel.add(lblPassword);
		panel.add(textFieldUserName);
		panel.add(btnLogin);		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 73, 434, 385);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("1370146_orig.png"));
		passwordField.setBounds(169, 42, 104, 20);
		panel.add(passwordField);
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0)		//akcije koja se izvrsava klikom na dugme Login
			{
				String username = textFieldUserName.getText().trim();	//daje tekst koji je unet u ovaj textField
				String password= passwordField.getText().toString();	
				if(username!=null && username.length()>0 && password!=null && password.length()>0)		//provera da li su polja popunjena 
				{
					if(username.contains("user") && password.contains("user") && username.length()=="user".length() && password.length()=="user".length() ) //dvostruka provera username-a i pass-a
						{						
							frame.show(false);	
							TaskManager taskManager= new TaskManager();
							taskManager.show(true);
						}
					else
						{
							if(chckbxRememberUsername.isSelected())
								passwordField.setText("");
							else
							{
								textFieldUserName.setText("");
								passwordField.setText("");
							}						
						}	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!");
					textFieldUserName.setText("");
					passwordField.setText("");
				}
				
			}
		});
		
	}
}
