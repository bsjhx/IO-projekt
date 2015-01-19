package pl.polsl.platforma.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import pl.polsl.paltforma.dao.GryDAO;
import pl.polsl.paltforma.dao.PosiadaczeGryDAO;
import pl.polsl.paltforma.dao.StatystykiGraczaDAO;
import pl.polsl.paltforma.dao.StatystykiGryDAO;
import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Gry;
import pl.polsl.platforma.model.PosiadaczeGry;
import pl.polsl.platforma.model.SesjeGry;
import pl.polsl.platforma.model.StatystykiGracza;
import pl.polsl.platforma.model.StatystykiGry;
import pl.polsl.platforma.model.Uzytkownicy;
import pl.polsl.platforma.ui.MainWindow;

public class MainController {

	private MainWindow frame;
	private Uzytkownicy uzytkownik;
	private List<Gry> posiadaneGry = null;
	private SesjeGry sesja;
	private Date dataRoz;
	private Date dataZak;
	private Gry gra;
	

	public MainController(Uzytkownicy u) {
		this.uzytkownik = u;
		frame = new MainWindow();
		frame.setLoginUzytkownika(uzytkownik.getLogin());
		zaladujGry();
		if (posiadaneGry != null) {
			frame.zaladujGryDoListy(posiadaneGry);
		}

		frame.addZnajomiListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ZnajomiController znajomi = new ZnajomiController(uzytkownik);
				znajomi.start();
			}
		});

		frame.addZagrajListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zagraj();
			}
		});

		frame.addZakonczListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zakonczGranie();
			}
		});
	}

	private void zagraj() {
		String tytul = frame.getWybranaGra();
		System.out.println(tytul);
		if (tytul != null) {
			gra = GryDAO.getByName(tytul);
			sesja = new SesjeGry();
			sesja.setGry(gra);
			sesja.setUzytkownicy(uzytkownik);
			dataRoz = new Date();
			sesja.setDataRozpoczeciaRozgrywki(dataRoz);
			frame.zacznijGracPrzyciski();
		} else {
			JOptionPane.showMessageDialog(null, "Wybierz grê!");
		}
	}

	private void zakonczGranie() {
		dataZak = new Date();
		sesja.setDataZakonczeniaRozgrywki(dataZak);
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();		
		dbs.beginTransaction();
		dbs.mergeTransaction(sesja);
		dbs.endTransaction();
		frame.zakonczGracPrzyciski();
		wykonajStatystyki();
	}
	
	private void wykonajStatystyki() {
		long czasGry = dataZak.getTime() - dataRoz.getTime();
		czasGry = czasGry/1000;
		int intCzasGry = (int) czasGry;
		StatystykiGracza staGracza = StatystykiGraczaDAO.get(uzytkownik.getIdUzytkownika(), "Czas gry", gra.getIdGry());
		
		
		if (staGracza == null) {
			staGracza = new StatystykiGracza();
			StatystykiGry staGry = StatystykiGryDAO.getByGryAndName(gra.getIdGry(), "Czas gry");
			staGracza.setStatystykiGry(staGry);
			staGracza.setUzytkownicy(uzytkownik);			
			staGracza.setWartosc(intCzasGry);
			DatabaseConnector dbs = DatabaseConnector.getInstance();
			dbs.beginTransaction();
			dbs.mergeTransaction(staGracza);
			dbs.endTransaction();
			System.out.println(staGracza.getIdStatystykiGracza());
		} else {
			DatabaseConnector dbs = DatabaseConnector.getInstance();
			dbs.connect();		
			dbs.beginTransaction();
			Query q = dbs.createQuery("update StatystykiGracza set wartosc=:w where idStatystykiGracza=:idSG");
			intCzasGry = staGracza.getWartosc() + intCzasGry;
			q.setParameter("w", intCzasGry);
			q.setParameter("idSG", staGracza.getIdStatystykiGracza());
			q.executeUpdate();
			dbs.endTransaction();
			System.out.println(staGracza.getIdStatystykiGracza());
		}
	}

	public void start() {
		frame.setVisible(true);
	}

	private void zaladujGry() {
		List<PosiadaczeGry> uzytkownikPosiadacz = PosiadaczeGryDAO
				.getByName(uzytkownik.getLogin());
		posiadaneGry = new ArrayList<Gry>();
		for (PosiadaczeGry p : uzytkownikPosiadacz) {
			posiadaneGry.add(p.getGry());
		}
	}
}
