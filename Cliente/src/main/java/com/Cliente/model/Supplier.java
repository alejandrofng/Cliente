package com.Cliente.model;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Supplier {

	@JsonIgnore
	private long id;

	@NotNull
	@Size(min = 10, max = 10)
	@Pattern(regexp = "[vVjJeE][0-9]*")
	private String code;

	@NotNull
	@Size(min = 5, max = 50)
	private String name;

	@JsonBackReference
	private Set<Product> products;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProduct() {
		return products;
	}

	public void setProduct(Set<Product> products) {
		this.products = products;
	}
}