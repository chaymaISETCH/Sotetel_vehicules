package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the affectation_service database table.
 * 
 */
@Entity
@Table(name="affectation_service")
@NamedQuery(name="AffectationService.findAll", query="SELECT a FROM AffectationService a")
public class AffectationService implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AffectationServicePK id;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="ser", nullable=false, insertable=false, updatable=false)
	private Service service;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne
	@JoinColumn(name="matricule", nullable=false, insertable=false, updatable=false)
	private Vehicule vehicule;

	public AffectationService() {
	}

	public AffectationServicePK getId() {
		return this.id;
	}

	public void setId(AffectationServicePK id) {
		this.id = id;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}