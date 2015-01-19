package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the StatystykiGracza database table.
 * 
 */
@Entity
@NamedQuery(name="StatystykiGracza.findByStatystykiAndUzytkownicy", query="SELECT s FROM StatystykiGracza s WHERE s.statystykiGry.nazwaInformacji = :nazwaStatystyki and s.uzytkownicy.idUzytkownika = :idUzytkownika and s.statystykiGry.gry.idGry = :idGry")
public class StatystykiGracza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idStatystykiGracza;

	private int wartosc;

	//bi-directional many-to-one association to StatystykiGry
	@ManyToOne
	@JoinColumn(name="idStatystykiGry")
	private StatystykiGry statystykiGry;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="idUzytkownika")
	private Uzytkownicy uzytkownicy;

	public StatystykiGracza() {
	}

	public int getIdStatystykiGracza() {
		return this.idStatystykiGracza;
	}

	public void setIdStatystykiGracza(int idStatystykiGracza) {
		this.idStatystykiGracza = idStatystykiGracza;
	}

	public int getWartosc() {
		return this.wartosc;
	}

	public void setWartosc(int wartosc) {
		this.wartosc = wartosc;
	}

	public StatystykiGry getStatystykiGry() {
		return this.statystykiGry;
	}

	public void setStatystykiGry(StatystykiGry statystykiGry) {
		this.statystykiGry = statystykiGry;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}