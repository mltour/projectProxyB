package com.proxibanque.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * @author JCM Informatique
 *
 */
@Entity
public class Client implements Serializable{

	// Propriétés
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;
	private int idConseiller;
	
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
//	
//	@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
	//private List<Compte> listeCompte;
	
//	@ManyToOne
//	private Conseiller conseiller;
		
	// Constructeurs
	
	public Client() {
	
	}
	
	public Client( String nom, String prenom, String email, String adresse,
			int idConseiller) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.idConseiller = idConseiller;
	}
	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	// Getters/Setters
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
//	public List<Compte> getListeCompte() {
//		return listeCompte;
//	}
//	public void setListeCompte(List<Compte> listeCompte) {
//		this.listeCompte = listeCompte;
//	}
//	public Conseiller getConseiller() {
//		return idConseiller;
//	}
//	public void setConseiller(Conseiller conseiller) {
//		this.idConseiller = conseiller;
//	}
		
}
