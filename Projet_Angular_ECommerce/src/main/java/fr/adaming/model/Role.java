package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String rolename;
	
	@ManyToOne
	@JoinColumn (name="gestio_id", referencedColumnName="id_gestionnaire")
	private Gestionnaire gestio;

	/**
	 * Constructeur vide
	 */
	public Role() {
		super();
	}
	
	

	/** Constructeur avec paramètres, sans ID
	 * @param rolename
	 * @param gestio
	 */
	public Role(String rolename, Gestionnaire gestio) {
		super();
		this.rolename = rolename;
		this.gestio = gestio;
	}



	/** Constructeur avec paramètres + id
	 * @param id
	 * @param rolename
	 * @param gestio
	 */
	public Role(int id, String rolename, Gestionnaire gestio) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.gestio = gestio;
	}



	/**Getters & Setters
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}



	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}



	/**
	 * @return the gestio
	 */
	public Gestionnaire getGestio() {
		return gestio;
	}



	/**
	 * @param gestio the gestio to set
	 */
	public void setGestio(Gestionnaire gestio) {
		this.gestio = gestio;
	}
	
	
	
	
	
	
	

}
