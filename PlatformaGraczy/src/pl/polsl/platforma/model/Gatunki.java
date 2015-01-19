package pl.polsl.platforma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Gatunki database table.
 * 
 */
@Entity
@NamedQuery(name="Gatunki.findAll", query="SELECT g FROM Gatunki g")
public class Gatunki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte idGatunku;

	private String nazwaGatunku;

	@Lob
	private String opisGatunku;

	//bi-directional many-to-one association to Gry
	@OneToMany(mappedBy="gatunki")
	private List<Gry> gries;

	public Gatunki() {
	}

	public byte getIdGatunku() {
		return this.idGatunku;
	}

	public void setIdGatunku(byte idGatunku) {
		this.idGatunku = idGatunku;
	}

	public String getNazwaGatunku() {
		return this.nazwaGatunku;
	}

	public void setNazwaGatunku(String nazwaGatunku) {
		this.nazwaGatunku = nazwaGatunku;
	}

	public String getOpisGatunku() {
		return this.opisGatunku;
	}

	public void setOpisGatunku(String opisGatunku) {
		this.opisGatunku = opisGatunku;
	}

	public List<Gry> getGries() {
		return this.gries;
	}

	public void setGries(List<Gry> gries) {
		this.gries = gries;
	}

	public Gry addGry(Gry gry) {
		getGries().add(gry);
		gry.setGatunki(this);

		return gry;
	}

	public Gry removeGry(Gry gry) {
		getGries().remove(gry);
		gry.setGatunki(null);

		return gry;
	}

}