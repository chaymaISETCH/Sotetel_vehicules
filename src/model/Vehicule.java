package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicule database table.
 * 
 */
@Entity
@Table(name="vehicule")
@NamedQuery(name="Vehicule.findAll", query="SELECT v FROM Vehicule v")
public class Vehicule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String matricule;

	@Column(nullable=false, length=45)
	private String carburant;

	@Column(nullable=false, length=45)
	private String categorie;

	@Column(nullable=false, length=9)
	private String couleur;

	@Temporal(TemporalType.DATE)
	@Column(name="date_achat", nullable=false)
	private Date dateAchat;

	@Lob
	@Column(nullable=false)
	private byte[] image;

	@Column(nullable=false, length=45)
	private String marque;

	@Column(nullable=false, length=45)
	private String modele;

	@Column(name="num_carte_grise", nullable=false, length=45)
	private String numCarteGrise;

	@Column(nullable=false)
	private int puissance;

	//bi-directional many-to-one association to Assurance
	@OneToMany(mappedBy="vehicule")
	private List<Assurance> assurances;

	//bi-directional many-to-one association to CarteCarburant
	@OneToMany(mappedBy="vehicule")
	private List<CarteCarburant> carteCarburants;

	//bi-directional many-to-one association to Maintenance
	@OneToMany(mappedBy="vehicule")
	private List<Maintenance> maintenances;



	//bi-directional many-to-one association to VisiteTechnique
	@OneToMany(mappedBy="vehicule")
	private List<VisiteTechnique> visiteTechniques;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="vehicule")
	private List<Affectation> affectations;

	public Vehicule() {
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getCarburant() {
		return this.carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Date getDateAchat() {
		return this.dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getNumCarteGrise() {
		return this.numCarteGrise;
	}

	public void setNumCarteGrise(String numCarteGrise) {
		this.numCarteGrise = numCarteGrise;
	}

	public int getPuissance() {
		return this.puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public List<Assurance> getAssurances() {
		return this.assurances;
	}

	public void setAssurances(List<Assurance> assurances) {
		this.assurances = assurances;
	}

	public Assurance addAssurance(Assurance assurance) {
		getAssurances().add(assurance);
		assurance.setVehicule(this);

		return assurance;
	}

	public Assurance removeAssurance(Assurance assurance) {
		getAssurances().remove(assurance);
		assurance.setVehicule(null);

		return assurance;
	}

	public List<CarteCarburant> getCarteCarburants() {
		return this.carteCarburants;
	}

	public void setCarteCarburants(List<CarteCarburant> carteCarburants) {
		this.carteCarburants = carteCarburants;
	}

	public CarteCarburant addCarteCarburant(CarteCarburant carteCarburant) {
		getCarteCarburants().add(carteCarburant);
		carteCarburant.setVehicule(this);

		return carteCarburant;
	}

	public CarteCarburant removeCarteCarburant(CarteCarburant carteCarburant) {
		getCarteCarburants().remove(carteCarburant);
		carteCarburant.setVehicule(null);

		return carteCarburant;
	}

	public List<Maintenance> getMaintenances() {
		return this.maintenances;
	}

	public void setMaintenances(List<Maintenance> maintenances) {
		this.maintenances = maintenances;
	}

	public Maintenance addMaintenance(Maintenance maintenance) {
		getMaintenances().add(maintenance);
		maintenance.setVehicule(this);

		return maintenance;
	}

	public Maintenance removeMaintenance(Maintenance maintenance) {
		getMaintenances().remove(maintenance);
		maintenance.setVehicule(null);

		return maintenance;
	}



	public List<VisiteTechnique> getVisiteTechniques() {
		return this.visiteTechniques;
	}

	public void setVisiteTechniques(List<VisiteTechnique> visiteTechniques) {
		this.visiteTechniques = visiteTechniques;
	}

	public VisiteTechnique addVisiteTechnique(VisiteTechnique visiteTechnique) {
		getVisiteTechniques().add(visiteTechnique);
		visiteTechnique.setVehicule(this);

		return visiteTechnique;
	}

	public VisiteTechnique removeVisiteTechnique(VisiteTechnique visiteTechnique) {
		getVisiteTechniques().remove(visiteTechnique);
		visiteTechnique.setVehicule(null);

		return visiteTechnique;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setVehicule(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setVehicule(null);

		return affectation;
	}

}