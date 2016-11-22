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
	
	.when('/gestioListeProd', {
		templateUrl : "partials/gestioGetAllProd.html",
		controller : "gestioGetAllProdCtrl"
			
	}).when('/gestioGetProdById', {
		templateUrl : "partials/gestioGetProdById.html",
		controller : "gestioGetProdByIdCtrl"
	})

	.when('/gestioAddProd', {
		templateUrl : "partials/gestioAddProd.html",
		controller : "gestioAddProdCtrl"
	})

	.when('/gestioEditProd', {
		templateUrl : "partials/gestioEditProd.html",
		controller : "gestioEditProdCtrl"
	})

	.when('/gestioDelProd', {
		templateUrl : "partials/gestioDelProd.html",
		controller : "gestioDelProdCtrl"
	})
	
	.when('/getAllCom', {
		templateUrl : "partials/GetAllCom.html",
		controller : "getAllCom"
	})
	
	.when('/LcByIdCom', {
		templateUrl : "partials/LcByIdCom.html",
		controller : "LcByIdCom"
	})

	.otherwise({
		redirectTo : '/gestioListeCat'
	})

})