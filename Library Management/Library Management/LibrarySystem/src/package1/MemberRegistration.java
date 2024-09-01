package package1;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class MemberRegistration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField phone;
	private JTextField address;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRegistration frame = new MemberRegistration();
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
	public MemberRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblregistration = new JLabel("Member Registration");
		lblregistration.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblregistration.setBounds(124, 11, 204, 26);
		contentPane.add(lblregistration);
		
		JLabel lblname = new JLabel("Full name");
		lblname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblname.setBounds(49, 69, 70, 14);
		contentPane.add(lblname);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbladdress.setBounds(49, 110, 70, 14);
		contentPane.add(lbladdress);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblemail.setBounds(49, 150, 46, 14);
		contentPane.add(lblemail);
		
		JLabel lblpno = new JLabel("Phone Number");
		lblpno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblpno.setBounds(49, 190, 100, 14);
		contentPane.add(lblpno);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblgender.setBounds(49, 233, 46, 14);
		contentPane.add(lblgender);
		
		name = new JTextField();
		name.setBackground(new Color(215, 215, 215));
		name.setBounds(184, 66, 216, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setBackground(new Color(215, 215, 215));
		email.setBounds(184, 147, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		phone = new JTextField();
		phone.setBackground(new Color(215, 215, 215));
		phone.setBounds(184, 187, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(new Color(0, 0, 0));
		btnback.setBackground(new Color(255, 0, 0));
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnback.setBounds(74, 316, 89, 23);
		contentPane.add(btnback);
		
		btnback.addActionListener(new ActionListener() {
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
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setBackground(new Color(128, 255, 0));
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnsubmit.setBounds(252, 316, 89, 23);
		contentPane.add(btnsubmit);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBackground(new Color(215, 215, 215));
		address.setBounds(184, 108, 216, 20);
		contentPane.add(address);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBackground(new Color(215, 215, 215));
		gender.setBounds(184, 227, 216, 20);
		contentPane.add(gender);
		
		btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              

				
				if (name.getText().isEmpty() || address.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() ) {
			            JOptionPane.showMessageDialog(null, "Missing Information", "Error", JOptionPane.ERROR_MESSAGE);
			        } else {
			        	
			        	
			            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "")) {
			                
			               PreparedStatement add = con.prepareStatement("INSERT INTO member (name, address, email, phone) VALUES (?, ?, ?, ?)");
			               
			                add.setString(1, name.getText());
			               
			                add.setString(2, address.getText());
			                add.setString(3, email.getText());
			                add.setInt(4, Integer.parseInt(phone.getText()));
			               
			                
			                int rowsA = add.executeUpdate();

			                if (rowsA > 0) {
			                    JOptionPane.showMessageDialog(null, "member saved");

			                    
			                    name.setText("");
			                    email.setText("");
			                    address.setText("");
			                    phone.setText("");
			                  
			                    
			                    displayAllData();
			                } else {
			                    JOptionPane.showMessageDialog(null, "Failed to save member");
			                }
			            } catch (SQLException e1) {
			                e1.printStackTrace();
			                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
				 
				 try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "")) {
				        
				        PreparedStatement retrieve = con.prepareStatement("SELECT * FROM member");

				        
				        ResultSet rs = retrieve.executeQuery();

				      
				        DefaultTableModel model = new DefaultTableModel();
				      //  model.addColumn("Id");
				        model.addColumn("Name");
				        
				        model.addColumn("Address");
				        model.addColumn("Email");
				        model.addColumn("Phone");
				  
				        
				        while (rs.next()) {
				            model.addRow(new Object[]{
				              //  rs.getInt("id"),
				                rs.getString("name"),
				                rs.getInt("address"),
				                rs.getString("email"),
				                rs.getInt("phone"),
				              
				            });
				        }

				        
				     
				        displayAllData();
				      
				    } catch (SQLException e1) {
				        e1.printStackTrace();
				        JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				    }
			}
			
			
			
			private void displayAllData() {
			    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "")) {
			      
			        PreparedStatement retrieve = con.prepareStatement("SELECT * FROM member");

			        
			        ResultSet rs = retrieve.executeQuery();

			       
			        DefaultTableModel model = new DefaultTableModel();
			      //  model.addColumn("Id");
			        model.addColumn("Name");
			       
			        model.addColumn("Address");
			        model.addColumn("Email");
			        model.addColumn("Phone");
			   
			        
			        while (rs.next()) {
			            model.addRow(new Object[]{
			               // rs.getInt("id"),
			                rs.getString("name"),
			               
			                rs.getString("address"),
			                rs.getInt("email"),
			                rs.getInt("phone")			           
			            });
			        }

			       

			    } catch (SQLException e) {
			        e.printStackTrace();
			        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }
            	
            	
            }

			
        });
	}
}
