package com.proxibanque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proxibanque.domaine.Conseiller;
import com.proxibanque.service.IAuthentificationService;

@Component
@RestController
@CrossOrigin
@RequestMapping(value ="/authentification")

public class AuthentificationController {

	@Autowired
	private IAuthentificationService gestionAuthentification;

	public IAuthentificationService getiAuthentificationService() {
		return gestionAuthentification;
	}

	public void setiAuthentificationService(IAuthentificationService gestionAuthentification) {
		this.gestionAuthentification = gestionAuthentification;
	}
	@CrossOrigin
	@RequestMapping(value = "/conseiller/login/{identifiant}/{motDePasse}", method = RequestMethod.GET)
	public Conseiller getAuthentification(@PathVariable(value = "identifiant") String login, @PathVariable(value = "motDePasse") String mdp )  {
		System.out.println("oui");
		return this.gestionAuthentification.authentification(login, mdp);
	}
}
