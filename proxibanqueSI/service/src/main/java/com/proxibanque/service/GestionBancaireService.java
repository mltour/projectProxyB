package com.proxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxibanque.dao.IDaoCompte;
import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Compte;

@Service("iGestionBancaireService")
public class GestionBancaireService implements IGestionBancaireService {

	@Autowired
	IDaoCompte iDaoCompte;

	// getter et setter
	public IDaoCompte getiDaoCompte() {
		return iDaoCompte;
	}

	public void setiDaoCompte(IDaoCompte iDaoCompte) {
		this.iDaoCompte = iDaoCompte;
	}

	// Methodes métiers
	@Override
	public List<Compte> getCompteByClient(int idClient) {
		List<Compte> comptes;
//		Client client = new Client();
//		client.setIdClient(idClient);
		comptes = iDaoCompte.findByIdClient(idClient);
		return comptes;
	}

	@Override
	public void virer(int idCompteDebit, int idCompteCredit, double somme) {
		crediter(idCompteCredit, somme);
		debiter(idCompteDebit, somme);

	}

	private void crediter(int idCompteCredit, double somme) {
		Compte compte;
		compte = iDaoCompte.findByidCompteBancaire(idCompteCredit);

		// Calcul et mise à jour du nouveau solde
		compte.setSolde(compte.getSolde() + somme);

		// Mise a jour dans la base de données
		iDaoCompte.saveAndFlush(compte);

	}

	private void debiter(int idCompteDebit, double somme) {
		Compte compte = iDaoCompte.findByidCompteBancaire(idCompteDebit);

		// Calcul et mise à jour du nouveau solde
		compte.setSolde(compte.getSolde() - somme);

		// Mise a jour dans la base de données
		iDaoCompte.saveAndFlush(compte);

	}

}
