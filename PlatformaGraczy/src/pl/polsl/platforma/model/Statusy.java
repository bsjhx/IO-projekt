package pl.polsl.platforma.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Statusy database table.
 * 
 */
@Entity
@NamedQuery(name="Statusy.findAll", query="SELECT s FROM Statusy s")
public class Statusy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte idStatusu;

	private String nazwaStatusu;

	//bi-directional many-to-one association to Uzytkownicy
	@OneToMany(mappedBy="statusy")
	private List<Uzytkownicy> uzytkownicies;

	public Statusy() {
	}

	public byte getIdStatusu() {
		return this.idStatusu;
	}

	public void setIdStatusu(byte idStatusu) {
		this.idStatusu = idStatusu;
	}

	public String getNazwaStatusu() {
		return this.nazwaStatusu;
	}

	public void setNazwaStatusu(String nazwaStatusu) {
		this.nazwaStatusu = nazwaStatusu;
	}

	public List<Uzytkownicy> getUzytkownicies() {
		return this.uzytkownicies;
	}

	public void setUzytkownicies(List<Uzytkownicy> uzytkownicies) {
		this.uzytkownicies = uzytkownicies;
	}

	public Uzytkownicy addUzytkownicy(Uzytkownicy uzytkownicy) {
		getUzytkownicies().add(uzytkownicy);
		uzytkownicy.setStatusy(this);

		return uzytkownicy;
	}

	public Uzytkownicy removeUzytkownicy(Uzytkownicy uzytkownicy) {
		getUzytkownicies().remove(uzytkownicy);
		uzytkownicy.setStatusy(null);

		return uzytkownicy;
	}

	public Statusy(byte idStatusu, String nazwaStatusu) {
		super();
		this.idStatusu = idStatusu;
		this.nazwaStatusu = nazwaStatusu;
	}
	
	

}