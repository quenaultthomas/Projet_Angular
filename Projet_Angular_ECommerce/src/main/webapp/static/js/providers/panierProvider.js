monApp.factory("panierProvider", function() {

	var article = [];

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
					if(article[i].qte>0)
					article[i].qte--;
				}else{
					article[i].splice(i, 1);
				}
					break;
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
		}

	}
})