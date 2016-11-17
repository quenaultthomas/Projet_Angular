package fr.adaming.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneDeCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Product;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	@Autowired
	private SessionFactory sf;
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	/**
	 * methode permettant la recherche de tous les produits 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByAllProduits() {
		Session s = sf.getCurrentSession();
		
		Query reqAllProduit = s.createQuery("SELECT p FROM Product p");
		return reqAllProduit.list();
	}

	/**
	 * methode permettant la recherche des produits par mots clés
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByKeyWord(String keyWord) {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT p FROM Product p WHERE p.nom like:kw or p.description like:kw");
		req.setParameter("kw", "%" + keyWord + "%");
		return req.list();
	}

	/**
	 * methode permettant la recherche des produits en fonction de la catégories sélectionnées
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByIdCategorie(int  id_cat) {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT p FROM Product p WHERE p.categorie.id_c=:id");
		req.setParameter("id", id_cat);
		
		return req.list();
		
	}

	/**
	 * 
	 */
	@Override
	public List<Product> SearchByProduitSelectionne() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * afficher la liste des catégories .
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> GetAllCategorie() {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("select c from Category c");
		return req.list();
	}

	/**
	 * methode permettant l'ajout du client
	 */
	@Override
	public Client addClient(Client cl) {
		Session s = sf.getCurrentSession();
		
		s.persist(cl);
		return cl;
		
	}

	/**
	 * recherche du produit par son id
	 */
	@Override
	public Product SearchByIdProduct(int id_prod) {
		Session s = sf.getCurrentSession();
		
		return (Product) s.get(Product.class, id_prod);
				
	}

	/**
	 * methode permettant la validation de la commande
	 */
	@Override
	public Commande passerCommande(Panier panier, Client client) {
		
			Session s = sf.getCurrentSession();
			
			s.save(client);
			
			Commande commande = new Commande();
			
			Calendar c = Calendar.getInstance ();
			
			commande.setDateDeCommande(c.getTime());
			commande.setClient(client);
			commande.setLigneCommandes(panier.getArticle());
			s.persist(commande);
			
			
			return commande;
	}

	/**
	 * methode permettant la recherche de la commande concernant un client
	 */
	@Override
	public Commande SearchCommandByIdClient(int id_client) {
        Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT c FROM Commande c WHERE c.client.id_client=:id");
		req.setParameter("id", id_client);
		
		Commande com = (Commande) req.uniqueResult();
		
		return com;
	}

	/**
	 * methode permettant la recherche des lignes de commandes 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LigneDeCommande> SearchLigneCommandeByIdCommande(int id_commande) {
		 Session s = sf.getCurrentSession();
			
			Query req = s.createQuery("SELECT l FROM LigneDeCommande l WHERE idCommande=:id");
			req.setParameter("id", id_commande);
			
			List<LigneDeCommande> liste = req.list();
			
			return liste;
	}


		
}

