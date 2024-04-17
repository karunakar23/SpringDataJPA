package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public int cost;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userId")
	public User user;
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
	public List<product> products=new ArrayList<>();
	@Override
	public String toString() {
		return "Orders [id=" + id + ", cost=" + cost + ", user=" + user + ", products=" + products + "]";
	}
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<product> getProducts() {
		return products;
	}
	public void setProducts(List<product> products) {
		this.products = products;
	}
	
	
}
