package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@Table(name="mission")
@NamedQuery(name="Mission.findAll", query="SELECT m FROM Mission m")
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int num;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deb", nullable=false)
	private Date dateDeb;

	@Column(nullable=false, length=45)
	private String des;

	@Column(nullable=false)
	private int duree;

	//bi-directional many-to-one association to Projet
	@ManyToOne(cascade={CascadeType.REMOVE})
	@JoinColumn(name="code", nullable=false)
	private Projet projet;

	//bi-directional many-to-many association to Personnel
	@ManyToMany(mappedBy="missions")
	private List<Personnel> personnels;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="mission")
	private List<Affectation> affectations;

	public Mission() {
	}
	@Transient
	private int code;
	public int getCode() {
		return this.projet.getCode();
	}

	public void setCode(int c) {
		this.code = this.projet.getCode();
	}
	
	
	
	
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Personnel> getPersonnels() {
		return this.personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setMission(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setMission(null);

		return affectation;
	}

}