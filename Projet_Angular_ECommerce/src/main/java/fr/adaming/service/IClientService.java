package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneDeCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Product;

public interface IClientService {
	
public List<Product> SearchByAllProduits();
	
	public List<Product> SearchByKeyWord(String keyWord);
	
	public List<Product> SearchByIdCategorie(int  id_cat);

	public List<Product > SearchByProduitSelectionne();
	
	public List<Category> GetAllCategorie();
	
	public Client addClient(Client cl);
	
	public Client upClient(Client cl);
	
	public Product SearchByIdProduct(int id_prod);
	
	public Commande passerCommande(Panier panier, Client client);
	
	public Commande SearchCommandByIdClient(int id_client);
	
	public List<LigneDeCommande> SearchLigneCommandeByIdCommande(int id_commande);
	
	public LigneDeCommande addLc(LigneDeCommande lc);
	
	public Client SearchClientById(int id_client);
	
	public Client SearchClientByIdCom(int id);
	
	public List<Commande> SearchCommand();
	
}
