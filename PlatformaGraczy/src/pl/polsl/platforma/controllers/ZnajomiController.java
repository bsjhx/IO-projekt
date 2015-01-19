package pl.polsl.platforma.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import pl.polsl.paltforma.dao.UzytkownicyDAO;
import pl.polsl.paltforma.dao.ZnajomiDAO;
import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Uzytkownicy;
import pl.polsl.platforma.model.Znajomi;
import pl.polsl.platforma.ui.ZnajomiModuleUI;

public class ZnajomiController {

	private ZnajomiModuleUI frame;
	private Uzytkownicy uzytkownik;

	public ZnajomiController(Uzytkownicy u) {
		this.uzytkownik = u;
		frame = new ZnajomiModuleUI();
		zaladujZnajomych();
		frame.addZnajdzListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				szukajZnajomego();
			}
		});
	}

	private void szukajZnajomego() {
		Uzytkownicy u = UzytkownicyDAO.getByLogin(frame.getLoginText());
		if (u != null) {
			if (u.getIdUzytkownika() != uzytkownik.getIdUzytkownika()) {
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Znaleziono uzytkownika: " + u.getLogin()
								+ ". Jego nick: " + u.getNick()
								+ ". Dodac jako znajomego?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					dodajZnajomego(u);
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Nie mozesz dodac samego siebie jako znajomego!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Nie znaleiono podanego uzytkownika!");
		}
	}
	
	private void dodajZnajomego(Uzytkownicy u) {
		if (!ZnajomiDAO.sprawdzCzySaZnajomymi(this.uzytkownik.getLogin(), u.getLogin())) {
			Znajomi z = new Znajomi();
			z.setUzytkownicy1(uzytkownik);
			z.setUzytkownicy2(u);
			z.setDataZawarciaZnajomosci(new Date());
			DatabaseConnector dbc = DatabaseConnector.getInstance();
			dbc.beginTransaction();
			dbc.mergeTransaction(z);
			dbc.endTransaction();
			frame.dodajZnajomegoDoListy(u.getLogin() + " " + u.getStatusy().getNazwaStatusu());
		} else {
			JOptionPane.showMessageDialog(null, "Juz jestescie znajomymi!");
		}
	}

	public void start() {
		frame.setVisible(true);
	}

	private void zaladujZnajomych() {
		frame.zaladujZnajomychDoListy(ZnajomiDAO.getZnajomiByLogin(uzytkownik
				.getLogin()));
	}
}
