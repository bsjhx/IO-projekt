package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PEGI database table.
 * 
 */
@Entity
@Table(name="PEGI")
@NamedQuery(name="Pegi.findAll", query="SELECT p FROM Pegi p")
public class Pegi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte idPEGI;

	private String opis;

	//bi-directional many-to-one association to Gry
	@OneToMany(mappedBy="pegi")
	private List<Gry> gries;

	public Pegi() {
	}

	public byte getIdPEGI() {
		return this.idPEGI;
	}

	public void setIdPEGI(byte idPEGI) {
		this.idPEGI = idPEGI;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Gry> getGries() {
		return this.gries;
	}

	public void setGries(List<Gry> gries) {
		this.gries = gries;
	}

	public Gry addGry(Gry gry) {
		getGries().add(gry);
		gry.setPegi(this);

		return gry;
	}

	public Gry removeGry(Gry gry) {
		getGries().remove(gry);
		gry.setPegi(null);

		return gry;
	}

}