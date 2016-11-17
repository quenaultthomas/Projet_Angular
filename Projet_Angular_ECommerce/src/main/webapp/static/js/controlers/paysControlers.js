monApp

.controller('getByIdCtrl', function($rootScope,$scope, paysFactory,$location) {

	$scope.id = undefined;
	$scope.indice = false

	$scope.getById = function() {

		paysFactory.getById($scope.id, function(callback) {

			if (callback != undefined && callback != "") {
				$scope.pays = callback
				$scope.indice = true
			}
		});

	}
	
	$rootScope.upForm = {
			id : -1,
			nom : "",
			population : "",
	}
	
	$scope.modifier=function(pays){
		$rootScope.upForm.id = pays.id;
		$rootScope.upForm.nom = pays.nom;
		$rootScope.upForm.population = pays.population;
		$location.path("/update");
	}
	
	
	$scope.supprimer = function(pays) {

		paysFactory.del(pays.id, function(callback) {
			
				paysFactory.getAll(function(callback) {
					$scope.allPays = callback
					
				});
			
				$location.path("/liste");
		});

	}

})

.controller('getAllCtrl', function($rootScope,$scope, paysFactory,$location) {
		
	paysFactory.getAll(function(callback) {
		$scope.allPays = callback
	});
	
	$rootScope.upForm = {
			id : -1,
			nom : "",
			population : "",
	}
	
	$scope.modifier=function(pays){
		$rootScope.upForm.id = pays.id;
		$rootScope.upForm.nom = pays.nom;
		$rootScope.upForm.population = pays.population;
		$location.path("/update");
	}
	
	
	$scope.supprimer = function(pays) {

		paysFactory.del(pays.id, function(callback) {
			
				paysFactory.getAll(function(callback) {
					$scope.allPays = callback
					
				});
			
			
		});

	}
})

.controller('addCtrl', function($scope, paysFactory,$location) {
	$scope.paysForm={
			nom : "",
			population : ""
	}
	
	$scope.ajouter = function() {

		paysFactory.add($scope.paysForm, function(callback) {
			$location.path('/liste')
		});

	}

})

.controller('upCtrl', function($scope, paysFactory,$location) {
	$scope.id = undefined;
	$scope.indice = false
	
	$scope.upForm={
			id: "",
			nom : "",
			population : ""
	}

	$scope.getById = function() {

		paysFactory.getById($scope.id, function(callback) {

			if (callback != undefined && callback != "") {
				$scope.upForm = callback
				$scope.indice = true
			}
		});

	}
})

.controller('updateCtrl', function($rootScope,$scope, paysFactory,$location) {
		
	
				$scope.upForm.id = $rootScope.upForm.id;
				$scope.upForm.nom = $rootScope.upForm.nom;
				$scope.upForm.population = $rootScope.upForm.population;
		

		
	
	$scope.modifier = function() {

		paysFactory.up($scope.upForm, function(callback) {
			$location.path('/liste')
		});

	}

})

.controller('delCtrl', function($scope, paysFactory,$location) {
	$scope.id = undefined;
	
	$scope.supprimer = function() {

		paysFactory.del($scope.id, function(callback) {
			$location.path('/liste')
		});

	}

})