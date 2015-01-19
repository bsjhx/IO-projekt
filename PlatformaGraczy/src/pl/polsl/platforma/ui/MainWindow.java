package pl.polsl.platforma.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;

import pl.polsl.platforma.model.Gry;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	JLabel loginLabel;

	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JPanel panel_1;
	private JButton zagrajButton;
	private JButton zakonczButton;
	private JButton znajomiButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 249);
		setTitle("Platforma gier");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		listModel = new DefaultListModel<String>();
		list = new JList(listModel);
		
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.WEST);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblZalogowanyJako = new JLabel("Zalogowany jako:");
		panel.add(lblZalogowanyJako);

		loginLabel = new JLabel("login");
		panel.add(loginLabel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		zagrajButton = new JButton("Zagraj");
		zagrajButton.setHorizontalAlignment(SwingConstants.RIGHT);
		zagrajButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_1.add(zagrajButton);
		
		zakonczButton = new JButton("Zakoncz granie");
		zakonczButton.setEnabled(false);
		panel_1.add(zakonczButton);
		
		znajomiButton = new JButton("Pokaz znajomych");
		panel_1.add(znajomiButton);
	}
	
	public void addZnajomiListener(ActionListener a) {
		znajomiButton.addActionListener(a);
	}
	
	public void addZagrajListener(ActionListener a) {
		this.zagrajButton.addActionListener(a);
	}
	
	public void addZakonczListener(ActionListener a) {
		this.zakonczButton.addActionListener(a);
	}

	public void setLoginUzytkownika(String login) {
		loginLabel.setText(login);
	}
	
	public void zaladujGryDoListy(List<Gry> list) {
		if (!list.isEmpty()) {
			for (Gry g : list) {
				System.out.println(g);
				listModel.addElement(g.getNazwaGry());
			}
		}		
	}
	
	public void zacznijGracPrzyciski() {
		this.zakonczButton.setEnabled(true);
		this.zagrajButton.setEnabled(false);
	}
	
	public void zakonczGracPrzyciski() {
		this.zakonczButton.setEnabled(false);
		this.zagrajButton.setEnabled(true);
	}
	
	public String getWybranaGra() {
		return this.list.getSelectedValue();
	}
}
