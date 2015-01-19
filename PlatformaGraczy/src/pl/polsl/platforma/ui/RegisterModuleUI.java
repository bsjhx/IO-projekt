package pl.polsl.platforma.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import pl.polsl.paltforma.dao.PanstwaDAO;
import pl.polsl.paltforma.dao.WalutyDAO;
import pl.polsl.platforma.model.Panstwa;
import pl.polsl.platforma.model.Waluty;

import javax.swing.JFormattedTextField;

public class RegisterModuleUI extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JTextField nickField;
	private JPasswordField passwordField;
	private JPasswordField repPasswordField;
	private JButton cancelButton;
	private JButton registerButton;
	private JComboBox<String> panstwoCombo;
	private JComboBox<String> walutaCombo;
	private JFormattedTextField frmtdtxtfld;
	private JLabel lblDataUrodzenia;
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	


	/**
	 * Create the frame.
	 */
	public RegisterModuleUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 11, 96, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Haslo:");
		lblPassword.setBounds(10, 36, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lblPotwierdzHaslo = new JLabel("Potwierdz haslo:");
		lblPotwierdzHaslo.setBounds(10, 61, 96, 14);
		contentPane.add(lblPotwierdzHaslo);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(10, 86, 96, 14);
		contentPane.add(lblNick);
		
		JLabel lblOpis = new JLabel("Opis:");
		lblOpis.setBounds(10, 194, 96, 14);
		contentPane.add(lblOpis);
		
		JLabel lblWaluta = new JLabel("Waluta:");
		lblWaluta.setBounds(10, 136, 96, 14);
		contentPane.add(lblWaluta);
		
		JLabel lblPanstwo = new JLabel("Panstwo:");
		lblPanstwo.setBounds(10, 111, 96, 14);
		contentPane.add(lblPanstwo);
		
		loginField = new JTextField();
		loginField.setBounds(136, 8, 117, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		nickField = new JTextField();
		nickField.setBounds(136, 83, 117, 20);
		contentPane.add(nickField);
		nickField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 33, 117, 20);
		contentPane.add(passwordField);
		
		repPasswordField = new JPasswordField();
		repPasswordField.setBounds(136, 58, 117, 20);
		contentPane.add(repPasswordField);
		
		panstwoCombo = new JComboBox();
		panstwoCombo.setBounds(136, 108, 117, 20);
		contentPane.add(panstwoCombo);
		
		
		walutaCombo = new JComboBox();
		walutaCombo.setBounds(136, 133, 117, 20);
		contentPane.add(walutaCombo);
		addValuesToComboBoxes();
		
		JTextPane opis = new JTextPane();
		opis.setBounds(136, 194, 117, 78);
		contentPane.add(opis);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 309, 89, 23);
		contentPane.add(cancelButton);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(109, 309, 181, 23);
		contentPane.add(registerButton);
		
		frmtdtxtfld = new JFormattedTextField(df);
		frmtdtxtfld.setBounds(136, 163, 117, 20);
		
		contentPane.add(frmtdtxtfld);
		
		lblDataUrodzenia = new JLabel("Data urodzenia:");
		lblDataUrodzenia.setBounds(10, 166, 96, 14);
		contentPane.add(lblDataUrodzenia);
	}
	
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public void addResiterButtonListener(ActionListener a) {
		registerButton.addActionListener(a);
	}
	
	private void addValuesToComboBoxes() {
		for(Panstwa p : PanstwaDAO.getAll()) {
			panstwoCombo.addItem(p.getNazwaPanstwa());
		}
		
		for(Waluty w : WalutyDAO.getAll()) {
			walutaCombo.addItem(w.getNazwaWaluty());
		}
	}

	public String getLoginValue() {
		return loginField.getText();
	}

	public String getNickValue() {
		return nickField.getText();
	}

	public String getPasswordValue() {
		return passwordField.getText();
	}

	public String getRepPasswordText() {
		return repPasswordField.getText();
	}

	public String getPanstwoCombo() {
		return (String) panstwoCombo.getSelectedItem();
	}

	public String getWalutaCombo() {
		return (String) walutaCombo.getSelectedItem();
	}
	
	public String getDataUr() {
		return (String) frmtdtxtfld.getText();
	}

	
	
	
	
}
