package pl.polsl.platforma.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import pl.polsl.paltforma.dao.PanstwaDAO;
import pl.polsl.paltforma.dao.UzytkownicyDAO;
import pl.polsl.paltforma.dao.WalutyDAO;
import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Statusy;
import pl.polsl.platforma.model.Uzytkownicy;
import pl.polsl.platforma.sha.SHA;
import pl.polsl.platforma.ui.LoginModuleUI;
import pl.polsl.platforma.ui.RegisterModuleUI;

public class RegisterController {

	private RegisterModuleUI frame;

	public static void main(String[] args) {
		RegisterController a = new RegisterController();
		a.start();
	}
	
	public RegisterController() {
		frame = new RegisterModuleUI();

		frame.addCancelButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.addResiterButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
	}

	public void start() {
		frame.setVisible(true);
	}

	private void register() {
		String login = frame.getLoginValue();
		String nick = frame.getNickValue();
		String password = frame.getPasswordValue();
		String passwordR = frame.getRepPasswordText();
		String dataUr = frame.getDataUr();
		String panstwo = frame.getPanstwoCombo();
		String waluta = frame.getWalutaCombo();

		if (login.isEmpty() || nick.isEmpty() || password.isEmpty()
				|| passwordR.isEmpty() || dataUr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Wype³nij wszystkie pola!");
			return;
		} else {
			if (!UzytkownicyDAO.isExists(login) && password.equals(passwordR)) {
				Uzytkownicy u = new Uzytkownicy();
				
				DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
				java.util.Date date = null;
				try {
					date = df.parse(dataUr);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				u.setDataUrodzenia(date);
				u.setNick(nick);
				
				try {
					u.setHaslo(SHA.hash(password));
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "tutaj");
				u.setLogin(login);
				u.setWaluty(WalutyDAO.getByName(waluta));
				u.setPanstwa(PanstwaDAO.getByName(panstwo));
				byte aa = 0;
				u.setCzyAdministrator(aa);
				byte b = 1;
				u.setStatusy(new Statusy(b, "Online"));
				
				
				DatabaseConnector dbs = DatabaseConnector.getInstance();
				dbs.connect();
				dbs.beginTransaction();
				dbs.mergeTransaction(u);
				dbs.endTransaction();
				JOptionPane.showMessageDialog(null, "Jestes zarejestrowany, mozesz sie zalogowac!");
				frame.dispose();
				LoginController newFrame = new LoginController();
				newFrame.start();
			}
		}

	}
}
