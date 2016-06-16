package com.proxibanque.service;


import com.proxibanque.domaine.Conseiller;


/**
 * @author JCM
 * 
 * Service de gestion d'authentification pour la connection à l'application.
 *
 */

//@Path("/authentification")
public interface IAuthentificationService {
	
	/**
	 * Methode permettant la connection à l'application via un identifiant et un mot de passe.
	 * @param login
	 * @param mdp
	 */
	
//	@GET
//	@Path("/conseiller/login/{identifiant}/{motDePasse}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Conseiller authentification(@PathParam(value = "identifiant") String login, @PathParam(value = "motDePasse") String mdp);
	public Conseiller authentification(String login, String mdp);
}
