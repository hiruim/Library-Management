package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Availabalebooks extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Availabalebooks frame = new Availabalebooks();
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
	public Availabalebooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblavailabalebooks = new JLabel("Available Books");
		lblavailabalebooks.setBounds(165, 11, 176, 26);
		lblavailabalebooks.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lblavailabalebooks);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 48, 432, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setBackground(new Color(215, 215, 215));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Jane Eyer", "10052", "Charlotte Bronte"},
				{"Robinson Crusoe", "15623", "Daniel Defoe"},
				{"Gullivers Travel", "20500", "Jonathan Swift"},
				{"Clarissa", "36524", "Samuel Richardson"},
				{"Tom Jones", "58496", "Henry Fielding"},
				{"Frankenstein", "54630", "Mary Shelley"},
				{"David Copperfield", "10003", "Charles Dickens"},
				{"The Moonstone", "48750", "Wilkie Collins"},
				{"Middlemarch", "20014", "George Eliot"},
				{"Dracula", "32130", "Bram Stoker"},
				{"Heart of Darkness", "10056", "Joseph Conrad"},
				{"Sister Carrie", "54000", "Theodore Dreiser"},
				{"Kim", "30041", "Rudyard Kipling"},
				{"The Golden Bowl", "70086", "Henry James"},
				{"The Golden Soldier", "47895", "Ford Madox Ford"},
				{"The Rainbow", "38000", "DH Lawrence"},
				{"Brave New World", "45200", "Aldous Hulexy"},
				{"Scoop", "80001", "Evelyn Waugh"},
				{"Murphy", "90021", "Samuel Beckett"},
				{"The Big Sleep", "54630", "Raymond Chandler"},
				{"Party Going", "60012", "Henry Green"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Book Name", "Book ID", "Author"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		table.getColumnModel().getColumn(2).setPreferredWidth(92);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(194, 399, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
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
	}
}
