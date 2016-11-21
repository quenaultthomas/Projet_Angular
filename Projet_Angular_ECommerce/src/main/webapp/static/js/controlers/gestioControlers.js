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
		
		

		.controller(
				'gestioGetAllCatCtrl',
				function($rootScope, $scope, gestioFactory, $location) {

					gestioFactory.gestioGetAllCat(function(callback) {
						$scope.allCategory = callback;

					});
					
					$rootScope.categoryForm={
						id : -1,
						nom : "",
						description : ""
					}
					

					$scope.delCat = function(category) {
								gestioFactory.gestioDelCat(category.id_c,function(callback) {
								
								gestioFactory.gestioGetAllCat(function(callback) {
									$scope.allCategory = callback;

								});
							});

					
					$scope.editCat=function(category){
						$rootScope.categoryForm.id_c = category.id_c;
						$rootScope.categoryForm.nom = category.nom;
						$rootScope.categoryForm.description = category.description;
						$location.path("/gestioEditCat")
						
					}}
				})

				
				   

		.controller(
				'gestioAddCatCtrl',
				function($scope, gestioFactory, $location) {

					$scope.categoryForm = {
						nom : "",
						description : ""
					}

					$scope.gestioAddCat = function() {
						gestioFactory.gestioAddCat($scope.categoryForm,
								function(callback) {
									$location.path("/gestioListeCat")

								});

					}
				})

		.controller(
				'gestioEditCatCtrl',
				function($rootScope, $scope, gestioFactory, $location) {
					if ($rootScope.categoryForm.id_c == -1) {

						$scope.categoryForm = {
							id_c : "",
							nom : "",
							description : ""
						}
					} else {
						$scope.categoryForm.id_c = $rootScope.categoryForm.id_c;
						$scope.categoryForm.nom = $rootScope.categoryForm.nom;
						$scope.categoryForm.description = $rootScope.categoryForm.description;
					}
					$scope.gestioEditCat = function() {
						gestioFactory.gestioEditCat($scope.categoryForm,
								function(callback) {
									$location.path("/gestioListeCat")
								});
					}
				})

		.controller('gestioDelCatCtrl',
				function($scope, gestioFactory, $location) {
					$scope.id_c = undefined;

					$scope.gestioDelCat = function() {
						paysFactory.deleteCat($scope.id_c, function(callback) {
							$location.path("/gestioListeCat")
						});
					}
				})
