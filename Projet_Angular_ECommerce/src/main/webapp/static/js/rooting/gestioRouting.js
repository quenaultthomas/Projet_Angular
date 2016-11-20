monApp.config(function($routeProvider) {
	$routeProvider

	.when('/gestioListeCat', {
		templateUrl : "partials/gestioGetAllCat.html",
		controller : "gestioGetAllCatCtrl"
			
	}).when('/gestioGetCatById', {
		templateUrl : "partials/gestioGetCatById.html",
		controller : "gestioGetCatByIdCtrl"
	})

	.when('/gestioAddCat', {
		templateUrl : "partials/gestioAddCat.html",
		controller : "gestioAddCatCtrl"
	})

	.when('/gestioEditCat', {
		templateUrl : "partials/gestioEditCat.html",
		controller : "gestioEditCatCtrl"
	})

	.when('/gestioDelCat', {
		templateUrl : "partials/gestioDelCat.html",
		controller : "gestioDelCatCtrl"
	})

	.otherwise({
		redirectTo : '/gestioListeCat'
	})

})