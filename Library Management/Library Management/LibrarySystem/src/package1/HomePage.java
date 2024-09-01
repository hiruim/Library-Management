package package1;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(151, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnmember = new JButton("Member Login");
		btnmember.setBackground(new Color(192, 192, 192));
		btnmember.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnmember.setBounds(35, 88, 157, 23);
		contentPane.add(btnmember);
		
		btnmember.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Navigate to the Login interface
	                openLoginMemberInterface();
	                Login frame = new Login();
					frame.setVisible(true);
	            }

				private void openLoginMemberInterface() {					
				}
	        });

		
		JLabel lblhomepage = new JLabel("Home Page");
		lblhomepage.setBounds(166, 22, 108, 26);
		lblhomepage.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lblhomepage);
		
		JButton btnstaff = new JButton("Staff Login");
		btnstaff.setBackground(new Color(192, 192, 192));
		btnstaff.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnstaff.setBounds(239, 88, 171, 23);
		contentPane.add(btnstaff);
		
		btnstaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Login interface
                openLoginStaffInterface();
                StaffLogin frame = new StaffLogin();
				frame.setVisible(true);
            }

			private void openLoginStaffInterface() {					
			}
        });
		
		JButton btnrequest = new JButton("Request Book");
		btnrequest.setBackground(new Color(192, 192, 192));
		btnrequest.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnrequest.setBounds(35, 142, 157, 23);
		contentPane.add(btnrequest);
		
		btnrequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Login interface
                openRequestInterface();
                Requestbooks frame = new Requestbooks();
				frame.setVisible(true);
            }

			private void openRequestInterface() {					
			}
        });
		
		JButton btnavailable = new JButton("Availabale Books");
		btnavailable.setBackground(new Color(192, 192, 192));
		btnavailable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnavailable.setBounds(239, 142, 171, 23);
		contentPane.add(btnavailable);
		
		btnavailable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Login interface
                openAvailabaleInterface();
                Availabalebooks frame = new Availabalebooks();
				frame.setVisible(true);
            }

			private void openAvailabaleInterface() {					
			}
        });
		
		JButton btnaddbook = new JButton("Add Books");
		btnaddbook.setBackground(new Color(192, 192, 192));
		btnaddbook.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnaddbook.setBounds(35, 195, 157, 23);
		contentPane.add(btnaddbook);
		
		btnaddbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Login interface
                openAddInterface();
                Addbook frame = new Addbook();
				frame.setVisible(true);
            }

			private void openAddInterface() {					
			}
        });
		
		
		JButton btnremovebooks = new JButton("Remove Books");
		btnremovebooks.setBackground(new Color(192, 192, 192));
		btnremovebooks.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnremovebooks.setBounds(239, 195, 171, 23);
		contentPane.add(btnremovebooks);
		
		btnremovebooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the Login interface
                openRemoveInterface();
                Removebooks frame = new Removebooks();
				frame.setVisible(true);
            }

			private void openRemoveInterface() {					
			}
        });
		
	}

}
