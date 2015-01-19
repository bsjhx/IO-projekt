package pl.polsl.paltforma.dao;

import java.util.List;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.PosiadaczeGry;

public class PosiadaczeGryDAO {
	
	public PosiadaczeGryDAO() {
		
	}

	public static List<PosiadaczeGry> getAll() {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("PosiadaczeGry.findAll");
		return q.getResultList();		
	}
	
	public static List<PosiadaczeGry> getByName(String name) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("PosiadaczeGry.findByUzytkownik");
		q.setParameter("loginWhere", name);
		return q.getResultList();
	}
}
