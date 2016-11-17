package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_c;
	@Column
	private String nom;
	@Column
	private String description;
	
	@OneToMany(mappedBy = "categorie", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Collection<Product> produits = new ArrayList<Product>();

	/**
	 * 
	 */
	public Category() {
		super();
	}

	/**
	 * @param nom
	 * @param description
	 */
	public Category(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	/**
	 * @param id_c
	 * @param nom
	 * @param description
	 */
	public Category(int id_c, String nom, String description) {
		super();
		this.id_c = id_c;
		this.nom = nom;
		this.description = description;
	}

	/**
	 * @return the id_c
	 */
	public int getId_c() {
		return id_c;
	}

	/**
	 * @param id_c the id_c to set
	 */
	public void setId_c(int id_c) {
		this.id_c = id_c;
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
	 * @return the produits
	 */
	public Collection<Product> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(Collection<Product> produits) {
		this.produits = produits;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [id_c=" + id_c + ", nom=" + nom + ", description=" + description + "]";
	}
	
	


}
