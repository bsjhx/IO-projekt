package pl.polsl.platforma.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import pl.polsl.platforma.model.Uzytkownicy;
import pl.polsl.platforma.model.Znajomi;

public class ZnajomiModuleUI extends JFrame {
	private JTextField loginText;
	private DefaultListModel<String> model;
	private JList<String> list;
	private JButton znajdzButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZnajomiModuleUI frame = new ZnajomiModuleUI();
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
	public ZnajomiModuleUI() {
		setTitle("Lista znajomych");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 351);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		loginText = new JTextField();
		panel.add(loginText);
		loginText.setColumns(10);
		
		znajdzButton = new JButton("Znajd\u017A u\u017Cytkownika");
		panel.add(znajdzButton);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		scrollPane.setViewportView(list);
	}
	
	public void zaladujZnajomychDoListy(List<String> list) {
		if (!list.isEmpty()) {
			for (String z : list) {
				model.addElement(z);
			}
		}
	}
	
	public void dodajZnajomegoDoListy(String znajomy) {
		model.addElement(znajomy);
	}
	
	public void addZnajdzListener(ActionListener a) {
		znajdzButton.addActionListener(a);
	}
	
	public String getLoginText() {
		return this.loginText.getText();
	}

}
