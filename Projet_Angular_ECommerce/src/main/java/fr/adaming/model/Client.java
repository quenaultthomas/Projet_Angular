package fr.adaming.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_client;
	
	@Column
	private String name;
	@Column
	private String adresse;
	@Column
	private String mail;
	@Column
	private String telephone;
	
	
	@OneToMany(mappedBy = "client")
	private Collection<Commande> commandes;
	
	
	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param name
	 * @param adresse
	 * @param mail
	 * @param telephone
	 */
	public Client(String name, String adresse, String mail, String telephone) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
	}

	/**
	 * @param id_client
	 * @param name
	 * @param adresse
	 * @param mail
	 * @param telephone
	 */
	public Client(int id_client, String name, String adresse, String mail, String telephone) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
	}

	/**
	 * @return the id_client
	 */
	public int getId_client() {
		return id_client;
	}

	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", name=" + name + ", adresse=" + adresse + ", mail=" + mail
				+ ", telephone=" + telephone + "]";
	}
	
	
	

}
