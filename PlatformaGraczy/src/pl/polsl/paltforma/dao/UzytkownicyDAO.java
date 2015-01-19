package pl.polsl.paltforma.dao;

import java.util.List;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Uzytkownicy;

public class UzytkownicyDAO {

	public UzytkownicyDAO() {
	}

	public static boolean isExists(String login) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		Query q = dbs.getEm().createNamedQuery("Uzytkownicy.findAll");
		List<Uzytkownicy> list = q.getResultList();
		for (Uzytkownicy uz : list) {
			if (uz.getLogin() == login) {
				return true;
			}
		}
		return false;
	}

	public static Uzytkownicy getByLogin(String login) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		Query q = dbs.getEm().createNamedQuery("Uzytkownicy.findByLogin");
		q.setParameter("loginWhere", login);
		if (!q.getResultList().isEmpty()) {
			return (Uzytkownicy) q.getResultList().get(0);
		} else {
			return null;
		}
	}

}
