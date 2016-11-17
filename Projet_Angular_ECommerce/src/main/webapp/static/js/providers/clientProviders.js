monApp

.factory('clientFactory', function($http) {

	var urlWS = "http://localhost:8080/Projet_Angular_ECommerce/client/";

	
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
	
	
	
	return {
		getAllCat : getAllCat,
		getAllProd : getAllProd,
		
	}
});