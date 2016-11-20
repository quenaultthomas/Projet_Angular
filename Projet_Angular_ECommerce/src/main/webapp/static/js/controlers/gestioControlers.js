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
				function($scope, gestioFactory) {

					gestioFactory.gestioGetAllCat(function(callback) {
						$scope.allCategory = callback;

					});
					
					$scope.categoryForm={
							nom : "",
							description : ""
					}
					
					

					$scope.delCat = function(category) {
						$scope.selectedAll = false;
						angular.forEach($scope.allCategory, function(selected) {
							if (!selected.selected) {
								gestioFactory.gestioDelCat(selected,category.id_c, function(
										callback) {
								})
							}
							;

						});

						gestioFactory.gestioGetAllCat(function(callback) {
							$scope.allCategory = callback;

						});
					}
					

					$scope.addCat = function() {
						gestioFactory.gestioAddCat($scope.categoryForm,
								function(callback) {
									$scope.category = {}
								});
						gestioFactory.gestioGetAllCat(function(callback) {
							$scope.allCategory = callback;

						});

					}
					
					
					
					$scope.editCat=function(){
						gestioFactory.gestioEditCat($scope.categoryForm, function (callback){
						});
						gestioFactory.gestioGetAllCat(function(callback) {
							$scope.allCategory = callback;
						});
					}

					$scope.checkAll = function() {
						if (!$scope.selectedAll) {
							$scope.selectedAll = true;
						} else {
							$scope.selectedAll = false;
						}
						angular.forEach($scope.allCategory, function(
								allCategory) {
							allCategory.selected = $scope.selectedAll;
						});
					};
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
