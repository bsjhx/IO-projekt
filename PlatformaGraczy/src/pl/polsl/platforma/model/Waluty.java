package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Waluty database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Waluty.findAll", query = "SELECT w FROM Waluty w"),
		@NamedQuery(name = "Waluty.findByName", query = "SELECT w FROM Waluty w WHERE w.nazwaWaluty = :nazwaWhere") 
})
public class Waluty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte idWaluty;

	private String nazwaWaluty;

	private float przelicznikWzgledemEuro;

	// bi-directional many-to-one association to Uzytkownicy
	@OneToMany(mappedBy = "waluty")
	private List<Uzytkownicy> uzytkownicies;

	public Waluty() {
	}

	public byte getIdWaluty() {
		return this.idWaluty;
	}

	public void setIdWaluty(byte idWaluty) {
		this.idWaluty = idWaluty;
	}

	public String getNazwaWaluty() {
		return this.nazwaWaluty;
	}

	public void setNazwaWaluty(String nazwaWaluty) {
		this.nazwaWaluty = nazwaWaluty;
	}

	public float getPrzelicznikWzgledemEuro() {
		return this.przelicznikWzgledemEuro;
	}

	public void setPrzelicznikWzgledemEuro(float przelicznikWzgledemEuro) {
		this.przelicznikWzgledemEuro = przelicznikWzgledemEuro;
	}

	public List<Uzytkownicy> getUzytkownicies() {
		return this.uzytkownicies;
	}

	public void setUzytkownicies(List<Uzytkownicy> uzytkownicies) {
		this.uzytkownicies = uzytkownicies;
	}

	public Uzytkownicy addUzytkownicy(Uzytkownicy uzytkownicy) {
		getUzytkownicies().add(uzytkownicy);
		uzytkownicy.setWaluty(this);

		return uzytkownicy;
	}

	public Uzytkownicy removeUzytkownicy(Uzytkownicy uzytkownicy) {
		getUzytkownicies().remove(uzytkownicy);
		uzytkownicy.setWaluty(null);

		return uzytkownicy;
	}

}