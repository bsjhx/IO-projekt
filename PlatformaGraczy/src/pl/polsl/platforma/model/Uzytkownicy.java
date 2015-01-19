package pl.polsl.platforma.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Uzytkownicy database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Uzytkownicy.findAll", query = "SELECT u FROM Uzytkownicy u"),
		@NamedQuery(name = "Uzytkownicy.findByLogin", query = "SELECT u FROM Uzytkownicy u WHERE u.login = :loginWhere") 
		})
public class Uzytkownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUzytkownika;

	private byte czyAdministrator;

	@Temporal(TemporalType.DATE)
	private Date dataUrodzenia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZmianyStatusu;

	private String haslo;

	private String login;

	private String nick;

	@Lob
	private String opis;

	// bi-directional many-to-one association to PosiadaczeGry
	@OneToMany(mappedBy = "uzytkownicy")
	private List<PosiadaczeGry> posiadaczeGries;

	// bi-directional many-to-one association to SesjeGry
	@OneToMany(mappedBy = "uzytkownicy")
	private List<SesjeGry> sesjeGries;

	// bi-directional many-to-one association to StatystykiGracza
	@OneToMany(mappedBy = "uzytkownicy")
	private List<StatystykiGracza> statystykiGraczas;

	// bi-directional many-to-one association to SzczegolyGrupy
	@OneToMany(mappedBy = "uzytkownicy")
	private List<SzczegolyGrupy> szczegolyGrupies;

	// bi-directional many-to-one association to Transakcje
	@OneToMany(mappedBy = "uzytkownicy")
	private List<Transakcje> transakcjes;

	// bi-directional many-to-one association to Panstwa
	@ManyToOne
	@JoinColumn(name = "idPanstwa")
	private Panstwa panstwa;

	// bi-directional many-to-one association to Statusy
	@ManyToOne
	@JoinColumn(name = "idStatusu")
	private Statusy statusy;

	// bi-directional many-to-one association to Waluty
	@ManyToOne
	@JoinColumn(name = "idWaluty")
	private Waluty waluty;

	// bi-directional many-to-one association to Znajomi
	@OneToMany(mappedBy = "uzytkownicy1")
	private List<Znajomi> znajomis1;

	// bi-directional many-to-one association to Znajomi
	@OneToMany(mappedBy = "uzytkownicy2")
	private List<Znajomi> znajomis2;

	public Uzytkownicy() {
	}

	public int getIdUzytkownika() {
		return this.idUzytkownika;
	}

	public void setIdUzytkownika(int idUzytkownika) {
		this.idUzytkownika = idUzytkownika;
	}

	public byte getCzyAdministrator() {
		return this.czyAdministrator;
	}

	public void setCzyAdministrator(byte czyAdministrator) {
		this.czyAdministrator = czyAdministrator;
	}

	public Date getDataUrodzenia() {
		return this.dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public Date getDataZmianyStatusu() {
		return this.dataZmianyStatusu;
	}

	public void setDataZmianyStatusu(Date dataZmianyStatusu) {
		this.dataZmianyStatusu = dataZmianyStatusu;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<PosiadaczeGry> getPosiadaczeGries() {
		return this.posiadaczeGries;
	}

	public void setPosiadaczeGries(List<PosiadaczeGry> posiadaczeGries) {
		this.posiadaczeGries = posiadaczeGries;
	}

	public PosiadaczeGry addPosiadaczeGry(PosiadaczeGry posiadaczeGry) {
		getPosiadaczeGries().add(posiadaczeGry);
		posiadaczeGry.setUzytkownicy(this);

		return posiadaczeGry;
	}

	public PosiadaczeGry removePosiadaczeGry(PosiadaczeGry posiadaczeGry) {
		getPosiadaczeGries().remove(posiadaczeGry);
		posiadaczeGry.setUzytkownicy(null);

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
		sesjeGry.setUzytkownicy(this);

		return sesjeGry;
	}

	public SesjeGry removeSesjeGry(SesjeGry sesjeGry) {
		getSesjeGries().remove(sesjeGry);
		sesjeGry.setUzytkownicy(null);

		return sesjeGry;
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
		statystykiGracza.setUzytkownicy(this);

		return statystykiGracza;
	}

	public StatystykiGracza removeStatystykiGracza(
			StatystykiGracza statystykiGracza) {
		getStatystykiGraczas().remove(statystykiGracza);
		statystykiGracza.setUzytkownicy(null);

		return statystykiGracza;
	}

	public List<SzczegolyGrupy> getSzczegolyGrupies() {
		return this.szczegolyGrupies;
	}

	public void setSzczegolyGrupies(List<SzczegolyGrupy> szczegolyGrupies) {
		this.szczegolyGrupies = szczegolyGrupies;
	}

	public SzczegolyGrupy addSzczegolyGrupy(SzczegolyGrupy szczegolyGrupy) {
		getSzczegolyGrupies().add(szczegolyGrupy);
		szczegolyGrupy.setUzytkownicy(this);

		return szczegolyGrupy;
	}

	public SzczegolyGrupy removeSzczegolyGrupy(SzczegolyGrupy szczegolyGrupy) {
		getSzczegolyGrupies().remove(szczegolyGrupy);
		szczegolyGrupy.setUzytkownicy(null);

		return szczegolyGrupy;
	}

	public List<Transakcje> getTransakcjes() {
		return this.transakcjes;
	}

	public void setTransakcjes(List<Transakcje> transakcjes) {
		this.transakcjes = transakcjes;
	}

	public Transakcje addTransakcje(Transakcje transakcje) {
		getTransakcjes().add(transakcje);
		transakcje.setUzytkownicy(this);

		return transakcje;
	}

	public Transakcje removeTransakcje(Transakcje transakcje) {
		getTransakcjes().remove(transakcje);
		transakcje.setUzytkownicy(null);

		return transakcje;
	}

	public Panstwa getPanstwa() {
		return this.panstwa;
	}

	public void setPanstwa(Panstwa panstwa) {
		this.panstwa = panstwa;
	}

	public Statusy getStatusy() {
		return this.statusy;
	}

	public void setStatusy(Statusy statusy) {
		this.statusy = statusy;
	}

	public Waluty getWaluty() {
		return this.waluty;
	}

	public void setWaluty(Waluty waluty) {
		this.waluty = waluty;
	}

	public List<Znajomi> getZnajomis1() {
		return this.znajomis1;
	}

	public void setZnajomis1(List<Znajomi> znajomis1) {
		this.znajomis1 = znajomis1;
	}

	public Znajomi addZnajomis1(Znajomi znajomis1) {
		getZnajomis1().add(znajomis1);
		znajomis1.setUzytkownicy1(this);

		return znajomis1;
	}

	public Znajomi removeZnajomis1(Znajomi znajomis1) {
		getZnajomis1().remove(znajomis1);
		znajomis1.setUzytkownicy1(null);

		return znajomis1;
	}

	public List<Znajomi> getZnajomis2() {
		return this.znajomis2;
	}

	public void setZnajomis2(List<Znajomi> znajomis2) {
		this.znajomis2 = znajomis2;
	}

	public Znajomi addZnajomis2(Znajomi znajomis2) {
		getZnajomis2().add(znajomis2);
		znajomis2.setUzytkownicy2(this);

		return znajomis2;
	}

	public Znajomi removeZnajomis2(Znajomi znajomis2) {
		getZnajomis2().remove(znajomis2);
		znajomis2.setUzytkownicy2(null);

		return znajomis2;
	}

}