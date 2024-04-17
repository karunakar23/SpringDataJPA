package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	
	@JsonIgnore
	@ManyToMany
	public Set<product> products=new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name= " + name + ", products=" + products + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<product> getProducts() {
		return products;
	}
	public void setProducts(Set<product> products) {
		this.products = products;
	}
	
	
	
}
