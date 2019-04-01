package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the affectation_service database table.
 * 
 */
@Embeddable
public class AffectationServicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(unique=true, nullable=false)
	private java.util.Date date;

	@Column(unique=true, nullable=false, length=45)
	private String matricule;

	@Column(unique=true, nullable=false, length=45)
	private String ser;

	public AffectationServicePK() {
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getMatricule() {
		return this.matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getSer() {
		return this.ser;
	}
	public void setSer(String ser) {
		this.ser = ser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AffectationServicePK)) {
			return false;
		}
		AffectationServicePK castOther = (AffectationServicePK)other;
		return 
			this.date.equals(castOther.date)
			&& this.matricule.equals(castOther.matricule)
			&& this.ser.equals(castOther.ser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.matricule.hashCode();
		hash = hash * prime + this.ser.hashCode();
		
		return hash;
	}
}