package it.uniroma3.products;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Provider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String phoneNumber;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String vatin;
	
	@ManyToMany
	private List<Product> products;

	public Provider() {
		}
	
	public Provider(String name, String phoneNumber, String email, String vatin){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vatin = vatin;
	}

	// Getters & Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}	
}
