package pl.polsl.paltforma.dao;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Gry;

public class GryDAO {

	public static Gry getByName(String nazwa) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("Gry.findByName");
		q.setParameter("nazwaWhere", nazwa);
		if (!q.getResultList().isEmpty()) {
			return (Gry) q.getResultList().get(0);
		} else {
			return null;
		}
	}
}
