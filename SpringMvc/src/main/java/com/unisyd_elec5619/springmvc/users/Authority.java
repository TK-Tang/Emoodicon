package com.unisyd_elec5619.springmvc.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authority")
public class Authority {
	
	public Authority (String username, String authority){
		this.username = username;
		this.authority = authority;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorityID")
	private int authorityID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="authority")
	private String authority;

	public int getAuthorityID() {
		return authorityID;
	}

	public String getUsername() {
		return username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthorityID(int authorityID) {
		this.authorityID = authorityID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
