package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneDeCommandes")
public class LigneDeCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_LigneDeCommande;
	@Column
	private int quantité;
	@Column
	private int prix;

	@ManyToOne
	@JoinColumn(name = "id_produit")
	private Product produit;
	
	@ManyToOne
	@JoinColumn(name="idComande")
	private Commande commande;
	/**
	 * 
	 */
	public LigneDeCommande() {
		
	}

	/**
	 * @param quantité
	 * @param prix
	 */
	public LigneDeCommande(int quantité, int prix) {
		super();
		this.quantité = quantité;
		this.prix = prix;
	}

	/**
	 * @param id_LigneDeCommande
	 * @param quantité
	 * @param prix
	 */
	public LigneDeCommande(int id_LigneDeCommande, int quantité, int prix) {
		super();
		this.id_LigneDeCommande = id_LigneDeCommande;
		this.quantité = quantité;
		this.prix = prix;
	}

	/**
	 * @return the id_LigneDeCommande
	 */
	public int getId_LigneDeCommande() {
		return id_LigneDeCommande;
	}

	/**
	 * @param id_LigneDeCommande
	 *            the id_LigneDeCommande to set
	 */
	public void setId_LigneDeCommande(int id_LigneDeCommande) {
		this.id_LigneDeCommande = id_LigneDeCommande;
	}

	/**
	 * @return the quantité
	 */
	public int getQuantité() {
		return quantité;
	}

	/**
	 * @param quantité
	 *            the quantité to set
	 */
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the produit
	 */
	public Product getProduit() {
		return produit;
	}

	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Product produit) {
		this.produit = produit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LigneDeCommande [id_LigneDeCommande=" + id_LigneDeCommande + ", quantité=" + quantité + ", prix=" + prix
				+ "]";
	}

}
