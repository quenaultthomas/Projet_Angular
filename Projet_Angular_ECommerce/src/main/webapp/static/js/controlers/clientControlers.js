monApp

.controller('getAllCatCtrl',
		function($rootScope, $scope, panierProvider, clientFactory, $location) {
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

			$scope.price = panierProvider.getPrice();
			$scope.nbrArticle = panierProvider.getCount();

		})

.controller('getAllProdCtrl',
		function($rootScope, $scope, panierProvider, clientFactory, $location) {
			clientFactory.getAllProd(function(callback) {
				$scope.allProd = callback
			});

			$scope.price = panierProvider.getPrice();
			$scope.nbrArticle = panierProvider.getCount();
		})

.controller(
		'getProdByIdCat',
		function($rootScope, $scope, panierProvider, clientFactory,
				panierProvider, $location) {

			$scope.objCat.id_c = $rootScope.objCat.id_c;
			$scope.objCat.nom = $rootScope.objCat.nom;
			$scope.objCat.description = $rootScope.objCat.description;

			clientFactory.getProdByIdCat($scope.objCat.id_c,
					function(callback) {
						$scope.ProdByIdCat = callback
					});

			$scope.AjouterAuPanier = function(Prod) {
				panierProvider.addProduct(Prod.id_p, Prod.nom, Prod.prix);

				$scope.price = panierProvider.getPrice();
				$scope.nbrArticle = panierProvider.getCount();
			}

			$scope.price = panierProvider.getPrice();
			$scope.nbrArticle = panierProvider.getCount();

		})

.controller("PanierCtrl", function($scope, clientFactory, panierProvider, $location) {

	
	
	$scope.article = panierProvider.getProducts();
	$scope.price = panierProvider.getPrice();
	$scope.nbrArticle = panierProvider.getCount();

	
	$scope.addQte = function(prod) {
		panierProvider.addQte(prod.id_p);
		$scope.article = panierProvider.getProducts();
		$scope.price = panierProvider.getPrice();
		$scope.nbrArticle = panierProvider.getCount();
	}
	$scope.removeQte = function(prod) {
		panierProvider.removeQte(prod.id_p);
		$scope.article = panierProvider.getProducts();
		$scope.price = panierProvider.getPrice();
		$scope.nbrArticle = panierProvider.getCount();
	}

	$scope.remove = function(prod) {
		panierProvider.removeProduct(prod.id_p);
		$scope.price = panierProvider.getPrice();
		$scope.nbrArticle = panierProvider.getCount();

	}

	$scope.ajoutLC = function() {
			panierProvider.ajoutLC(function(callback)
					{
						$scope.article=callback;
					});
			$location.path("/ajoutClient");
	}
})

.controller('ajoutClientCtrl',
		function($rootScope, $scope, clientFactory, $location) {
	
			$scope.clientForm = {
				name : "",
				adresse : "",
				mail : "",
				telephone : ""
			}

			$rootScope.clientC = $scope.clientForm;
			
			$scope.ajouter = function() {

				//clientFactory.add($scope.clientForm, function(callback) {
					$location.path('/commande')
				//});

				

			}

		})

.controller(
		'CommandeCtrl',
		function($rootScope, $scope, clientFactory, panierProvider, $location) {
			// $scope.cl = clientFactory.getClient();
			$scope.article = panierProvider.getProducts();
			$scope.clientC = $rootScope.clientC;

			$scope.addCom = function() {
				clientFactory.ajoutCom($scope.clientC, function(callback) {
					$location.path('/commande')
				});
			}

		})
		
		.controller(
		'RechercheCommande',
		function($rootScope, $scope, clientFactory, panierProvider, $location) {
			$scope.id_client = undefined;
			$scope.indice = false

			$scope.recherche = function() {
				clientFactory.rechercheCommande($scope.id_client, function(callback) {
					if (callback != undefined && callback != "") {
						$scope.ligneCommande = callback
						$scope.indice = true
					}
				});
			}

		})
