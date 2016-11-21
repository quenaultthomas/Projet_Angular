monApp.factory("panierProvider", function(clientFactory) {

	var article = [];
	var nbrArticle = 0;
	var price = 0;

	return {

		addProduct : function(id_p, nom, prix) {

			var ProduitExist = false;

			for (var i = 0; i < article.length; i++) {

				if (article[i].id_p == id_p) {
					article[i].qte++;
					ProduitExist = true;
					break;
				}
			}

			if (!ProduitExist) {
				article.push({
					qte : 1,
					id_p : id_p,
					prix : prix,
					nom : nom

				});
			}
		},

		addQte : function(id_p) {

			for (var i = 0; i < article.length; i++) {

				if (article[i].id_p == id_p) {
					article[i].qte++;
					break;
				}
			}
		},
		removeQte : function(id_p) {

			for (var i = 0; i < article.length; i++) {

				if (article[i].id_p == id_p) {
					if(article[i].qte>1)
					article[i].qte--;
					break;
				}
				}
		},

		removeProduct : function(id_p) {

			for (var i = 0; i < article.length; i++) {
				if (article[i].id_p == id_p) {
					article.splice(i, 1);
					break;
				}
			}
		},

		getProducts : function() {
			return article;
		},
		
		
		getCount : function() {
			var nbrArticle = 0;
			for (var i = 0; i < article.length; i++) {
				nbrArticle += article[i].qte;
			}
			return nbrArticle;
		},
		
		getPrice : function() {
			var price = 0;
			for (var i = 0; i < article.length; i++) {
				price +=  (article[i].prix * article[i].qte);
			}
			return price;
		},
		
		ajoutLC : function(callback) {
			for (var i = 0; i < article.length; i++) {
			clientFactory.ajoutLC(article[i].id_p, article[i].qte, callback)
			}
		}		
	}
})