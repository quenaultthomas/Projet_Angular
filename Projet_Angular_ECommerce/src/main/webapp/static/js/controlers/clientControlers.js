monApp

.controller('getAllCatCtrl',
		function($rootScope, $scope, clientFactory, $location) {
			clientFactory.getAllCat(function(callback) {
				$scope.allCat = callback
			});

			$rootScope.objCat = {
				id_c : -1,
				nom : "",
				descritpion : "",
			}

			$scope.trouver = function(Cat) {
				$rootScope.objCat.id_c = Cat.id_c;
				$rootScope.objCat.nom = Cat.nom;
				$rootScope.objCat.description = Cat.description;
				$location.path("/prodByIdCat");

				// clientFactory.getProdByIdCat(Cat.id_c,function(callback) {
				// $scope.ProdByIdCat = callback
				// });
				//		
				// $rootScope.ProdByIdCat = $scope.ProdByIdCat;
			}

		})

.controller('getAllProdCtrl',
		function($rootScope, $scope, clientFactory, $location) {
			clientFactory.getAllProd(function(callback) {
				$scope.allProd = callback
			});

		})

.controller(
		'getProdByIdCat',
		function($rootScope, $scope, clientFactory, panierProvider, $location) {

			$scope.objCat.id_c = $rootScope.objCat.id_c;
			$scope.objCat.nom = $rootScope.objCat.nom;
			$scope.objCat.description = $rootScope.objCat.description;

			clientFactory.getProdByIdCat($scope.objCat.id_c,
					function(callback) {
						$scope.ProdByIdCat = callback
					});
			
			$scope.AjouterAuPanier = function (Prod) { 
				panierProvider.addProduct(Prod.id_p, Prod.nom, Prod.prix);
			}

		})

.controller("PanierCtrl", function($scope, panierProvider) {

	$scope.article = panierProvider.getProducts();

	$scope.total = function() {
		var total = 0;
		for (var i = 0; i < $scope.article.length; i++) {
			total += ($scope.article[i].prix * $scope.article[i].qte);
		}
		return total;
	}

	$scope.addQte = function(prod){
		panierProvider.addQte(prod.id_p)
		$scope.article = panierProvider.getProducts();
	}
	$scope.removeQte = function(prod){
		panierProvider.removeQte(prod.id_p)
		$scope.article = panierProvider.getProducts();
	}
	
	$scope.remove = function(prod) {
		panierProvider.removeProduct(prod.id_p);
		
	}
});

