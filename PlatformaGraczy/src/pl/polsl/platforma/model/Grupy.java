package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Grupy database table.
 * 
 */
@Entity
@NamedQuery(name="Grupy.findAll", query="SELECT g FROM Grupy g")
public class Grupy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGrupy;

	private String nazwaGrupy;

	@Lob
	private String opisGrupy;

	//bi-directional many-to-one association to SzczegolyGrupy
	@OneToMany(mappedBy="grupy")
	private List<SzczegolyGrupy> szczegolyGrupies;

	public Grupy() {
	}

	public int getIdGrupy() {
		return this.idGrupy;
	}

	public void setIdGrupy(int idGrupy) {
		this.idGrupy = idGrupy;
	}

	public String getNazwaGrupy() {
		return this.nazwaGrupy;
	}

	public void setNazwaGrupy(String nazwaGrupy) {
		this.nazwaGrupy = nazwaGrupy;
	}

	public String getOpisGrupy() {
		return this.opisGrupy;
	}

	public void setOpisGrupy(String opisGrupy) {
		this.opisGrupy = opisGrupy;
	}

	public List<SzczegolyGrupy> getSzczegolyGrupies() {
		return this.szczegolyGrupies;
	}

	public void setSzczegolyGrupies(List<SzczegolyGrupy> szczegolyGrupies) {
		this.szczegolyGrupies = szczegolyGrupies;
	}

	public SzczegolyGrupy addSzczegolyGrupy(SzczegolyGrupy szczegolyGrupy) {
		getSzczegolyGrupies().add(szczegolyGrupy);
		szczegolyGrupy.setGrupy(this);

		return szczegolyGrupy;
	}

	public SzczegolyGrupy removeSzczegolyGrupy(SzczegolyGrupy szczegolyGrupy) {
		getSzczegolyGrupies().remove(szczegolyGrupy);
		szczegolyGrupy.setGrupy(null);

		return szczegolyGrupy;
	}

}