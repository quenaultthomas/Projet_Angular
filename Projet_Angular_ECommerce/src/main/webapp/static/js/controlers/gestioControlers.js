monApp

.controller('gestioGetCatByIdCtrl', function($scope, gestioFactory) {

	$scope.id_c = undefined;

	$scope.doGetCatById = function() {
		gestioFactory.getById($scope.id_c, function(callback) {

			if (callback != undefined && callback != "") {
				$scope.category = callback;
				$scope.indice = true;
			}
		});
	}
})

.controller('gestioGetAllCatCtrl', function($rootScope,$location,$scope, gestioFactory) {

	gestioFactory.getAll(function(callback) {
		$scope.allCat = callback;

	});

	$scope.delCat = function(category) {
		gestioFactory.deleteCat(category.id_c, function(callback) {
			gestioFactory.getAllCat(function(callback) {
				$scope.allCat = callback;

			});
		});
	}
	$rootScope.categoryForm={
			id_c:-1,
			nom:"",
			description:"",
	}
	$scope.editCat=function(category){
		$rootScope.categoryForm.id=category.id_c;
		$rootScope.categoryForm.nom=category.nom;
		$rootScope.categoryForm.description=category.description;
		$location.path("/gestioEditCat");
	}
})

.controller('gestioAddCatCtrl', function($scope, gestioFactory, $location) {

	$scope.categoryForm = {
		nom : "",
		description : ""
	}

	$scope.ajouter = function() {
		gestioFactory.add($scope.categoryForm, function(callback) {
			$location.path("/gestioListeCat")

		});

	}
})

.controller('gestioEditCatCtrl', function($rootScope,$scope, gestioFactory, $location) {
	if($rootScope.categoryForm.id_c == -1){
		
	
	$scope.categoryForm = {
		id_c : "",
		nom : "",
		description : ""
	}}else{
	$scope.categoryForm.id_c=$rootScope.categoryForm.id_c;
	$scope.categoryForm.nom=$rootScope.categoryForm.nom;	
	$scope.categoryForm.description=$rootScope.categoryForm.description;	
	}
	$scope.modifier = function() {
		gestioFactory.editCat($scope.categoryForm, function(callback) {
			$location.path("/gestioListeCat")
		});
	}
})

.controller('gestioDelCatCtrl', function($scope, gestioFactory, $location) {
	$scope.id_c = undefined;

	$scope.delCat = function() {
		paysFactory.deleteCat($scope.id_c, function(callback) {
			$location.path("/gestioListeCat")
		});
	}
})
