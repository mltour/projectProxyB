/** module de l'application*/
var proxiApp = angular.module('proxibanquesi',['ngRoute']);


/** création d'un service utilisant une stratégie de requête asynchrone basée sur une promesse*/
proxiApp.factory("proxibanquesi",function($http,$location){

  var service = {};
  
	/** service de récupération des données d'un conseiller par reconnaissance de son nom et son mot de passe*/
  service.login = function(identifiant, motDePasse){
		var url ="http://localhost:8080/authentification/conseiller/login/" + identifiant + "/" + motDePasse;
		var promise = $http.get(url);  
		return promise; 
	};
	
	/** service de récupération de la liste de clients d'un conseiller grâce à son identifiant (idConseiller)*/
	service.listerClients = function(idConseiller){
		var url = "http://localhost:8080/clients/conseiller/id/"+idConseiller;
		var promise = $http.get(url); 
		return promise;
	};
	
	/** service de récupération de la liste des comptes d'un client grâce à son identifiant (idClient)*/
	service.getCompteByClient = function(idClient){
		var url = "http://localhost:8080/comptes/client/id/"+idClient;
		var promise = $http.get(url); 
		return promise;
	};
	
	/** service de virement d'un compte à un autre compte grâce à leurs identifiants (idDebit, idCredit) et du montant renseignés*/
	service.virer = function(idDebit, idCredit, montant){
		var url = "http://localhost:8080/comptes/virement/debit/" + idDebit + "/credit/"+ idCredit + "/somme/" + montant;
		var promise = $http.post(url);
		return promise;
	};
	
	/** service de securité qui renvoie ver la page d'acceuil si l'utilisateur n'est pas connecté*/
	service.securite = function($routeScope,$location){	
		if ($routeScope.conseiller == null){	
			$location.path('/');
		}
		
	};
	
  return service;
});


/** utilisation des différentes méthodes du service et traitements des requêtes promises dans les controllers*/


/** controller utilisé dans le fragment 'FragmentLogin.html'*/
proxiApp.controller("LoginController",function($scope, proxibanquesi, $location, $rootScope){
	
	$scope.user = '';
	$scope.pswd = '';

	/** appel de la fonction associée au boutton du login */
	$scope.login = function(){
		
	/** utilisation de la méthode (du service gestionAuthentification') de recupération des données du conseiller et gestion des erreurs*/
	/** application de la méthode si les champs de saisie ne sont pas vides */
	if ($scope.user !== '' && $scope.pswd !== ''){
		return proxibanquesi.login($scope.user, $scope.pswd).then(function(response){
		
		
		$rootScope.conseiller = response.data;
		$location.path("/conseiller");
		document.getElementById("login.error").className="invisible";
		document.getElementById("login.missing").className="invisible";
		
			/** si le retour charge un conseiller non existant*/
			if ($rootScope.conseiller == ""){
			$location.path("/");
			document.getElementById("login.missing").className="invisible";
			document.getElementById("login.error").className="visible";
			}		
		});
	}
	
		/** gestion de l'erreur si les champs de saisie sont vides */
		else {
		$location.path("/");
		document.getElementById("login.error").className="invisible";
		document.getElementById("login.missing").className="visible";
			}		
	}		
});	


/** controller utilisé dans le fragment 'FragmentListeClient.html'*/
proxiApp.controller("ListeController", function($scope, proxibanquesi, $rootScope, $location){
	
	
	/** recupération de l'objet conseiller mis en mémoire et utilisation de son identifiant */
	$rootScope.conseiller = $scope.conseiller;
	
	var idConseiller = $rootScope.conseiller.idConseiller;
	
	$scope.listeClients = [];
 
	/** utilisation de la méthode (du service 'proxibanquesi') de recupération des clients du conseiller (par son identifiant) */
	/** et affichage + mise en mémoire de la liste */
	
	proxibanquesi.listerClients(idConseiller).then(function(response){   
		$scope.listeClients = response.data;
		$rootScope.listeClients;
	});	
});


