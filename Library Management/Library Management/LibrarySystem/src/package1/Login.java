package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usename;
	private JTextField password;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(151, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Member Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblLogin.setBackground(new Color(192, 192, 192));
		lblLogin.setBounds(136, 11, 179, 28);
		contentPane.add(lblLogin);
		
		JLabel lblusename = new JLabel("Username");
		lblusename.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblusename.setBounds(41, 66, 113, 14);
		contentPane.add(lblusename);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblpassword.setBounds(41, 112, 127, 14);
		contentPane.add(lblpassword);
		
		usename = new JTextField();
		usename.setBounds(180, 65, 220, 20);
		contentPane.add(usename);
		usename.setColumns(10);
		
		password = new JTextField();
		password.setBounds(180, 111, 220, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		
		btnLogin.addActionListener(new ActionListener() {
         

			@Override
            public void actionPerformed(ActionEvent e) {
				
				

            	try {
            		//Class.forName("com.mysql.jdbc.Driver");
            		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            		Statement stmt = (Statement) con.createStatement();
            		
					String sql = "SELECT * FROM login WHERE Username'"+usename.getText()+"' and Password'"+password.getText().toString()+"'";
            	ResultSet rs=((java.sql.Statement) stmt).executeQuery(sql);
            	
            	if(rs.next())
            	
            		JOptionPane.showMessageDialog(null,"Login Sucessfully...");
            	
            	else 
            		JOptionPane.showMessageDialog(null,"Incorrect username and Password...");
            		con.close();
            	
            	}catch(Exception e1)
            	{
            		System.out.print(e1);
            	}                      														
			}					
       });
		
		
		btnLogin.setBackground(new Color(128, 255, 0));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setBounds(242, 175, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBackground(new Color(128, 255, 0));
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRegister.setBounds(242, 227, 127, 23);
		contentPane.add(btnRegister);
		
		btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
               
            	  displaySuccessMessage("Successfully");
                openRegisterInterface();
                MemberRegistration frame = new MemberRegistration();
				frame.setVisible(true);
            }
            
			private void displaySuccessMessage(String string) {				
			}

			private void openRegisterInterface() {					
			}
        });
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBack.setBounds(125, 175, 89, 23);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Login interface
                openHomeInterface();
                HomePage frame = new HomePage();
				frame.setVisible(true);
            }

			private void openHomeInterface() {					
			}
        });
		
		
		JLabel lbl1 = new JLabel("If you have an account");
		lbl1.setForeground(new Color(0, 64, 128));
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl1.setBounds(65, 232, 149, 14);
		contentPane.add(lbl1);
	}

}
