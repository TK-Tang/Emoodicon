package com.unisyd_elec5619.springmvc.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;


@Entity
@Table(name = "Users")
public class Users implements Serializable{
	
	public Users(){
		
	}
	
	private Project project;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@NotNull
	@Size(min=5, max=40)
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Size(min=7, max=45)
	@Column(name = "password")
    private String password;
	
	@Column(name = "enabled")
	private int enabled;
	
	@Column(name = "nameFirst")
	private String nameFirst;
	
	@Column(name = "nameLast")
    private String nameLast;
	
	@Column(name = "detail")
    private String detail;
	
	@Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
	
	@Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Country country;
	
	@Column(name = "authority")
	private String authority;
    
	@Column(name = "nonSmoking")
    Boolean nonSmoking;
	
	public int getId(){
		return id;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Gender getGender() {
    	
    	/*
    	if (this.gender == null){
    		return Gender.MALE;
    	}
    	*/
    	
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getNonSmoking() {
        return nonSmoking;
    }

    public void setNonSmoking(Boolean nonSmoking) {
        this.nonSmoking = nonSmoking;
    }
   
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    public int getEnabled() {
    	return enabled;
    }
    
    public void setEnabled(int enabled) {
    	this.enabled = enabled;
    }
    
    public String getAuthority() {
    	return authority;
    }
    
    public void setAuthority(String authority){
    	this.authority = authority;
    }


}