package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneDeCommande;
import fr.adaming.model.Product;
import fr.adaming.service.IClientService;
import fr.adaming.service.IGestionnaireService;

@RestController /** Controller rest de Spring MVC*/
@RequestMapping(value="/gestio") /** Pour ne pas avoir de confusion avec le client controller*/
public class GestioRestController {
	
	/** On déclare un gestionnaire service pour utiliser ces méthodes*/
	@Autowired
	private IGestionnaireService gestioService;
	
	@Autowired
	IClientService clientService;

	/** Setter du gestioService
	 * @param gestioService the gestioService to set
	 */
	public void setGestioService(IGestionnaireService gestioService) {
		this.gestioService = gestioService;
	}
	
	/** Retourne la liste des produits*/
	@RequestMapping(value="/allProd", method=RequestMethod.GET, produces="application/json")
	public List<Product> getAllProduct(){
		return gestioService.getAllProductsService();
	}

	
	/** Retourne la liste des categories*/
	@RequestMapping(value="/allCat", method=RequestMethod.GET, produces="application/json")
	public List<Category> getAllCategory(){
		return gestioService.getAllCategoriesService();
	}
	
	
	/** Retourne un produit par son id*/
	@RequestMapping(value="/prod/{id}", method=RequestMethod.GET,produces="application/json")
	public Product getProd(@PathVariable("id") int pId){
		
		return gestioService.getProductByIdService(pId);
	}
	
	
	/** Retourne une categorie par son id*/
	@RequestMapping(value="/cat/{id}", method=RequestMethod.GET,produces="application/json")
	public Category getCat(@PathVariable("id") int cId){
		
		return gestioService.getCategoryByIdService(cId);
	}
	
	
	/** Ajouter un produit*/
	@RequestMapping(value="/addProd", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Product addProd(@RequestBody Product p ){
		
		return gestioService.addProductService(p);
		
	}
	
	
	/** Ajouter une categorie*/
	@RequestMapping(value="/addCat", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Category addCat(@RequestBody Category c ){
		
		return gestioService.addCategoryService(c);
		
	}
	
	/** Modifier un produit*/
	@RequestMapping(value="/upProd", method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public Product upProd(@RequestBody Product p ){
		
		return gestioService.upProduitService(p);
		
	}
	
	/** Modifier une categorie*/
	@RequestMapping(value="/upCat", method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public Category upCat(@RequestBody Category c ){
		
		return gestioService.upCategoryService(c);
		
	}
	
	/** Supprimer un produit*/
	@RequestMapping(value="/delProd/{id}", method=RequestMethod.DELETE,produces="application/json")
	public void delProd(@PathVariable("id")int id){
		
		gestioService.delProduitService(id);
		
	}
	
	/** Supprimer une categorie*/
	@RequestMapping(value="/delCat/{id}", method=RequestMethod.DELETE,produces="application/json")
	public void delCat(@PathVariable("id")int id){
		
		gestioService.delCategoryService(id);
		
	}
	
	@RequestMapping(value = "/AllCom", method = RequestMethod.GET, produces = "application/json")
	public List<Commande>  getCom() {
		 return clientService.SearchCommand();
	}
	
	@RequestMapping(value = "/LigneComByIdCom/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<LigneDeCommande>  getLCbyIdCom(@PathVariable("id") int id) {
		 
		 return clientService.SearchLigneCommandeByIdCommande(id);
	}
	

}
