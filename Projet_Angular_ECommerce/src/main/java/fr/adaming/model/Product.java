package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="produits")
public class Product implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_p;
	@Column
	private String nom;
	@Column
	private String description;
	@Column
	private int quantite;
	@Column
	private int prix;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CATEGORIE")
	private Category categorie;
	
	@Transient
	private String keyWord;

	/**
	 * 
	 */
	public Product() {
		Category categorie = new Category();
	}

	/**
	 * @param nom
	 * @param description
	 * @param quantite
	 * @param prix
	 */
	public Product(String nom, String description, int quantite, int prix) {
		super();
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
	}

	/**
	 * @param id_p
	 * @param nom
	 * @param description
	 * @param quantite
	 * @param prix
	 */
	public Product(int id_p, String nom, String description, int quantite, int prix) {
		super();
		this.id_p = id_p;
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
	}

	/**
	 * @return the id_p
	 */
	public int getId_p() {
		return id_p;
	}

	/**
	 * @param id_p the id_p to set
	 */
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Category getCategorie() {
		return categorie;
	}

	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}
	
	

	/**
	 * @return the keyWord
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * @param keyWord the keyWord to set
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "Product [id_p=" + id_p + ", nom=" + nom + ", description="
				+ description + ", quantite=" + quantite + ", prix=" + prix
				 + "]";
	}

	
	

	
}
