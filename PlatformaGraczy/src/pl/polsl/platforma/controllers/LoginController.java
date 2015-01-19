package pl.polsl.platforma.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Uzytkownicy;
import pl.polsl.platforma.sha.SHA;
import pl.polsl.platforma.ui.LoginModuleUI;

public class LoginController {
	private LoginModuleUI frame;

	public LoginController() {
		frame = new LoginModuleUI();

		frame.addCancelListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.addLoginListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		
		frame.addRegisterListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterController registerUI = new RegisterController();
				registerUI.start();
				frame.dispose();
			}
		});
	}

	public void login() {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		if (dbs != null) {
			if (!frame.getLoginText().isEmpty()
					&& !frame.getPasswordValue().isEmpty()) {

				Query q = dbs.getEm().createNamedQuery(
						"Uzytkownicy.findByLogin");
				q.setParameter("loginWhere", frame.getLoginText());
				List<Uzytkownicy> res = q.getResultList();
				if (!res.isEmpty()) {
					String sha = "";
					try {
						sha = SHA.hash(frame.getPasswordValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(sha);
					System.out.println(res.get(0).getHaslo());
					if (sha.equalsIgnoreCase(res.get(0).getHaslo())) {
						JOptionPane.showMessageDialog(null,
								"Witamy na platformie!");
						MainController main = new MainController(res.get(0));
						main.start();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"Haslo badz login jest niepoprawne!");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Haslo badz login jest niepoprawne!");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Oba pola sa wymagane");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Blad polaczenia!");
		}
	}

	public void start() {
		frame.setVisible(true);
	}

}
