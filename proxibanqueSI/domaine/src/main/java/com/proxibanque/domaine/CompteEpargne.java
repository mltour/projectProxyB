package com.proxibanque.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author JCM Informatique
 *
 */
@Entity
@DiscriminatorValue("COMPTEEPARGNE")
public class CompteEpargne extends Compte {
	
	// Propriété
	
	private double tauxRemuneration = 2/100;

	// Constructeurs
	
	public CompteEpargne() {
		super();
	}
	
	public CompteEpargne(double tauxRemuneration) {
		super();
		this.tauxRemuneration = tauxRemuneration;
	}
public CompteEpargne(String numero, int solde, String typeCompte, int idClient, double tauxRemuneration) {
		super(numero, solde, typeCompte, idClient);
		this.tauxRemuneration = tauxRemuneration;
	}
	// Getters/Setters
	
	
	

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	
}
