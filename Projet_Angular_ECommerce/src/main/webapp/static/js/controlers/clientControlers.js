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
		function($rootScope, $scope, clientFactory, $location) {

			$scope.objCat.id_c = $rootScope.objCat.id_c;
			$scope.objCat.nom = $rootScope.objCat.nom;
			$scope.objCat.description = $rootScope.objCat.description;

			clientFactory.getProdByIdCat($scope.objCat.id_c,
					function(callback) {
						$scope.ProdByIdCat = callback
					});
			
			$scope.AjouterAuPanier = function (Prod) { 
				cart.addProduct(Prod.id_p, Prod.nom, Prod.prix);
			}

		})

.controller("PanierCtrl", function($scope, PanierProvider) {

	$scope.cartData = cart.getProducts();

	$scope.total = function() {
		var total = 0;
		for (var i = 0; i < $scope.cartData.length; i++) {
			total += ($scope.cartData[i].price * $scope.cartData[i].count);
		}
		return total;
	}

	$scope.remove = function(id) {
		cart.removeProduct(id);
		
	}
});

