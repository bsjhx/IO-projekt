package pl.polsl.paltforma.dao;

import java.util.List;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;
import pl.polsl.platforma.model.Waluty;

public class WalutyDAO {
	public WalutyDAO() {
		
	}
	
	public static List<Waluty> getAll() {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("Waluty.findAll");
		return q.getResultList();	
	}
	
	public static Waluty getByName(String name) {
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();
		Query q = dbs.getEm().createNamedQuery("Waluty.findByName");
		q.setParameter("nazwaWhere", name);
		return (Waluty) q.getResultList().get(0);	
	}
	
}
