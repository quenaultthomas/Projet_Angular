package fr.adaming.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="commandes")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_commande;
	@Column
	private Date dateDeCommande;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "idCommande")
	private  Map<Integer, LigneDeCommande>  ligneCommandes;
	
	
	

	/**
	 * 
	 */
	public Commande() {
		super();
	}

	/**
	 * @param dateDeCommande
	 */
	public Commande(Date dateDeCommande) {
		super();
		this.dateDeCommande = dateDeCommande;
	}

	/**
	 * @param id_commande
	 * @param dateDeCommande
	 */
	public Commande(int id_commande, Date dateDeCommande) {
		super();
		this.id_commande = id_commande;
		this.dateDeCommande = dateDeCommande;
	}

	/**
	 * @return the id_commande
	 */
	public int getId_commande() {
		return id_commande;
	}

	/**
	 * @param id_commande the id_commande to set
	 */
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	/**
	 * @return the dateDeCommande
	 */
	public Date getDateDeCommande() {
		return dateDeCommande;
	}

	/**
	 * @param dateDeCommande the dateDeCommande to set
	 */
	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

//	/**
//	 * @return the ligneCommandes
//	 */
//	public Collection<LigneDeCommande> getLigneCommandes() {
//		return ligneCommandes;
//	}
//
//	/**
//	 * @param ligneCommandes the ligneCommandes to set
//	 */
//	public void setLigneCommandes(Collection<LigneDeCommande> ligneCommandes) {
//		this.ligneCommandes = ligneCommandes;
//	}
	
	/**
	 * @return the ligneCommandes
	 */
	public Map<Integer, LigneDeCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	/**
	 * @param ligneCommandes the ligneCommandes to set
	 */
	public void setLigneCommandes(Map<Integer, LigneDeCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", dateDeCommande=" + dateDeCommande + "]";
	}

	
	
	

}
