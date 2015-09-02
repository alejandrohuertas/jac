package jac.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@ManagedBean
@Entity
@Table(name = "Users")
public class Login {

	@Id
	@Column(name = "uid")
	private Integer id; 
	
	@Column(name ="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public Login(){	
	}
	
	public Login(String username) {
		this.username = username;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

//	public String login() {
//		if (username.equals("madhav") && password.equals("password")) {
//			return "success";
//		} else
//			return "failure";
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}