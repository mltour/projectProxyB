package com.proxibanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Conseiller;
import com.proxibanque.service.IClientService;

@RestController
@CrossOrigin
@RequestMapping(value = "/clients")
public class ClientController {

	
	@Autowired
	private IClientService iClientService;

	public IClientService getiClientService() {
		return iClientService;
	}

	public void setiClientService(IClientService iClientService) {
		this.iClientService = iClientService;
	}
	
	// Methodes métiers
	@RequestMapping(value="/conseiller/id/{id}", method = RequestMethod.GET)
	public List<Client> listerClients(@PathVariable(value="id") int idConseiller){
	
		return this.iClientService.getAllClientByConseiller(idConseiller);
	}
	
	@RequestMapping(value="/edit/{client}", method = RequestMethod.POST)
	public void editerClient(@PathVariable(value="client")Client client){
		iClientService.editClient(client);
	}
	
	@RequestMapping(value="/new/{client}", method = RequestMethod.POST)
	public void ajouterNewClient(@PathVariable(value="client")Client client){
		iClientService.addNewClient(client);
	}
	
}
