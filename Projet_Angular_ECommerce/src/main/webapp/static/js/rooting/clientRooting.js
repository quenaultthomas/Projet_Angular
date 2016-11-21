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
	
	.when('/panier', {
		templateUrl : "partials/Panier.html",
		controller : "PanierCtrl"
	})
	
	.when('/ajoutClient', {
		templateUrl : "partials/ajoutClient.html",
		controller : "ajoutClientCtrl"
	})
	
	.when('/commande', {
		templateUrl : "partials/Commande.html",
		controller : "CommandeCtrl"
	})

	.otherwise({
		redirectTo : '/listeCat'
	})

})

