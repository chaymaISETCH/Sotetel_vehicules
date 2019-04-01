package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compagnie database table.
 * 
 */
@Entity
@Table(name="compagnie")
@NamedQuery(name="Compagnie.findAll", query="SELECT c FROM Compagnie c")
public class Compagnie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int num;

	@Column(nullable=false, length=45)
	private String adresse;

	@Column(nullable=false, length=45)
	private String lib;

	//bi-directional many-to-one association to Assurance
	@OneToMany(mappedBy="compagnie")
	private List<Assurance> assurances;

	public Compagnie() {
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLib() {
		return this.lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public List<Assurance> getAssurances() {
		return this.assurances;
	}

	public void setAssurances(List<Assurance> assurances) {
		this.assurances = assurances;
	}

	public Assurance addAssurance(Assurance assurance) {
		getAssurances().add(assurance);
		assurance.setCompagnie(this);

		return assurance;
	}

	public Assurance removeAssurance(Assurance assurance) {
		getAssurances().remove(assurance);
		assurance.setCompagnie(null);

		return assurance;
	}

}