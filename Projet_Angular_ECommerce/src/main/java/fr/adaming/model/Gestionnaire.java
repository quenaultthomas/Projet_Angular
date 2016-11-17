package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="gestionnaires")
public class Gestionnaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gestionnaire")
	private Long Id_g;
	
	@Column(name="username")
	private String login;
	private String password;
	
	private boolean actived;
	
	@OneToMany(mappedBy="gestio")
	private List<Role> roles;
	
	
	
	
	/**
	 * Constructeur vide
	 */
	public Gestionnaire() {
		super();
	}
	
	
	
	/** Constructeur avec paramètres, sans id
	 * @param login
	 * @param password
	 * @param actived
	 * @param roles
	 */
	public Gestionnaire(String login, String password, boolean actived,
			List<Role> roles) {
		super();
		this.login = login;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}
	
	

	/** Constructeur avec paramètres + ID
	 * @param id_g
	 * @param login
	 * @param password
	 * @param actived
	 * @param roles
	 */
	public Gestionnaire(Long id_g, String login, String password,
			boolean actived, List<Role> roles) {
		super();
		Id_g = id_g;
		this.login = login;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}



	/** Getters & setters*/
	
	


	public Long getId_g() {
		return Id_g;
	}


	public void setId_g(Long id_g) {
		Id_g = id_g;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	/**
	 * @return the actived
	 */
	public boolean isActived() {
		return actived;
	}



	/**
	 * @param actived the actived to set
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}



	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}



	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	/** toString*/
	@Override
	public String toString() {
		return "Gestionnaire [Id_g=" + Id_g + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	
	
	

}
