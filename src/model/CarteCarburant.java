package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carte_carburant database table.
 * 
 */
@Entity
@Table(name="carte_carburant")
@NamedQuery(name="CarteCarburant.findAll", query="SELECT c FROM CarteCarburant c")
public class CarteCarburant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int num;

	@Column(nullable=false)
	private float solde;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne
	@JoinColumn(name="matricule", nullable=false)
	private Vehicule vehicule;

	public CarteCarburant() {
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}