package com.proxibanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan("com.proxibanque")
@EntityScan(basePackages="com.proxibanque.domaine")
public class ProxibanqueSiApplication extends SpringBootServletInitializer {
	
//	@RequestMapping("/")
//    String home() {
//        return "Objis, specialiste formation Spring!" ;
//    }
		public static void main(String[] args) {
		SpringApplication.run(ProxibanqueSiApplication.class, args);
		 
		
	
//		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String [] {"spring-service.xml", "spring-data.xml"});
//		 
//		IDaoConseiller idaoConseiller = (IDaoConseiller) appContext.getBean("iDaoConseiller");
//		AuthentificationService gestionAuthentification = (AuthentificationService) appContext.getBean("gestionAuthentification");
//		
//		Conseiller conseiller;
//		conseiller = gestionAuthentification.authentification("myr", "mdpp");
//		System.out.println(conseiller);
	}
}
