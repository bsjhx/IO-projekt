package pl.polsl.paltforma.dao;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.StatystykiGracza;

public class StatystykiGraczaDAO {
	
	public static StatystykiGracza get(int idUzytkownika, String idStatystyki, int idGry) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("StatystykiGracza.findByStatystykiAndUzytkownicy");
		q.setParameter("nazwaStatystyki", idStatystyki);
		q.setParameter("idUzytkownika", idUzytkownika);
		q.setParameter("idGry", idGry);
		if (q.getResultList().isEmpty()) {
			return null;
		} else {
			return (StatystykiGracza) q.getResultList().get(0);
		}
	}
}
