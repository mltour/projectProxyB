package com.proxibanque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.proxibanque.dao.IDaoConseiller;
import com.proxibanque.domaine.Conseiller;

@Service("iGestionAuthentification")
public class AuthentificationService implements IAuthentificationService {

	
    @Autowired
	IDaoConseiller iDaoConseiller;
	
	public IDaoConseiller getiDaoConseiller() {
		return iDaoConseiller;
	}

	public void setiDaoConseiller(IDaoConseiller iDaoConseiller) {
		this.iDaoConseiller = iDaoConseiller;
	}

	public Conseiller authentification(String login, String mdp) {

		Conseiller conseiller = new Conseiller ();
		
		conseiller.setLogin(login);
		conseiller.setMdp(mdp);
				
	
		Conseiller conseillerDB;
		conseillerDB=iDaoConseiller.findByLogin(login);
		System.out.println(conseillerDB.getNom());
		
		if (conseiller.getLogin().equals(conseillerDB.getLogin()) && conseiller.getMdp().equals(conseillerDB.getMdp())) 
		{
			System.out.println(conseillerDB);	
		}
		else 
			System.out.println("echec");
		return conseillerDB;
		
		
	}

}
