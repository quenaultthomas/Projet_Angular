monApp

.factory('paysFactory', function($http) {

	var urlWS = "http://localhost:8080/09_AngularJs_WebService/";

	function getById(id, callback) {

		$http({
			method : 'GET',
			url : urlWS+"pays/"+id
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function getAll(callback) {

		$http({
			method : 'GET',
			url : urlWS+"allPays",
			
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function add(paysForm, callback) {

		$http({
			method : 'POST',
			url : urlWS+"add",
			data : angular.toJson(paysForm),
			headers : {'Content-Type':'application/json'}
			
			
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function up(upForm, callback) {

		$http({
			method : 'PUT',
			url : urlWS+"up",
			data : angular.toJson(upForm),
			headers : {'Content-Type':'application/json'}
			
			
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	function del(id, callback) {

		$http({
			method : 'DELETE',
			url : urlWS+"del/"+id,
			
		}).success(function(response) {
			console.log(response)
			callback(response)
		}).error(function(response) {
			console.log(response)
		});
	}
	
	
	return {
		getAll : getAll,
		getById : getById,
		add:add,
		up:up,
		del:del,
	}
});