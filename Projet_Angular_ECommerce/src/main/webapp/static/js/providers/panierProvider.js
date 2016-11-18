monApp.factory("PanierProvider", function () {

	var cartData = [];

	return {

		AjouterAuPanier: function (id_p,nom,prix) {           

			var ProduitExist = false;          

			for (var i = 0; i < cartData.length; i++) {            

				if (cartData[i].id_p == id_p) {                  
					cartData[i].count++;                   
					ProduitExist = true;               
					break;            
				}          
			} 
			
			if (!ProduitExist) {
				cartData.push({                
					count: 1, 
					id_p: id_p, 
					prix: prix, 
					nom: nom       

	});        
	}      
},


removeProduct: function (id_p) {     

	for (var i = 0; i < cartData.length; i++) {       
		if (cartData[i].id_p == id_p) {                 
			cartData.splice(i, 1);                  
			break;             
		}          
	}       
},

getProducts: function () {       
	return cartData;      
}

}
})