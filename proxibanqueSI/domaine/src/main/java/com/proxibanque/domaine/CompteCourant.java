package com.proxibanque.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author JCM Informatique
 *
 */
@Entity
@DiscriminatorValue("COMPTECOURANT")
public class CompteCourant extends Compte {
	
	// Propriété
	
	private int decouvertAutorise = 250;

	// Constructeurs
	
	public CompteCourant() {
		super();
	}
	
	public CompteCourant(int decouvertAutorise) {
		super();
		this.decouvertAutorise = decouvertAutorise;
	}
	
	public CompteCourant(String numero, int solde, String typeCompte, Client client, int decouvertAutorise) {
		super(numero, solde, typeCompte, client);
		this.decouvertAutorise = decouvertAutorise;
	}
	// Getters/Setters
	
	

	

	public int getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(int decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
}
