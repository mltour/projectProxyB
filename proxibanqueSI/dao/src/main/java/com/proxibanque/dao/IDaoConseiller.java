package com.proxibanque.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.proxibanque.domaine.Conseiller;

@Repository("iDaoConseiller")
public interface IDaoConseiller extends JpaRepository<Conseiller, Integer> {

	public Conseiller findByLogin(String login);
	public List<Conseiller> findAll();

}
