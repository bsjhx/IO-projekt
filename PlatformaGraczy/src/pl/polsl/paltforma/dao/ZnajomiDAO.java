package pl.polsl.paltforma.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Uzytkownicy;
import pl.polsl.platforma.model.Znajomi;

public class ZnajomiDAO {

	/**
	 * 
	 * @param login
	 *            login uzytkownika, ktorego znajomych szukamy
	 * @return lista loginów znajomych zadanego uzytkownika
	 */
	public static List<String> getZnajomiByLogin(String login) {
		List<String> listReturn = new ArrayList<String>();
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("Znajomi.findByName");
		q.setParameter("loginWhere", login);
		List<Znajomi> list = q.getResultList();

		for (Znajomi z : list) {
			if (z.getUzytkownicy1().getLogin().equals(login)) {
				listReturn.add(z.getUzytkownicy2().getLogin() + " "
						+ z.getUzytkownicy2().getStatusy().getNazwaStatusu());

			} else {
				listReturn.add(z.getUzytkownicy1().getLogin() + " "
						+ z.getUzytkownicy1().getStatusy().getNazwaStatusu());
			}
		}

		return listReturn;
	}

	/**
	 * Sprawdza, czy para zadanych uzytkonikow jest znajomymi
	 * 
	 * @param szukajacy
	 *            uzytkownik, ktory wyszukuje
	 * @param szukany
	 *            poszukiwany uzytkownik
	 * @return true - jezeli sa znajomymi
	 */
	public static boolean sprawdzCzySaZnajomymi(String szukajacy,
			String szukany) {
		List<String> list = getZnajomiByLogin(szukajacy);

		if (!list.isEmpty()) {
			for (String s : list) {
				String[] sTab = s.split(" ");
				System.out.println(sTab[0]);
				if (sTab[0].equals(szukany)) {
					return true;
				}
			}
		}
		return false;
	}
}
