package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the visite_technique database table.
 * 
 */
@Entity
@Table(name="visite_technique")
@NamedQuery(name="VisiteTechnique.findAll", query="SELECT v FROM VisiteTechnique v")
public class VisiteTechnique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int num;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false)
	private int duree;

	@Column(nullable=false, length=45)
	private String observation;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne
	@JoinColumn(name="matricule", nullable=false)
	private Vehicule vehicule;

	public VisiteTechnique() {
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}