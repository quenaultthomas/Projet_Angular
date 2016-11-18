myApp.config(function($routeProvider) {
	$routeProvider

	.when('/gestioListeCat', {
		templateUrl : "partials/gestioGetAllCat.html",
		controller : "gestioGetAllCtrl"
	}).when('/getById', {
		templateUrl : "partials/gestioGetCatById.html",
		controller : "gestioGetByIdCtrl"
	})

	.when('/gestioAddCat', {
		templateUrl : "partials/gestioAddCat.html",
		controller : "gestioAddCtrl"
	})

	.when('/gestioEditCat', {
		templateUrl : "partials/gestioEditCat.html",
		controller : "gestioEditCtrl"
	})

	.when('/delete', {
		templateUrl : "partials/gestioDelCat.html",
		controller : "gestioDelCatCtrl"
	})

	.otherwise({
		redirectTo : '/gestioListeCat'
	})

})