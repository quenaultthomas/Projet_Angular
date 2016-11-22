package fr.adaming.restController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import fr.adaming.model.Panier;
import fr.adaming.model.Product;
import fr.adaming.service.IClientService;
import fr.adaming.service.IGestionnaireService;

@RestController
@RequestMapping(value = "/client")
public class ClientRestController {

	Panier panier = new Panier();
	
	Map<Integer, LigneDeCommande> Article = new HashMap<Integer, LigneDeCommande>();

	
	
	@Autowired
	IClientService clientService;

	@Autowired
	IGestionnaireService gestioService;

	@RequestMapping(value = "/allCat", method = RequestMethod.GET, produces = "application/json")
	public List<Category> getAllCat() {
		return clientService.GetAllCategorie();
	}

	@RequestMapping(value = "/allProd", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getAllProd() {
		return clientService.SearchByAllProduits();
	}

	@RequestMapping(value = "/prodByIdCat/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getProdByIdCat(@PathVariable("id") int id) {
		return clientService.SearchByIdCategorie(id);
	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST, produces = "application/json")
	public Client addClient(@RequestBody Client client) {

		return clientService.addClient(client);
	}

	@RequestMapping(value = "/upClient", method = RequestMethod.PUT, produces = "application/json")
	public Client upClient(@RequestBody Client client) {

		return clientService.upClient(client);

	}

	@RequestMapping(value = "/addCommande", method = RequestMethod.POST, produces = "application/json")
	public Commande addCommande(@RequestBody Client client, @RequestBody Panier panier) {

		return clientService.passerCommande(panier, client);
	}

	@RequestMapping(value = "/addLC/{id}/{qte}", method = RequestMethod.GET, produces = "application/json")
	public LigneDeCommande addLC(@PathVariable("id") int id_p, @PathVariable("qte") int qte) {

		
		Product prod = clientService.SearchByIdProduct(id_p);

		if (prod.getQuantite() > qte) {

			// création de la ligne de commande
			LigneDeCommande ligneCommandeNew = new LigneDeCommande();

			ligneCommandeNew.setPrix(prod.getPrix());
			ligneCommandeNew.setQuantite(qte);
			ligneCommandeNew.setProduit(prod);

			Article.put(prod.getId_p(), ligneCommandeNew);

			panier.getLigneCommande().add(ligneCommandeNew);

			

			//////////////////////////////////////////////////////////////////////////////////////////
			int quantiteP = prod.getQuantite();
			quantiteP = quantiteP - qte;

			prod.setQuantite(quantiteP);

			gestioService.upProduitService(prod);
			//////////////////////////////////////////////////////////////////////////////////////////
			List<LigneDeCommande> listePanier = new ArrayList<LigneDeCommande>();
			
			for (LigneDeCommande lc : Article.values()) {
				listePanier.add(lc);
			}
		
			panier.setLigneCommande(listePanier);
			
			
			double coutPanier = 0;

			for (LigneDeCommande ligne : Article.values()) {
				coutPanier += ligne.getPrix() * ligne.getQuantite();
			}

			panier.setCoutTotal(coutPanier);
			
			
			
			
			return ligneCommandeNew;
		} else {
			return null;
		}

	}
	
	@RequestMapping(value = "/addCom", method = RequestMethod.POST, produces = "application/json")
	public Commande addCom(@RequestBody Client client) {

		Commande commande = new Commande();

		// Récupérer la date du jour
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		commande.setDateDeCommande(date);
		
	
		
		Client cl = new Client();
		
		cl.setName(client.getName());
		cl.setMail(client.getMail());
		cl.setAdresse(client.getAdresse());
		cl.setTelephone(client.getTelephone());
		
		panier.setArticle(Article);
		
		commande = clientService.passerCommande(panier, cl);
		
		for (LigneDeCommande lc : Article.values()) {
			clientService.addLc(lc);
		}
	
		Article.clear();
	
		return commande;

		
	}
	

	@RequestMapping(value = "/ComByIdClient/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<LigneDeCommande>  getComByIdClient(@PathVariable("id") int id) {
		//return clientService.SearchCommandByIdClient(id);
		
		 Commande com = clientService.SearchCommandByIdClient(id);
		 
		 Client cl =clientService.SearchClientById(id);
		 return clientService.SearchLigneCommandeByIdCommande(com.getId_commande());
	}
	
	@RequestMapping(value = "/ClientByIdClient/{id}", method = RequestMethod.GET, produces = "application/json")
	public Client  getClientByIdClient(@PathVariable("id") int id) {
		return clientService.SearchClientById(id);
	}
	
	@RequestMapping(value = "/ClientByIdCom/{id}", method = RequestMethod.GET, produces = "application/json")
	public Client  getClientByIdCom(@PathVariable("id") int id) {
		return clientService.SearchClientByIdCom(id);
	}

}
