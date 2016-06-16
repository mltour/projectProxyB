package com.proxibanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proxibanque.domaine.Conseiller;
import com.proxibanque.service.IAgenceService;

@RestController
@CrossOrigin
@RequestMapping(value = "/agence")
public class AgenceController {

	@Autowired
	private IAgenceService iAgenceService;

	public IAgenceService getiAgenceService() {
		return iAgenceService;
	}

	public void setiAgenceService(IAgenceService iAgenceService) {
		this.iAgenceService = iAgenceService;
	}
	
	// Methodes métiers
	
	@RequestMapping(value="/conseillers", method = RequestMethod.GET)
	public List<Conseiller> listerConseillers(){
		return this.iAgenceService.getAllConseiller();
	}
}
