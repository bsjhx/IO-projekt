package pl.polsl.platforma.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PosiadaczeGry database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="PosiadaczeGry.findAll", query="SELECT p FROM PosiadaczeGry p"),
@NamedQuery(name="PosiadaczeGry.findByUzytkownik", query="SELECT p FROM PosiadaczeGry p where p.uzytkownicy.login = :loginWhere")
})
public class PosiadaczeGry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPosiadaczaGry;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZakupuGry;

	private String wersjaGry;

	//bi-directional many-to-one association to Gry
	@ManyToOne
	@JoinColumn(name="idGry")
	private Gry gry;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika")
	private Uzytkownicy uzytkownicy;

	public PosiadaczeGry() {
	}

	public int getIdPosiadaczaGry() {
		return this.idPosiadaczaGry;
	}

	public void setIdPosiadaczaGry(int idPosiadaczaGry) {
		this.idPosiadaczaGry = idPosiadaczaGry;
	}

	public Date getDataZakupuGry() {
		return this.dataZakupuGry;
	}

	public void setDataZakupuGry(Date dataZakupuGry) {
		this.dataZakupuGry = dataZakupuGry;
	}

	public String getWersjaGry() {
		return this.wersjaGry;
	}

	public void setWersjaGry(String wersjaGry) {
		this.wersjaGry = wersjaGry;
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