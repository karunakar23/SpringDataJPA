package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.product;

public interface ProductsRepo extends  JpaRepository<product,Integer>{
	

}
