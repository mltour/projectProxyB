package com.proxibanque.service;

import java.util.List;

import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Compte;

public interface IGestionBancaireService {

	public List<Compte> getCompteByClient(int idClient);

	public void virer(int idCompteDebit, int idCompteCredit, double somme);
}
