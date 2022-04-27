package com.michelle.cookieorder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required!")
	private String name;
	
	@NotEmpty(message="Quantity is required!")
	private String cookieQuantity;
	
	@NotEmpty(message="Price is required!")
	private Double cookiePrice;
	
	@NotEmpty(message="Description is required!")
	private String description;
	
	@NotEmpty(message="Photo is required!")
	private String photo;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	public Product() {};
	
    public Product(String id){
        this.id = Long.parseLong(id);
    }
    
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

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

	public String getCookieQuantity() {
		return cookieQuantity;
	}

	public void setCookieQuantity(String cookieQuantity) {
		this.cookieQuantity = cookieQuantity;
	}

	public Double getCookiePrice() {
		return cookiePrice;
	}

	public void setCookiePrice(Double cookiePrice) {
		this.cookiePrice = cookiePrice;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
