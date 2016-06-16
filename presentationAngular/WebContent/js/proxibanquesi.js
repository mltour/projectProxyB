/** module de l'application*/
var proxiApp = angular.module('proxibanquesi',['ngRoute']);

/** création d'un service utilisant une stratégie de requête asynchrone*/
proxiApp.factory("proxibanquesi",function($http,$location){

	var service = {};
  
	/** service de récupération des données d'un conseiller par reconnaissance de son nom et son mot de passe*/
	service.login = function(identifiant, motDePasse){
		var url ="http://localhost:8080/authentification/conseiller/login/" + identifiant + "/" + motDePasse;
		var promise = $http.get(url);  
		return promise; 
	};
	
	/** service de récupération de la liste de clients d'un conseiller grâce à son identifiant (idConseiller)*/
	service.getClientByConseiller = function(idConseiller){
		var url = "rest/clients/conseiller/id/"+idConseiller;
		var promise = $http.get(url); 
		return promise;
	};
	
  return service;
});

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

///** appel du service de securité */
//	proxibanquesi.securite($rootScope,$location);

/** recupération de l'objet conseiller mis en mémoire et utilisation de son identifiant */
$rootScope.conseiller = $scope.conseiller;

var idconseiller = $rootScope.conseiller.id;

$scope.listeClients = [];

/** utilisation de la méthode (du service 'proxybanqueService') de recupération des clients du conseiller (par son identifiant) */
/** et affichage + mise en mémoire de la liste */

proxibanquesi.getClientByConseiller(idconseiller).then(function(response){   
	$scope.listeClients = response.data;
	$rootScope.listeClients;
});	
});

		
/** configuration du routeur */
proxiApp.config(function($routeProvider, $httpProvider){
	$routeProvider
		.when('/',{controller:'LoginController',templateUrl:"fragments/FragmentLogin.html"})
		.when('/conseiller',{controller:'ListeController',templateUrl:"fragments/FragmentListeClients.html"})
		;
});
