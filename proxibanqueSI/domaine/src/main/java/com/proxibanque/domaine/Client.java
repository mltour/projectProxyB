package com.proxibanque.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * @author JCM Informatique
 *
 */
@Entity
public class Client {

	// Propriétés
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
	private List<Compte> listeCompte;
	
	@ManyToOne
	private Conseiller conseiller;
		
	// Constructeurs
	
	public Client() {
		super();
	}
	
	public Client( String nom, String prenom, String email, String adresse,
			Conseiller conseiller) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	
		this.conseiller = conseiller;
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
	public List<Compte> getListeCompte() {
		return listeCompte;
	}
	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
		
}
