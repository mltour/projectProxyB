package com.proxibanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proxibanque.domaine.Client;
import com.proxibanque.domaine.Compte;
/**
 * @author Jonathan
 * Interface
 *
 */
@Repository("iDaoCompte")
public interface IDaoCompte extends JpaRepository<Compte, Integer> {

	public List<Compte> findByIdClient(int idClient);
	public Compte findBytypeCompte(String typeCompte);
	public Compte findByidCompteBancaire(int idCompteBancaire);
}
