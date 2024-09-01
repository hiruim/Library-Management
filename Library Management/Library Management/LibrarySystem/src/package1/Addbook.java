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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Addbook extends JFrame {

	private JPanel contentPane;
	private JTextField bookname_1;
	private JTextField author_1;
	private JTextField bookid_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbook frame = new Addbook();
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
	public Addbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbladdbook = new JLabel("Add Books");
		lbladdbook.setBounds(166, 11, 128, 26);
		lbladdbook.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lbladdbook);
		
		JLabel lblbid = new JLabel("Book ID");
		lblbid.setBounds(51, 116, 86, 14);
		lblbid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblbid);
		
		JLabel lblbookname = new JLabel("Book Name");
		lblbookname.setBounds(51, 75, 86, 14);
		lblbookname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblbookname);
		
		JLabel lblauthor = new JLabel("Author");
		lblauthor.setBounds(51, 158, 46, 14);
		lblauthor.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblauthor);
		
		bookname_1 = new JTextField();
		bookname_1.setBounds(179, 69, 225, 20);
		bookname_1.setBackground(new Color(215, 215, 215));
		contentPane.add(bookname_1);
		bookname_1.setColumns(10);
		
		author_1 = new JTextField();
		author_1.setBounds(179, 155, 225, 20);
		author_1.setBackground(new Color(215, 215, 215));
		contentPane.add(author_1);
		author_1.setColumns(10);
		
		JButton back = new JButton("Back");
		back.setBounds(90, 226, 102, 37);
		back.setBackground(new Color(255, 0, 0));
		back.setFont(new Font("Times New Roman", Font.BOLD, 18));
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
		
		JButton add = new JButton("Add");
		add.setBounds(262, 226, 102, 37);
		add.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add.setBackground(new Color(0, 255, 0));
		contentPane.add(add);
		
		bookid_1 = new JTextField();
		bookid_1.setBackground(new Color(215, 215, 215));
		bookid_1.setBounds(176, 114, 225, 20);
		contentPane.add(bookid_1);
		bookid_1.setColumns(10);
		
		add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              

				
				JLabel bookid_1 = null;
				JLabel bookname_1 = null;
				JLabel author_1 = null;
				if (bookname_1.getText().isEmpty() || bookid_1.getText().isEmpty() || author_1.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Missing Information", "Error", JOptionPane.ERROR_MESSAGE);
			        } else {
			        	
			        	
			            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "")) {
			                
			               PreparedStatement add = con.prepareStatement("INSERT INTO addbook (bookname_1, bookid_1, author_1) VALUES (?, ?, ?)");
			               
			                add.setString(1, bookname_1.getText());
			               
			                add.setString(2, bookid_1.getText());
			                add.setString(3, author_1.getText());
			               
			               
			                
			                int rowsA = add.executeUpdate();

			                if (rowsA > 0) {
			                    JOptionPane.showMessageDialog(null, "book saved");

			                    
			                    bookname_1.setText("");
			                    bookid_1.setText("");
			                    author_1.setText("");
			                   
			                  
			                    
			                    displayAllData();
			                } else {
			                    JOptionPane.showMessageDialog(null, "Failed to save book");
			                }
			            } catch (SQLException e1) {
			                e1.printStackTrace();
			                JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
				 
				 try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "")) {
				        
				        PreparedStatement retrieve = con.prepareStatement("SELECT * FROM addbook");

				        
				        ResultSet rs = retrieve.executeQuery();

				      
				        DefaultTableModel model = new DefaultTableModel();
				      //  model.addColumn("Id");
				        model.addColumn("BookName");
				        
				        model.addColumn("BookID");
				        model.addColumn("Author");				       
				  
				        
				        while (rs.next()) {
				            model.addRow(new Object[]{
				              //  rs.getInt("id"),
				                rs.getString("bookname_1"),
				                rs.getInt("bookid_1"),
				                rs.getString("author_1"),				               
				              
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
			      
			        PreparedStatement retrieve = con.prepareStatement("SELECT * FROM addbook");

			        
			        ResultSet rs = retrieve.executeQuery();

			       
			        DefaultTableModel model = new DefaultTableModel();
			      //  model.addColumn("Id");
			        model.addColumn("BookName");
			       
			        model.addColumn("BookID");
			        model.addColumn("Author");
			      
			   
			        
			        while (rs.next()) {
			            model.addRow(new Object[]{
			               // rs.getInt("id"),
			                rs.getString("bookname_1"),
			               
			                rs.getString("bookid_1"),
			                rs.getInt("author_1"),
			                			           
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


