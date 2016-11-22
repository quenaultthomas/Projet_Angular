monApp

.factory('clientFactory', function($http) {

	var urlWS = "http://localhost:8080/Projet_Angular_ECommerce/client/";
//	var client = {
//			name : "",
//			adresse : "",
//			mail : "",
//			telephone : ""
//	}
	
	function getAllCat(callback) {

		$http({
			method : 'GET',
			url : urlWS+"allCat",
			
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	function getAllProd(callback) {

		$http({
			method : 'GET',
			url : urlWS+"allProd",
			
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function getProdByIdCat(id_Cat, callback) {

		$http({
			method : 'GET',
			url : urlWS+"prodByIdCat/"+id_Cat
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function add(clientForm, callback) {

		$http({
			method : 'POST',
			url : urlWS+"addClient",
			data : angular.toJson(clientForm),
			headers : {'Content-Type':'application/json'}
			
			
		}).success(function(response) {
			console.log(response)
			callback(response)
			
//			client=({
//				name : clientForm.name,
//				adresse : clientForm.adresse,
//				mail : clientForm.mail,
//				telephone : clientForm.telephone
//			});
			
		}).error(function(response) {
			console.log(response)
		});
	}
	
//	function getClient(){
//		client
//	}
	
//	function Paiement(article, clientC, callback) {
//
//		$http({
//			method : 'POST',
//			url : urlWS+"addCommande",
//			data : angular.toJson(article,clientC),
//			headers : {'Content-Type':'application/json'}
//			
//			
//		}).success(function(response) {
//			console.log(response)
//			callback(response)
//			
//		}).error(function(response) {
//			console.log(response)
//		});
//	}
	
	function ajoutLC(id,qte, callback) {

		$http({
			method : 'GET',
			url : urlWS+"addLC/"+id+"/"+qte,
			
			
		}).success(function(response) {
			console.log(response)
			callback(response)
			
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function ajoutCom(client, callback) {

		$http({
			method : 'POST',
			url : urlWS+"addCom",
			data : angular.toJson(client),
			headers : {'Content-Type':'application/json'}
			
		}).success(function(response) {
			console.log(response)
			callback(response)
			
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function rechercheCommande(id_client, callback) {

		$http({
			method : 'GET',
			url : urlWS+"ComByIdClient/"+id_client
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function rechercheClient(id_client, callback) {

		$http({
			method : 'GET',
			url : urlWS+"ClientByIdClient/"+id_client
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function rechercheClientByCom(id, callback) {

		$http({
			method : 'GET',
			url : urlWS+"ClientByIdCom/"+id
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	return {
		getAllCat : getAllCat,
		getAllProd : getAllProd,
		getProdByIdCat:getProdByIdCat,
		add : add,
		//getClient : getClient,
//		Paiement : Paiement,
		ajoutLC:ajoutLC,
		ajoutCom:ajoutCom,
		rechercheCommande:rechercheCommande,
		rechercheClient:rechercheClient,
		rechercheClientByCom:rechercheClientByCom,
	}
});