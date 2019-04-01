package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the affectation database table.
 * 
 */
@Entity
@Table(name="affectation")
@NamedQuery(name="Affectation.findAll", query="SELECT a FROM Affectation a")
public class Affectation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AffectationPK id;

	@Column(nullable=false, length=45)
	private String duree;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne
	@JoinColumn(name="matricule", nullable=false, insertable=false, updatable=false)
	private Vehicule vehicule;

	//bi-directional many-to-one association to Mission
	@ManyToOne
	@JoinColumn(name="num_mission", nullable=false, insertable=false, updatable=false)
	private Mission mission;

	public Affectation() {
	}

	public AffectationPK getId() {
		return this.id;
	}

	public void setId(AffectationPK id) {
		this.id = id;
	}

	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}
public String toString() {
	return vehicule.getMatricule();
}
}