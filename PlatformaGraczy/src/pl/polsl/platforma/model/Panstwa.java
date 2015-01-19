package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Panstwa database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Panstwa.findAll", query = "SELECT p FROM Panstwa p"),
		@NamedQuery(name = "Panstwa.findByName", query = "SELECT p FROM Panstwa p WHERE p.nazwaPanstwa = :nazwaWhere") 
		})
public class Panstwa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPanstwa;

	private String nazwaPanstwa;

	// bi-directional many-to-one association to Uzytkownicy
	@OneToMany(mappedBy = "panstwa")
	private List<Uzytkownicy> uzytkownicies;

	public Panstwa() {
	}

	public int getIdPanstwa() {
		return this.idPanstwa;
	}

	public void setIdPanstwa(byte idPanstwa) {
		this.idPanstwa = idPanstwa;
	}

	public String getNazwaPanstwa() {
		return this.nazwaPanstwa;
	}

	public void setNazwaPanstwa(String nazwaPanstwa) {
		this.nazwaPanstwa = nazwaPanstwa;
	}

	public List<Uzytkownicy> getUzytkownicies() {
		return this.uzytkownicies;
	}

	public void setUzytkownicies(List<Uzytkownicy> uzytkownicies) {
		this.uzytkownicies = uzytkownicies;
	}

	public Uzytkownicy addUzytkownicy(Uzytkownicy uzytkownicy) {
		getUzytkownicies().add(uzytkownicy);
		uzytkownicy.setPanstwa(this);

		return uzytkownicy;
	}

	public Uzytkownicy removeUzytkownicy(Uzytkownicy uzytkownicy) {
		getUzytkownicies().remove(uzytkownicy);
		uzytkownicy.setPanstwa(null);

		return uzytkownicy;
	}

}