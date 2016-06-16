package com.proxibanque.service;

import java.util.List;

import com.proxibanque.domaine.Conseiller;

public interface IAgenceService {

	public List<Conseiller> getAllConseiller();
	public void getAllTransactionByMonth();
	public void getAllTransactionByWeek();
}
