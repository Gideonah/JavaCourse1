import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeLogin {
		
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	public static class ImportantStuff {
	}
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin window = new EmployeeLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public EmployeeLogin() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		BufferedReader BuffUser = new BufferedReader(new FileReader("src/User-Passwords.txt"));
		List<String> pairs = new ArrayList<String>();
		String line;
		while ((line = BuffUser.readLine()) != null) {
			pairs.add(line);
		}
		String[] TestUser = pairs.toArray(new String[]{});
		String[] U = new String[TestUser.length];
		String[] P = new String[TestUser.length];
		
		for (int i = 0; i < TestUser.length; i++) {
			String[] interm = TestUser[i].split("\\s*\\-\\s*");
			U[i] = interm[0];
			P[i] = interm[1];		
		}
		System.out.println(U[1]);
		System.out.println(P[1]);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Employee = new JPanel();
		tabbedPane.addTab("Employee", null, Employee, null);
		Employee.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(116, 59, 85, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Employee.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(129, 87, 61, 16);
		Employee.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(206, 54, 130, 26);
		Employee.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 82, 130, 26);
		Employee.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String InU = textField.getText();
				String InP = textField_1.getText();
				if (Arrays.asList(U).contains(InU) && Arrays.asList(P).contains(InP)) {
					int Uindex;
					int Pindex;
					for (int i = 0; i < U.length; i++) {
						if (U[i].equals(InU) && P[i].equals(InP)) {
							JOptionPane.showMessageDialog(frame, "You have successfully logged in!");
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(frame, "Username and password provided do not match.");
				}
			}
		});
		btnLogin.setBounds(179, 127, 117, 29);
		Employee.add(btnLogin);
		
		JPanel Customer = new JPanel();
		tabbedPane.addTab("Customer", null, Customer, null);
		Employee.setLayout(null);
	}
}

