package com.proxibanque.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author JCM Informatique
 *
 */
@Entity
public class Conseiller implements Serializable{

	// Propriétés
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idConseiller;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	
	

//	@OneToMany(mappedBy="conseiller")
//	private Client Client;
	
	// Constructeurs
	
	public Conseiller() {
			}
	
	public Conseiller( String login, String mdp, String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		
	}

	// Getters/Setters
	
	public Conseiller(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public int getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
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
	public String getLogin() {
		return login;
	}	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
//	public List<Client> getListeClient() {
//		return listeClient;
//	}
//	public void setListeClient(List<Client> listeClient) {
//		this.listeClient = listeClient;
//	}

	@Override
	public String toString() {
		return "Conseiller [idConseiller=" + idConseiller + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login
				+ ", mdp=" + mdp  + "]";
	}
	
	
}
