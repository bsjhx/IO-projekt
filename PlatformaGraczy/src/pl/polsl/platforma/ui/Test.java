package pl.polsl.platforma.ui;

import javax.persistence.Query;

import pl.polsl.platforma.database.DatabaseConnector;

public class Test {
	public static void main(String[] args) {
		
		DatabaseConnector dbs = DatabaseConnector.getInstance();
		dbs.connect();		
		dbs.beginTransaction();
		String a = "Battlefield 4", b = "Battlefield 3";
		Query q = dbs.createQuery("update Gry set nazwaGry=:a where nazwaGry=:b");
		q.setParameter("a", b);
		q.setParameter("b", a);
		q.executeUpdate();
		dbs.endTransaction();
		
	}
}
