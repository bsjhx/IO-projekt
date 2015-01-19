package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SposobyPlatnosci database table.
 * 
 */
@Entity
@NamedQuery(name="SposobyPlatnosci.findAll", query="SELECT s FROM SposobyPlatnosci s")
public class SposobyPlatnosci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte idSposobuPlatnosci;

	private String nazwaSposobuPlatnosci;

	//bi-directional many-to-one association to Transakcje
	@OneToMany(mappedBy="sposobyPlatnosci")
	private List<Transakcje> transakcjes;

	public SposobyPlatnosci() {
	}

	public byte getIdSposobuPlatnosci() {
		return this.idSposobuPlatnosci;
	}

	public void setIdSposobuPlatnosci(byte idSposobuPlatnosci) {
		this.idSposobuPlatnosci = idSposobuPlatnosci;
	}

	public String getNazwaSposobuPlatnosci() {
		return this.nazwaSposobuPlatnosci;
	}

	public void setNazwaSposobuPlatnosci(String nazwaSposobuPlatnosci) {
		this.nazwaSposobuPlatnosci = nazwaSposobuPlatnosci;
	}

	public List<Transakcje> getTransakcjes() {
		return this.transakcjes;
	}

	public void setTransakcjes(List<Transakcje> transakcjes) {
		this.transakcjes = transakcjes;
	}

	public Transakcje addTransakcje(Transakcje transakcje) {
		getTransakcjes().add(transakcje);
		transakcje.setSposobyPlatnosci(this);

		return transakcje;
	}

	public Transakcje removeTransakcje(Transakcje transakcje) {
		getTransakcjes().remove(transakcje);
		transakcje.setSposobyPlatnosci(null);

		return transakcje;
	}

}