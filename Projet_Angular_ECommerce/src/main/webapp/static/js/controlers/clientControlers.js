monApp

.controller('getAllCatCtrl', function($rootScope,$scope, clientFactory,$location) {
	clientFactory.getAllCat(function(callback) {
		$scope.allCat = callback
	});
	

})

.controller('getAllProdCtrl', function($rootScope,$scope, clientFactory,$location) {
	clientFactory.getAllProd(function(callback) {
		$scope.allProd = callback
	});
	
})