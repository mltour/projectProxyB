package com.proxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxibanque.dao.IDaoConseiller;
import com.proxibanque.domaine.Conseiller;

@Service("iAgenceService")
public class AgenceService implements IAgenceService {

	@Autowired
	IDaoConseiller iDaoConseiller;
	
	// getter et setter
	public IDaoConseiller getiDaoConseiller() {
		return iDaoConseiller;
	}

	public void setiDaoConseiller(IDaoConseiller iDaoConseiller) {
		this.iDaoConseiller = iDaoConseiller;
	}

	// Methodes métiers
	@Override
	public List<Conseiller> getAllConseiller() {
		List<Conseiller> conseillers;
		conseillers=iDaoConseiller.findAll();
		return conseillers;
	}

	
	
	@Override
	public void getAllTransactionByMonth() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllTransactionByWeek() {
		// TODO Auto-generated method stub

	}

}
