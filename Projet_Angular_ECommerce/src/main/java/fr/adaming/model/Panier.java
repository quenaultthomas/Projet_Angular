package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, LigneDeCommande> Article = new HashMap<Integer, LigneDeCommande>();
	private List<LigneDeCommande> LigneCommande = new ArrayList<LigneDeCommande>();
	
	
	double coutTotal = 0;
	
	
	public Panier() {
		super();
	}


	/**
	 * @return the ligneCommande
	 */
	public List<LigneDeCommande> getLigneCommande() {
		return LigneCommande;
	}


	/**
	 * @param ligneCommande the ligneCommande to set
	 */
	public void setLigneCommande(List<LigneDeCommande> ligneCommande) {
		LigneCommande = ligneCommande;
	}


	/**
	 * @return the coutTotal
	 */
	public double getCoutTotal() {
		return coutTotal;
	}


	/**
	 * @param coutTotal the coutTotal to set
	 */
	public void setCoutTotal(double coutTotal) {
		this.coutTotal = coutTotal;
	}


	/**
	 * @return the article
	 */
	public Map<Integer, LigneDeCommande> getArticle() {
		return Article;
	}


	/**
	 * @param article the article to set
	 */
	public void setArticle(Map<Integer, LigneDeCommande> article) {
		Article = article;
	}

	
	}


