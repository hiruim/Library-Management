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

public class Removebooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Removebooks frame = new Removebooks();
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
	public Removebooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblremove = new JLabel("Remove Books");
		lblremove.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblremove.setBounds(145, 11, 161, 26);
		contentPane.add(lblremove);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(45, 67, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 107, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(45, 148, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(215, 215, 215));
		textField.setBounds(170, 64, 236, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(215, 215, 215));
		textField_1.setBounds(170, 104, 236, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(215, 215, 215));
		textField_2.setBounds(170, 142, 236, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnback = new JButton("Back");
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnback.setBackground(new Color(255, 0, 0));
		btnback.setBounds(79, 204, 89, 34);
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
		
		JButton btnremove = new JButton("Remove");
		btnremove.setBackground(new Color(0, 255, 0));
		btnremove.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnremove.setBounds(264, 204, 109, 34);
		contentPane.add(btnremove);
	}

}
