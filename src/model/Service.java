package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@Table(name="service")
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String service;

	@Column(length=250)
	private String des;

	//bi-directional many-to-one association to AffectationService
	@OneToMany(mappedBy="service")
	private List<AffectationService> affectationServices;

	public Service() {
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public List<AffectationService> getAffectationServices() {
		return this.affectationServices;
	}

	public void setAffectationServices(List<AffectationService> affectationServices) {
		this.affectationServices = affectationServices;
	}

	public AffectationService addAffectationService(AffectationService affectationService) {
		getAffectationServices().add(affectationService);
		affectationService.setService(this);

		return affectationService;
	}

	public AffectationService removeAffectationService(AffectationService affectationService) {
		getAffectationServices().remove(affectationService);
		affectationService.setService(null);

		return affectationService;
	}

}