/** controller utilisé dans le fragment 'FragmentListeComptes.html' */
proxiApp.controller("ClientController", function($scope, proxibanquesi, $rootScope, $routeParams, $location){
	
//	/** appel du service de securité */
//	proxibanquesi.securite($rootScope,$location);
	
	/** récupération des informations d'un client grâce aux paramètres injectés dans l'URL et mise en mémoire de ces paramètres */
	var idclient = $routeParams.id;
	var prenomclient = $routeParams.prenom;
	var nomclient = $routeParams.nom;
	
	$rootScope.client = {id : idclient, nom: nomclient, prenom : prenomclient};

	$scope.listeComptes = [];
	
	/** utilisation de la méthode (du service 'proxibanquesi') de recupération des comptes d'un client (par son identifiant) et affichage + mise en mémoire de la liste */
	proxibanquesi.getCompteByClient(idclient).then(function(response){   
		$scope.listeComptes = response.data;
		$rootScope.listeComptes;
	});
});


/** controller utilisé dans le fragment 'FragmentVirement.html' */
proxiApp.controller("VirementController", function($scope, proxibanquesi, $location, $rootScope){
	
	/** appel du service de securité */
	proxibanquesi.securite($rootScope,$location);
	
	/** récupération d'un client à l'aide du rootScope */
	$rootScope.client = $scope.client;
	
	/** appel de la fonction liée au boutton du virement */
	$scope.retour = function(){
		$location.path("/conseiller");
	};
	
	/** fonction d'affichage de la partie virement */
	$scope.menuState = {message : 'Effectuer un virement', show : false};
	$scope.toggleMenu = function(){
		$scope.menuState.show = !$scope.menuState.show;
		if ($scope.menuState.show){
			$scope.menuState.message = 'Annuler le virement';
		}
		else 
		{
			$scope.menuState.message = 'Effectuer un virement';
		}
	};
	
	/** récupération des saisies de la partie virement */
	$scope.compte1 = 'compte1';
	$scope.compte2 = 'compte2';
	$scope.montant = 'montant';
	
	/** appel de la fonction associée au boutton du virement */
	$scope.virement = function(){
		
		/** initialisation des messages d'erreurs pour ne pas apparaitre */
		document.getElementById("compte1.erreur").className="invisible";
		document.getElementById("compte2.erreur").className="invisible";
		document.getElementById("comptes.erreur").className="invisible";
		document.getElementById("montant.erreur").className="invisible";
		
		/** gestion des erreurs liées à la saisie d'un compte débiteur (saisie par défaut ou nulle) */
		if ($scope.compte1 == 'compte1' || $scope.compte1 == null){
			document.getElementById("compte1.erreur").className="visible";
		}
		
		/** gestion des erreurs liées à la saisie d'un compte créditeur (saisie par défaut ou nulle) */
		else if ($scope.compte2 == 'compte2' || $scope.compte2 == null){
			document.getElementById("compte2.erreur").className="visible";
		}
		
		/** gestion des erreurs liées à la saisie des deux comptes (saisies identiques) */
		else if ($scope.compte1 == $scope.compte2){
			document.getElementById("comptes.erreur").className="visible";
		}
		
		/** gestion des erreurs liées à la saisie du montant (doit être un nombre) */
		else if ($scope.montant == '' || isNaN($scope.montant)) {
			document.getElementById("montant.erreur").className="visible";
		}
		
		/** sinon utilisation de la méthode(du service 'proxibanquesi') de virement compte à compte */
		else {
			proxibanquesi.virer($scope.compte1.id, $scope.compte2.id, $scope.montant).then(function(response){
			$location.path("/virement");
			});
		}
	}
		
});


/** controller utilisé dans le fragment 'FragmentVirement.html' */	
proxiApp.controller("RetourController", function($scope, $location, proxibanquesi,$rootScope){
	
	/** appel du service de securité */
	proxibanquesi.securite($rootScope,$location);
	
	$rootScope.client = $scope.client;
	
	/** appel de la fonction liée au boutton du virement */
	$scope.retour = function(){
		$location.path("/client/" + $scope.client.id + "/" + $scope.client.prenom + "/" + $scope.client.nom);
	};
});

		
/** configuration du routage */
proxiApp.config(function($routeProvider, $httpProvider){
	$routeProvider
		.when('/',{controller:'LoginController',templateUrl:"fragments/FragmentLogin.html"})
		.when('/conseiller',{controller:'ListeController',templateUrl:"fragments/FragmentListeClients.html"})
		.when('/client/:id/:prenom/:nom',{controller:'ClientController',templateUrl:"fragments/FragmentListeComptes.html"})
		.when('/virement',{controller:'RetourController',templateUrl:"fragments/FragmentVirement.html"})
		.when('/index.html#', { redirectTo:'/'})
		.otherwise({redirectTo: '/'});
});