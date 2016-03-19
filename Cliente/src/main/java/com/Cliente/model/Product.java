package com.Cliente.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Product {
	@NotNull
	@JsonIgnore
	private long id;
	
	@NotNull
	@Size(min = 3, max = 10)
	private String code;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String description;

	@JsonManagedReference
	private Supplier supplier;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}