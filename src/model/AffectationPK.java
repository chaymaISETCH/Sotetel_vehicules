package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the affectation database table.
 * 
 */
@Embeddable
public class AffectationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(unique=true, nullable=false)
	private java.util.Date date;

	@Column(name="num_mission", unique=true, nullable=false)
	private int numMission;

	@Column(unique=true, nullable=false, length=45)
	private String matricule;

	public AffectationPK() {
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getNumMission() {
		return this.numMission;
	}
	public void setNumMission(int numMission) {
		this.numMission = numMission;
	}
	public String getMatricule() {
		return this.matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AffectationPK)) {
			return false;
		}
		AffectationPK castOther = (AffectationPK)other;
		return 
			this.date.equals(castOther.date)
			&& (this.numMission == castOther.numMission)
			&& this.matricule.equals(castOther.matricule);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.numMission;
		hash = hash * prime + this.matricule.hashCode();
		
		return hash;
	}
}