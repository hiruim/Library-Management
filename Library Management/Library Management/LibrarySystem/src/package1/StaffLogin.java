package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class StaffLogin extends JFrame {

	private JPanel contentPane;
	private JTextField staffid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLogin frame = new StaffLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(138, 68, 46, -38);
		contentPane.add(lblNewLabel);
		
		JLabel lblstafflogin = new JLabel("Staff Login");
		lblstafflogin.setBounds(158, 11, 107, 26);
		lblstafflogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lblstafflogin);
		
		JLabel lblNewLabel_2 = new JLabel("Staff ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(47, 95, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		staffid = new JTextField();
		staffid.setBackground(new Color(215, 215, 215));
		staffid.setBounds(158, 93, 239, 20);
		contentPane.add(staffid);
		staffid.setColumns(10);
		
		JButton back = new JButton("Back");
		back.setBackground(new Color(255, 0, 0));
		back.setFont(new Font("Times New Roman", Font.BOLD, 18));
		back.setBounds(61, 183, 96, 35);
		contentPane.add(back);
		

		back.addActionListener(new ActionListener() {
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
		
		JButton login = new JButton("Login");
		login.setBackground(new Color(0, 255, 0));
		login.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login.setBounds(258, 183, 96, 35);
		contentPane.add(login);
		

		login.addActionListener(new ActionListener() {
         

			@Override
            public void actionPerformed(ActionEvent e) {
				
				
            	try {
            		Class.forName("com.mysql.jdbc.Driver");
            		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            		Statement stmt = (Statement) con.createStatement();
            		
					String sql = "SELECT * FROM stafflogin WHERE sid'"+staffid.getText().toString()+"'";
            	ResultSet rs=((java.sql.Statement) stmt).executeQuery(sql);
            	
            	if(rs.next())
            	
            		JOptionPane.showMessageDialog(null,"Login Sucessfully...");
            	
            	else 
            		JOptionPane.showMessageDialog(null,"Incorrect Password...");
            		con.close();
            	
            	}catch(Exception e1)
            	{
            		System.out.print(e1);
            	}                      														
			}					
       });
		
	}

}
