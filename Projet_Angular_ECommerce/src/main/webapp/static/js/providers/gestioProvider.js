monApp.factory('gestioFactory',function($http){
	
	var urlWS = "http://localhost:8080/Projet_Angular_ECommerce/gestio/";
	/** Fonctions liées aux categories*/
	function gestioGetCatById(id,callback){
		$http({
			method : 'GET',
			url : urlWS+'cat/'+id
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log('Erreur: '+response.statusText);
		})
	}
		
	
	function gestioGetAllCat(callback){
		$http({
			method : 'GET',
			url : urlWS+'allCat'
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log(response);
		})
	}
		
		
		
	function gestioAddCat(categoryForm,callback){
			$http({
				method : 'POST',
				url : urlWS+'addCat',
				data: angular.toJson(categoryForm),
				headers: {'Content-Type':'application/json'}
			
			}).success(function(response){
				console.log(response);
				callback(response);
			}).error (function(response){
				console.log(response);
			
			})
	}
	
	function gestioEditCat(categoryForm,callback){
		$http({
			method : 'PUT',
			url : urlWS+'upCat',
			data: angular.toJson(categoryForm),
			headers: {'Content-Type':'application/json'}
		
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log(response);
		
		})
}
	function gestioDelCat(id,callback){
		$http({
			method : 'delete',
			url : urlWS+'delCat/'+id
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log('Erreur: '+response.statusText);
		})
	}
	
	/** Fonctions liées aux produits*/
	function gestioGetProdById(id,callback){
		$http({
			method : 'GET',
			url : urlWS+'prod/'+id
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log('Erreur: '+response.statusText);
		})
	}
		
	
	function gestioGetAllProd(callback){
		$http({
			method : 'GET',
			url : urlWS+'allProd'
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log(response);
		})
	}
		
		
		
	function gestioAddProd(productForm,callback){
			$http({
				method : 'POST',
				url : urlWS+'addProd',
				data: angular.toJson(productForm),
				headers: {'Content-Type':'application/json'}
			
			}).success(function(response){
				console.log(response);
				callback(response);
			}).error (function(response){
				console.log(response);
			
			})
	}
	
	function gestioEditProd(productForm,callback){
		$http({
			method : 'PUT',
			url : urlWS+'upProd',
			data: angular.toJson(productForm),
			headers: {'Content-Type':'application/json'}
		
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log(response);
		
		})
}
	function gestioDelProd(id,callback){
		$http({
			method : 'delete',
			url : urlWS+'delProd/'+id
		}).success(function(response){
			console.log(response);
			callback(response);
		}).error (function(response){
			console.log('Erreur: '+response.statusText);
		})
	}
	
			return{
				gestioGetCatById : gestioGetCatById,
				gestioGetAllCat : gestioGetAllCat,
				gestioAddCat : gestioAddCat,
				gestioEditCat : gestioEditCat,
				gestioDelCat : gestioDelCat,
				gestioGetProdById : gestioGetProdById,
				gestioGetAllProd : gestioGetAllProd,
				gestioAddProd : gestioAddProd,
				gestioEditProd : gestioEditProd,
				gestioDelProd : gestioDelProd,
			}
		
		})
