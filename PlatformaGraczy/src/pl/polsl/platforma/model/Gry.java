package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Gry database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Gry.findAll", query = "SELECT g FROM Gry g"),
		@NamedQuery(name = "Gry.findByName", query = "SELECT g FROM Gry g WHERE g.nazwaGry = :nazwaWhere") })
public class Gry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGry;

	private float cena;

	private String nazwaGry;

	// bi-directional many-to-one association to Gatunki
	@ManyToOne
	@JoinColumn(name = "idGatunku")
	private Gatunki gatunki;

	// bi-directional many-to-one association to Pegi
	@ManyToOne
	@JoinColumn(name = "idPEGI")
	private Pegi pegi;

	// bi-directional many-to-one association to Wydawcy
	@ManyToOne
	@JoinColumn(name = "idWydawcy")
	private Wydawcy wydawcy;

	// bi-directional many-to-one association to PosiadaczeGry
	@OneToMany(mappedBy = "gry")
	private List<PosiadaczeGry> posiadaczeGries;

	// bi-directional many-to-one association to SesjeGry
	@OneToMany(mappedBy = "gry")
	private List<SesjeGry> sesjeGries;

	// bi-directional many-to-one association to StatystykiGry
	@OneToMany(mappedBy = "gry")
	private List<StatystykiGry> statystykiGries;

	// bi-directional many-to-one association to Transakcje
	@OneToMany(mappedBy = "gry")
	private List<Transakcje> transakcjes;

	public Gry() {
	}

	public int getIdGry() {
		return this.idGry;
	}

	public void setIdGry(int idGry) {
		this.idGry = idGry;
	}

	public float getCena() {
		return this.cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getNazwaGry() {
		return this.nazwaGry;
	}

	public void setNazwaGry(String nazwaGry) {
		this.nazwaGry = nazwaGry;
	}

	public Gatunki getGatunki() {
		return this.gatunki;
	}

	public void setGatunki(Gatunki gatunki) {
		this.gatunki = gatunki;
	}

	public Pegi getPegi() {
		return this.pegi;
	}

	public void setPegi(Pegi pegi) {
		this.pegi = pegi;
	}

	public Wydawcy getWydawcy() {
		return this.wydawcy;
	}

	public void setWydawcy(Wydawcy wydawcy) {
		this.wydawcy = wydawcy;
	}

	public List<PosiadaczeGry> getPosiadaczeGries() {
		return this.posiadaczeGries;
	}

	public void setPosiadaczeGries(List<PosiadaczeGry> posiadaczeGries) {
		this.posiadaczeGries = posiadaczeGries;
	}

	public PosiadaczeGry addPosiadaczeGry(PosiadaczeGry posiadaczeGry) {
		getPosiadaczeGries().add(posiadaczeGry);
		posiadaczeGry.setGry(this);

		return posiadaczeGry;
	}

	public PosiadaczeGry removePosiadaczeGry(PosiadaczeGry posiadaczeGry) {
		getPosiadaczeGries().remove(posiadaczeGry);
		posiadaczeGry.setGry(null);

		return posiadaczeGry;
	}

	public List<SesjeGry> getSesjeGries() {
		return this.sesjeGries;
	}

	public void setSesjeGries(List<SesjeGry> sesjeGries) {
		this.sesjeGries = sesjeGries;
	}

	public SesjeGry addSesjeGry(SesjeGry sesjeGry) {
		getSesjeGries().add(sesjeGry);
		sesjeGry.setGry(this);

		return sesjeGry;
	}

	public SesjeGry removeSesjeGry(SesjeGry sesjeGry) {
		getSesjeGries().remove(sesjeGry);
		sesjeGry.setGry(null);

		return sesjeGry;
	}

	public List<StatystykiGry> getStatystykiGries() {
		return this.statystykiGries;
	}

	public void setStatystykiGries(List<StatystykiGry> statystykiGries) {
		this.statystykiGries = statystykiGries;
	}

	public StatystykiGry addStatystykiGry(StatystykiGry statystykiGry) {
		getStatystykiGries().add(statystykiGry);
		statystykiGry.setGry(this);

		return statystykiGry;
	}

	public StatystykiGry removeStatystykiGry(StatystykiGry statystykiGry) {
		getStatystykiGries().remove(statystykiGry);
		statystykiGry.setGry(null);

		return statystykiGry;
	}

	public List<Transakcje> getTransakcjes() {
		return this.transakcjes;
	}

	public void setTransakcjes(List<Transakcje> transakcjes) {
		this.transakcjes = transakcjes;
	}

	public Transakcje addTransakcje(Transakcje transakcje) {
		getTransakcjes().add(transakcje);
		transakcje.setGry(this);

		return transakcje;
	}

	public Transakcje removeTransakcje(Transakcje transakcje) {
		getTransakcjes().remove(transakcje);
		transakcje.setGry(null);

		return transakcje;
	}

}