package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@Table(name="projet")
@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int code;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deb", nullable=false)
	private Date dateDeb;

	@Column(nullable=false)
	private int duree;

	@Column(nullable=false, length=45)
	private String lib;

	//bi-directional many-to-one association to Mission
	@OneToMany(mappedBy="projet")
	private List<Mission> missions;

	//bi-directional many-to-one association to Personnel
	@ManyToOne
	@JoinColumn(name="login_chef_de_projet", nullable=false)
	private Personnel personnel;

	public Projet() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getLib() {
		return this.lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public List<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Mission addMission(Mission mission) {
		getMissions().add(mission);
		mission.setProjet(this);

		return mission;
	}

	public Mission removeMission(Mission mission) {
		getMissions().remove(mission);
		mission.setProjet(null);

		return mission;
	}

	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

}