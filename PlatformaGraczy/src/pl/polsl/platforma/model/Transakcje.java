package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Transakcje database table.
 * 
 */
@Entity
@NamedQuery(name="Transakcje.findAll", query="SELECT t FROM Transakcje t")
public class Transakcje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTransakcji;

	private float kwota;

	//bi-directional many-to-one association to Gry
	@ManyToOne
	@JoinColumn(name="idGry")
	private Gry gry;

	//bi-directional many-to-one association to SposobyPlatnosci
	@ManyToOne
	@JoinColumn(name="idSposobuPlatnosci")
	private SposobyPlatnosci sposobyPlatnosci;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika")
	private Uzytkownicy uzytkownicy;

	public Transakcje() {
	}

	public int getIdTransakcji() {
		return this.idTransakcji;
	}

	public void setIdTransakcji(int idTransakcji) {
		this.idTransakcji = idTransakcji;
	}

	public float getKwota() {
		return this.kwota;
	}

	public void setKwota(float kwota) {
		this.kwota = kwota;
	}

	public Gry getGry() {
		return this.gry;
	}

	public void setGry(Gry gry) {
		this.gry = gry;
	}

	public SposobyPlatnosci getSposobyPlatnosci() {
		return this.sposobyPlatnosci;
	}

	public void setSposobyPlatnosci(SposobyPlatnosci sposobyPlatnosci) {
		this.sposobyPlatnosci = sposobyPlatnosci;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}