package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the StatystykiGry database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "StatystykiGry.findAll", query = "SELECT s FROM StatystykiGry s"),
		@NamedQuery(name = "StatystykiGry.findByNameAndGry", query = "SELECT s FROM StatystykiGry s WHERE s.gry.idGry = :gryWhere and s.nazwaInformacji = :nazwaWhere") })
public class StatystykiGry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idStatystykiGry;

	private String nazwaInformacji;

	// bi-directional many-to-one association to StatystykiGracza
	@OneToMany(mappedBy = "statystykiGry")
	private List<StatystykiGracza> statystykiGraczas;

	// bi-directional many-to-one association to Gry
	@ManyToOne
	@JoinColumn(name = "idGry")
	private Gry gry;

	public StatystykiGry() {
	}

	public int getIdStatystykiGry() {
		return this.idStatystykiGry;
	}

	public void setIdStatystykiGry(int idStatystykiGry) {
		this.idStatystykiGry = idStatystykiGry;
	}

	public String getNazwaInformacji() {
		return this.nazwaInformacji;
	}

	public void setNazwaInformacji(String nazwaInformacji) {
		this.nazwaInformacji = nazwaInformacji;
	}

	public List<StatystykiGracza> getStatystykiGraczas() {
		return this.statystykiGraczas;
	}

	public void setStatystykiGraczas(List<StatystykiGracza> statystykiGraczas) {
		this.statystykiGraczas = statystykiGraczas;
	}

	public StatystykiGracza addStatystykiGracza(
			StatystykiGracza statystykiGracza) {
		getStatystykiGraczas().add(statystykiGracza);
		statystykiGracza.setStatystykiGry(this);

		return statystykiGracza;
	}

	public StatystykiGracza removeStatystykiGracza(
			StatystykiGracza statystykiGracza) {
		getStatystykiGraczas().remove(statystykiGracza);
		statystykiGracza.setStatystykiGry(null);

		return statystykiGracza;
	}

	public Gry getGry() {
		return this.gry;
	}

	public void setGry(Gry gry) {
		this.gry = gry;
	}

}