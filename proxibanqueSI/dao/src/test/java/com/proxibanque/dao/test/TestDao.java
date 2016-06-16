package com.proxibanque.dao.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.proxibanque.dao.IDaoClient;
import com.proxibanque.dao.IDaoCompte;
import com.proxibanque.dao.IDaoConseiller;
import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Compte;
import com.proxibanque.domaine.CompteCourant;
import com.proxibanque.domaine.CompteEpargne;
import com.proxibanque.domaine.Conseiller;

import junit.framework.TestCase;

public class TestDao extends TestCase{
	
	Conseiller conseiller;
	Client client;
	Compte compteCourant;
	Compte compteEpargne;
	IDaoConseiller iDaoConseiller;
	IDaoClient iDaoClient;
	IDaoCompte iDaoCompte;
	
	private ClassPathXmlApplicationContext appContext;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");
		conseiller = new Conseiller("myr","mdp","LOPEZ","Camille");
		client = new Client("TOUR","myriam","my@ixxi.fr","bordeaux",conseiller);
		compteCourant = new CompteCourant("0000001",1000,"Courant",client,-200);
		compteEpargne = new CompteEpargne("0000002",20000,"Epargne",client,2/100);
		
		iDaoConseiller = (IDaoConseiller) appContext.getBean("iDaoConseiller");
		
		//iDaoClient = (IDaoClient) appContext.getBean("iDaoClient");
		//iDaoCompte = (IDaoCompte) appContext.getBean("iDaoCompte");
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		conseiller = null;
		appContext = null;
		iDaoConseiller = null;
		
	}
	
	public void testSaveConseiller(){
		iDaoConseiller.save(conseiller);
	}
	public void testSaveClient(){
		iDaoClient.save(client);
	}
	public void testSaveCompte(){
		iDaoCompte.save(compteCourant);
		iDaoCompte.save(compteEpargne);
	}
	public void testFindByLogin(){
		Conseiller conseiller=iDaoConseiller.findByLogin("myr");
		System.out.println(conseiller.getNom()+" "+conseiller.getPrenom() );
	}
	
	
}
