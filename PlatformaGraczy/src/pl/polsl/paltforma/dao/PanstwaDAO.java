package pl.polsl.paltforma.dao;

import java.util.List;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Panstwa;
import pl.polsl.platforma.model.Waluty;

public class PanstwaDAO {
	
	public PanstwaDAO() {
	}
	
	public static List<Panstwa> getAll() {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("Panstwa.findAll");
		return q.getResultList();	
	}
	
	public static Panstwa getByName(String name) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("Panstwa.findByName");
		q.setParameter("nazwaWhere", name);
		return (Panstwa) q.getResultList().get(0);	
	}
	

}
