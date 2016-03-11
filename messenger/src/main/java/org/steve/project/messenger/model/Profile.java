package org.steve.project.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Profile {

	private long id;
	private String pseudo;
	private String firstName;
	private String lastName;
	private String adresseMail;
	private Date created;
	private String sexe;
	
	public Profile(){
		
	}

	public Profile(long id, String pseudo, String firstName, String lastName, String adresseMail, String sexe) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresseMail = adresseMail;
		this.sexe = sexe;
	}

	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setPseudo(String profileName) {
		this.pseudo = profileName;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
