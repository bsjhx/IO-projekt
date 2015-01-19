package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SesjeGry database table.
 * 
 */
@Entity
@NamedQuery(name="SesjeGry.findAll", query="SELECT s FROM SesjeGry s")
public class SesjeGry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSesjiGry;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRozpoczeciaRozgrywki;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZakonczeniaRozgrywki;

	//bi-directional many-to-one association to Gry
	@ManyToOne
	@JoinColumn(name="idGry")
	private Gry gry;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika")
	private Uzytkownicy uzytkownicy;

	public SesjeGry() {
	}

	public int getIdSesjiGry() {
		return this.idSesjiGry;
	}

	public void setIdSesjiGry(int idSesjiGry) {
		this.idSesjiGry = idSesjiGry;
	}

	public Date getDataRozpoczeciaRozgrywki() {
		return this.dataRozpoczeciaRozgrywki;
	}

	public void setDataRozpoczeciaRozgrywki(Date dataRozpoczeciaRozgrywki) {
		this.dataRozpoczeciaRozgrywki = dataRozpoczeciaRozgrywki;
	}

	public Date getDataZakonczeniaRozgrywki() {
		return this.dataZakonczeniaRozgrywki;
	}

	public void setDataZakonczeniaRozgrywki(Date dataZakonczeniaRozgrywki) {
		this.dataZakonczeniaRozgrywki = dataZakonczeniaRozgrywki;
	}

	public Gry getGry() {
		return this.gry;
	}

	public void setGry(Gry gry) {
		this.gry = gry;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}