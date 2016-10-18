package DAO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Validations.ValidEmail;

public class Offer {
	
	public Offer( String name, String email, String description) {
		this.name = name;
		this.email = email;
		this.description = description;
	}
	
	public Offer(){
		
	}

	private int ID;
	
	@Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters.")
	private String name;
	
	@NotNull
	// @Pattern(regexp = ".*\\@.*\\..*", message = "Enter a valid E-mail address.") <- THIS IS USING REGEX TO VALIDATE EMAIL - IT IS OKAY.
	@ValidEmail(min = 6, message = "Fake Email.")
	private String email;
	
	@Size(min = 10, max = 250, message = "Text must be between 10 to 250 characters.")
	private String description;

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Offer [ID=" + ID + ", name=" + name + ", email=" + email + ", description=" + description + "]";
	}

}
