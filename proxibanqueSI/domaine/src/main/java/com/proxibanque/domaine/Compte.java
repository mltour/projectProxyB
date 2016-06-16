package com.proxibanque.domaine;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author JCM Informatique
 *
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="COMPTE_TYPE")
public abstract class Compte implements Serializable{
	
	// Propriétés
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompteBancaire;
	private String numero;
	private double solde;
	private String typeCompte;
	
	
//	@ManyToOne
	private int idClient;
	
	// Constructeurs
	
	public Compte() {
		super();
	}
		
	public Compte(String numero, double solde, String typeCompte, int idClient) {
		super();
		
		this.numero = numero;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.idClient = idClient;
	}

	// Getters/Setters
	
	public int getIdCompteBancaire() {
		return idCompteBancaire;
	}
	public void setIdCompteBancaire(int idCompteBancaire) {
		this.idCompteBancaire = idCompteBancaire;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}
		
}
