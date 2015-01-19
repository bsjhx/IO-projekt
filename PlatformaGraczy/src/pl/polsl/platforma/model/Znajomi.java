package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Znajomi database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Znajomi.findAll", query="SELECT z FROM Znajomi z"),
@NamedQuery(name="Znajomi.findByName", query="SELECT z FROM Znajomi z WHERE z.uzytkownicy1.login = :loginWhere OR z.uzytkownicy2.login = :loginWhere")
})
public class Znajomi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idZnajomosci;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZawarciaZnajomosci;
	
	

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika2")
	private Uzytkownicy uzytkownicy1;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika1")
	private Uzytkownicy uzytkownicy2;

	public Znajomi() {
	}

	public int getIdZnajomosci() {
		return this.idZnajomosci;
	}

	public void setIdZnajomosci(int idZnajomosci) {
		this.idZnajomosci = idZnajomosci;
	}

	public Date getDataZawarciaZnajomosci() {
		return this.dataZawarciaZnajomosci;
	}

	public void setDataZawarciaZnajomosci(Date dataZawarciaZnajomosci) {
		this.dataZawarciaZnajomosci = dataZawarciaZnajomosci;
	}

	public Uzytkownicy getUzytkownicy1() {
		return this.uzytkownicy1;
	}

	public void setUzytkownicy1(Uzytkownicy uzytkownicy1) {
		this.uzytkownicy1 = uzytkownicy1;
	}

	public Uzytkownicy getUzytkownicy2() {
		return this.uzytkownicy2;
	}

	public void setUzytkownicy2(Uzytkownicy uzytkownicy2) {
		this.uzytkownicy2 = uzytkownicy2;
	}

}