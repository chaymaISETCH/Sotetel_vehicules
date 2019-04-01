package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the assurance database table.
 * 
 */
@Entity
@Table(name="assurance")
@NamedQuery(name="Assurance.findAll", query="SELECT a FROM Assurance a")
public class Assurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="date_deb", nullable=false)
	private Date dateDeb;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin", nullable=false)
	private Date dateFin;

	@Column(nullable=false, length=45)
	private String type;

	//bi-directional many-to-one association to Compagnie
	@ManyToOne
	@JoinColumn(name="num_com", nullable=false)
	private Compagnie compagnie;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne
	@JoinColumn(name="matricule", nullable=false)
	private Vehicule vehicule;

	public Assurance() {
	}

	public Date getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Compagnie getCompagnie() {
		return this.compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}