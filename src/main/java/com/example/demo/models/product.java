package com.example.demo.models;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class product {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int id;
	public int cost;
	public String name;
	
	@ManyToMany(mappedBy="products",cascade=CascadeType.ALL)
	public Set<Category> category=new HashSet<>();
	
	
	@Override
	public String toString() {
		return "product [id=" + id + ", cost=" + cost + ", name=" + name + ", category=" + category + ", order=" + order
				+ "]";
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="order_id")
	public Orders order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
	
}
