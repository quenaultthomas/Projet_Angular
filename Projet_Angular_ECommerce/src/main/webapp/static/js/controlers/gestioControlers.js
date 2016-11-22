monApp
		/** get category by id : pas utilisée car on utilise la recherche avec des filtres*/
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
		
		
/** Liste category : page d'accueil du gestionnaire*/
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
					
/** suppression de la categorie dans la table des category*/
					$scope.delCat = function(category) {
								gestioFactory.gestioDelCat(category.id_c,function(callback) {
								
								gestioFactory.gestioGetAllCat(function(callback) {
									$scope.allCategory = callback;

								});
							});
					}

/** Modification d'une categorie à partir de la table --> renvoie sur la page formulaire*/					
					$scope.editCat=function(category){
						$rootScope.categoryForm.id_c = category.id_c;
						$rootScope.categoryForm.nom = category.nom;
						$rootScope.categoryForm.description = category.description;
						$location.path("/gestioEditCat");
						
					}
				})

				
				   
/** Ajout d'une category : il faut passer par la barre de menu --> envoie sur le formulaire d'ajout*/
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

				/** get product by id : pas utilisée car on recherche à l'aide de filtres*/
				.controller('gestioGetProdByIdCtrl', function($scope, gestioFactory) {

			$scope.id_p = undefined;

			$scope.doGetProdById = function() {
				gestioFactory.getById($scope.id_p, function(callback) {

					if (callback != undefined && callback != "") {
						$scope.category = callback;
						$scope.indice = true;
					}
				});
			}
		})
		
		
/** liste des produits */
		.controller(
				'gestioGetAllProdCtrl',
				function($rootScope, $scope, gestioFactory, $location) {

					gestioFactory.gestioGetAllProd(function(callback) {
						$scope.allProduct = callback;

					});
					
					$rootScope.productForm={
						id_p : -1,
						nom : "",
						description : "",
						prix : "",
						quantite : "",
							categorie : {
								id_c : "",
								nom : "",	
							}
					}
					
					/** suppression du produit dans la table des produits*/
					$scope.delProd = function(product) {
								gestioFactory.gestioDelProd(product.id_p,function(callback) {
								
								gestioFactory.gestioGetAllProd(function(callback) {
									$scope.allProduct = callback;

								});
							});
					}

					/** Modification d'un produit à partir de la table produit --> renvoie sur la page formulaire d'edition*/				
					$scope.editProd=function(product){
						$rootScope.productForm.id_p = product.id_p;
						$rootScope.productForm.nom = product.nom;
						$rootScope.productForm.description = product.description;
						$rootScope.productForm.prix = product.prix;
						$rootScope.productForm.quantite = product.quantite;
						$rootScope.productForm.categorie.id_c = product.categorie.id_c;
						$rootScope.productForm.categorie.nom = product.categorie.nom;
						$location.path("/gestioEditProd");
						
					}
				})

				
				   
/** Ajout d'un produit : il faut passer par la barre de menu --> envoie sur le formulaire d'ajout*/
		.controller(
				'gestioAddProdCtrl',
				function($scope, gestioFactory, $location) {

					$scope.productForm = {
						nom : "",
						description : "",
						prix : "",
						quantite : "",
							categorie : {
								id_c : "",
								nom : "",
							}
					}

					$scope.gestioAddProd = function() {
						gestioFactory.gestioAddProd($scope.productForm,
								function(callback) {
									$location.path("/gestioListeProd")

								});

					}
					gestioFactory.gestioGetAllCat(function(callback) {
						$scope.allCategory = callback;
					});

				})

		.controller(
				'gestioEditProdCtrl',
				function($rootScope, $scope, gestioFactory, $location) {
					if ($rootScope.productForm.id_c == -1) {

						$scope.productForm = {
							id_p : "",
							nom : "",
							description : "",
								prix : "",
								quantite : "",
									categorie : {
										id_c : "",
										nom : "",
									}	
						}
					} else {
						$scope.productForm.id_c = $rootScope.productForm.id_c;
						$scope.productForm.nom = $rootScope.productForm.nom;
						$scope.productForm.description = $rootScope.productForm.description;
						$scope.productForm.prix = $rootScope.productForm.prix;
						$scope.productForm.quantite = $rootScope.productForm.quantite;
						$scope.productForm.categorie.id_c = $rootScope.productForm.categorie.id_c;
						$scope.productForm.categorie.nom = $rootScope.productForm.categorie.nom;
					}
					$scope.gestioEditProd = function() {
						gestioFactory.gestioEditProd($scope.productForm,
								function(callback) {
									$location.path("/gestioListeProd")
								});
					}
					gestioFactory.gestioGetAllCat(function(callback) {
						$scope.allCategory = callback;
					});
				})

				
				
