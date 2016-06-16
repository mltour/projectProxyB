package com.proxibanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.proxibanque.domaine.Compte;
import com.proxibanque.service.IGestionBancaireService;

@RestController
@CrossOrigin
@RequestMapping(value = "/comptes")
public class GestionBancaireController {

	@Autowired
	public IGestionBancaireService iGestionBancaireService;

	public IGestionBancaireService getiGestionBancaireService() {
		return iGestionBancaireService;
	}

	public void setiGestionBancaireService(IGestionBancaireService iGestionBancaireService) {
		this.iGestionBancaireService = iGestionBancaireService;
	}

	// Methodes métiers
	@RequestMapping(value = "/client/id/{id}", method = RequestMethod.GET)
	public List<Compte> listerCompteClient(@PathVariable(value = "id") int idClient) {

		return this.iGestionBancaireService.getCompteByClient(idClient);

	}

	@RequestMapping(value = "/virement/debit/{idDebit}/credit/{idCredit}/somme/{somme}", method = RequestMethod.POST)
	public void faireVirerent(@PathVariable(value = "idDebit") int idCompteDebit,
			@PathVariable(value = "idCredit") int idCompteCredit, @PathVariable(value = "somme") double somme) {
		iGestionBancaireService.virer(idCompteDebit, idCompteCredit, somme);

	}

}
