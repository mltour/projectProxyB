package com.proxibanque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxibanque.dao.IDaoClient;
import com.proxibanque.dao.IDaoConseiller;
import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Compte;
import com.proxibanque.domaine.Conseiller;

@Service("iClientService")
public class ClientService implements IClientService {

	@Autowired
	IDaoClient iDaoClient;

	// getter et setter
	public IDaoClient getiDaoClient() {
		return iDaoClient;
	}

	public void setiDaoClient(IDaoClient iDaoClient) {
		this.iDaoClient = iDaoClient;
	}

	// Methodes métiers
	@Override
	public List<Client> getAllClientByConseiller(int idConseiller) {

		List<Client> clients;
//		Conseiller conseiller=new Conseiller();
//		conseiller.setIdConseiller(idConseiller);
		clients = iDaoClient.findByIdConseiller(idConseiller);

		return clients;
	}

	@Override
	public void editClient(Client client) {
		iDaoClient.saveAndFlush(client);

	}

	@Override
	public void addNewClient(Client client) {
		iDaoClient.save(client);

	}

}
