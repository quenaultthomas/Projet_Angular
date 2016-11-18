monApp.config(function($routeProvider) {

	$routeProvider

	.when('/listeCat', {
		templateUrl : "partials/getAllCat.html",
		controller : "getAllCatCtrl"
	})
	
	.when('/listeProd', {
		templateUrl : "partials/getAllProd.html",
		controller : "getAllProdCtrl"
	})
	
	.when('/prodByIdCat', {
		templateUrl : "partials/getProdByIdCat.html",
		controller : "getProdByIdCat"
	})

	.otherwise({
		redirectTo : '/listeCat'
	})

})