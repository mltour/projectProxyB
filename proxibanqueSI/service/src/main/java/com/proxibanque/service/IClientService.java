package com.proxibanque.service;

import java.util.List;

import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Compte;
import com.proxibanque.domaine.Conseiller;


public interface IClientService {
	
	public List<Client> getAllClientByConseiller(int idConseiller);
	public void editClient(Client client);
	public void addNewClient(Client client);

}
