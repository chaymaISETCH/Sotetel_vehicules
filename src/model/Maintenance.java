package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the maintenance database table.
 * 
 */
@Entity
@Table(name="maintenance")
@NamedQuery(name="Maintenance.findAll", query="SELECT m FROM Maintenance m")
public class Maintenance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int num;

	@Column(nullable=false, length=45)
	private String cause;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=45)
	private String type;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne
	@JoinColumn(name="matricule", nullable=false)
	private Vehicule vehicule;

	public Maintenance() {
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}