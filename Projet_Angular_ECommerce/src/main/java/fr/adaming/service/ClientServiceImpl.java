package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneDeCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Product;

@Service("clientServiceBean")
@Transactional
public class ClientServiceImpl implements IClientService{

	@Autowired
	IClientDao clientDao;


	@Override
	public List<Product> SearchByAllProduits() {
		return clientDao.SearchByAllProduits();
	}

	@Override
	public List<Product> SearchByKeyWord(String keyWord) {
		return clientDao.SearchByKeyWord(keyWord);
	}

	@Override
	public List<Product> SearchByIdCategorie(int  id_cat) {
		return clientDao.SearchByIdCategorie(id_cat);
	}

	@Override
	public List<Product> SearchByProduitSelectionne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> GetAllCategorie() {
		return clientDao.GetAllCategorie();
	}

	@Override
	public Client addClient(Client cl) {
		return clientDao.addClient(cl);
		
	}

	@Override
	public Product SearchByIdProduct(int id_prod) {
		return clientDao.SearchByIdProduct(id_prod);
		 
	}

	@Override
	public Commande passerCommande(Panier panier, Client client) {
		return clientDao.passerCommande(panier, client);
	}

	@Override
	public Commande SearchCommandByIdClient(int id_client) {
		return clientDao.SearchCommandByIdClient(id_client);
	}

	@Override
	public List<LigneDeCommande> SearchLigneCommandeByIdCommande(int id_commande) {
		return clientDao.SearchLigneCommandeByIdCommande(id_commande);
	}


}
