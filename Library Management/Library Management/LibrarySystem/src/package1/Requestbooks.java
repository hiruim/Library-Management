package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Requestbooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requestbooks frame = new Requestbooks();
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
	public Requestbooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrequestbooks = new JLabel("Request Books");
		lblrequestbooks.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblrequestbooks.setBounds(150, 11, 160, 26);
		contentPane.add(lblrequestbooks);
		
		JLabel lblmember = new JLabel("Member Name");
		lblmember.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblmember.setBounds(47, 58, 105, 14);
		contentPane.add(lblmember);
		
		JLabel lblmid = new JLabel("Member ID");
		lblmid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblmid.setBounds(47, 99, 94, 14);
		contentPane.add(lblmid);
		
		JLabel lblbookname = new JLabel("Book Name");
		lblbookname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblbookname.setBounds(47, 144, 94, 14);
		contentPane.add(lblbookname);
		
		JLabel lblbookid = new JLabel("Book ID");
		lblbookid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblbookid.setBounds(47, 187, 94, 14);
		contentPane.add(lblbookid);
		
		textField = new JTextField();
		textField.setBounds(180, 55, 231, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 96, 231, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 141, 231, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 184, 231, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnback = new JButton("Back");
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnback.setBackground(new Color(255, 0, 0));
		btnback.setBounds(99, 240, 89, 23);
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
		
		JButton btnsend = new JButton("Send");
		btnsend.setBackground(new Color(0, 255, 0));
		btnsend.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnsend.setBounds(254, 240, 89, 23);
		contentPane.add(btnsend);
	}

}
