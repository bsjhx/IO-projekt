package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Wydawcy database table.
 * 
 */
@Entity
@NamedQuery(name="Wydawcy.findAll", query="SELECT w FROM Wydawcy w")
public class Wydawcy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idWydawcy;

	private String nazwaWydawcy;

	@Lob
	private String opisWydawcy;

	//bi-directional many-to-one association to Gry
	@OneToMany(mappedBy="wydawcy")
	private List<Gry> gries;

	public Wydawcy() {
	}

	public int getIdWydawcy() {
		return this.idWydawcy;
	}

	public void setIdWydawcy(int idWydawcy) {
		this.idWydawcy = idWydawcy;
	}

	public String getNazwaWydawcy() {
		return this.nazwaWydawcy;
	}

	public void setNazwaWydawcy(String nazwaWydawcy) {
		this.nazwaWydawcy = nazwaWydawcy;
	}

	public String getOpisWydawcy() {
		return this.opisWydawcy;
	}

	public void setOpisWydawcy(String opisWydawcy) {
		this.opisWydawcy = opisWydawcy;
	}

	public List<Gry> getGries() {
		return this.gries;
	}

	public void setGries(List<Gry> gries) {
		this.gries = gries;
	}

	public Gry addGry(Gry gry) {
		getGries().add(gry);
		gry.setWydawcy(this);

		return gry;
	}

	public Gry removeGry(Gry gry) {
		getGries().remove(gry);
		gry.setWydawcy(null);

		return gry;
	}

}