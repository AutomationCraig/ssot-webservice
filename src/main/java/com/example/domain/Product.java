package com.example.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.example.domain.prettyOutputs.PrettyProduct;
import com.google.gson.Gson;

@Entity
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 7884292690096443611L;

	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	Long prodcutId;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	private String productName;
	
	@OneToMany(mappedBy="product")
	private List<Project> projects;

	
	
	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Product() {
		super();
	}

	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	

	public Long getProdcutId() {
		return prodcutId;
	}

	public String toString() {
		PrettyProduct prettyProduct = new PrettyProduct(this);
		Gson gson = new Gson();
		return gson.toJson(prettyProduct);
	}
}