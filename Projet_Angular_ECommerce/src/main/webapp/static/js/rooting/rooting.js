monApp.config(function($routeProvider) {

	$routeProvider

	.when('/liste', {
		templateUrl : "partials/getAll.html",
		controller : "getAllCtrl"
	})

	.when('/getById', {
		templateUrl : "partials/getById.html",
		controller : "getByIdCtrl"
	})

	.when('/add', {
		templateUrl : "partials/add.html",
		controller : "addCtrl"
	})

	.when('/up', {
		templateUrl : "partials/up.html",
		controller : "upCtrl"
	})

	.when('/update', {
		templateUrl : "partials/update.html",
		controller : "updateCtrl"
	})

	.when('/del', {
		templateUrl : "partials/del.html",
		controller : "delCtrl"
	})

	.otherwise({
		redirectTo : '/liste'
	})
})