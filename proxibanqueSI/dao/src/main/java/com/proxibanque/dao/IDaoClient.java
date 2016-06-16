package com.proxibanque.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Conseiller;
/**
 * @author JCM informatique
 * interface permettant la connexion avec la base de données 
 * SpringData
 */
@Repository("iDaoClient")
public interface IDaoClient extends JpaRepository<Client, Integer> {

	public List<Client> findByIdConseiller(int idConseiller);
	public List<Client> findAll();
	
}
