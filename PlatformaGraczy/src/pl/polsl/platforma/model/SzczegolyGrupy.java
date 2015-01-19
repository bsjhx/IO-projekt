package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SzczegolyGrupy database table.
 * 
 */
@Entity
@NamedQuery(name="SzczegolyGrupy.findAll", query="SELECT s FROM SzczegolyGrupy s")
public class SzczegolyGrupy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSzczegoluGrupy;

	@Temporal(TemporalType.DATE)
	private Date dataDolaczenia;

	//bi-directional many-to-one association to Grupy
	@ManyToOne
	@JoinColumn(name="idGrupy")
	private Grupy grupy;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika")
	private Uzytkownicy uzytkownicy;

	public SzczegolyGrupy() {
	}

	public int getIdSzczegoluGrupy() {
		return this.idSzczegoluGrupy;
	}

	public void setIdSzczegoluGrupy(int idSzczegoluGrupy) {
		this.idSzczegoluGrupy = idSzczegoluGrupy;
	}

	public Date getDataDolaczenia() {
		return this.dataDolaczenia;
	}

	public void setDataDolaczenia(Date dataDolaczenia) {
		this.dataDolaczenia = dataDolaczenia;
	}

	public Grupy getGrupy() {
		return this.grupy;
	}

	public void setGrupy(Grupy grupy) {
		this.grupy = grupy;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}