package pl.polsl.paltforma.dao;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Gry;
import pl.polsl.platforma.model.StatystykiGry;

public class StatystykiGryDAO {

	public static StatystykiGry getByGryAndName(int gra, String nazwa) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm()
				.createNamedQuery("StatystykiGry.findByNameAndGry");
		q.setParameter("nazwaWhere", nazwa);
		q.setParameter("gryWhere", gra);
		
		if (!q.getResultList().isEmpty()) {
			return (StatystykiGry) q.getResultList().get(0);
		} else {
			return null;
		}
	}
}
