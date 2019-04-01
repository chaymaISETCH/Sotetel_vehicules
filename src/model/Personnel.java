package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personnel database table.
 * 
 */
@Entity
@Table(name="personnel")
@NamedQuery(name="Personnel.findAll", query="SELECT p FROM Personnel p")
public class Personnel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=25)
	private String login;

	@Column(nullable=false, length=45)
	private String adresse;

	@Column(nullable=false)
	private int cin;

	@Column(nullable=false, length=45)
	private String email;

	@Column(nullable=false, length=45)
	private String fonction;

	@Column(name="mot_de_passe", nullable=false, length=45)
	private String motDePasse;

	@Column(nullable=false, length=45)
	private String nom;

	@Column(nullable=false, length=45)
	private String prenom;

	@Column(nullable=false, length=6)
	private String sexe;

	@Column(nullable=false)
	private int tel;

	//bi-directional many-to-many association to Mission
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
		name="intervention"
		, joinColumns={
			@JoinColumn(name="login", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="num", nullable=false)
			}
		)
	private List<Mission> missions;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service")
	private Service serviceBean;

	//bi-directional many-to-one association to Projet
	@OneToMany(mappedBy="personnel")
	private List<Projet> projets;

	public Personnel() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public List<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Service getServiceBean() {
		return this.serviceBean;
	}

	public void setServiceBean(Service serviceBean) {
		this.serviceBean = serviceBean;
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Projet addProjet(Projet projet) {
		getProjets().add(projet);
		projet.setPersonnel(this);

		return projet;
	}

	public Projet removeProjet(Projet projet) {
		getProjets().remove(projet);
		projet.setPersonnel(null);

		return projet;
	}
public String toString() {
	return nom+" "+prenom;
	
	
	
	
	
	
}
}