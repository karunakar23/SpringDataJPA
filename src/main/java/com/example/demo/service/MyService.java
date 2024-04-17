package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Address;
import com.example.demo.models.Category;
import com.example.demo.models.Orders;
import com.example.demo.models.User;
import com.example.demo.models.product;
import com.example.demo.repo.UsersRepository;

@Service
public class MyService {
	
	public UsersRepository userrepo;
	
	public MyService(UsersRepository userrepo) {
		this.userrepo=userrepo;
	}
	
	public User createUserOrder(User user){
		User asli=new User();
		asli.setEmail(user.getEmail());
		asli.setName(user.getName());
		asli.setPassword(user.getPassword());
		Address add=new Address();
		add.setCity(user.getAddress().getCity());
		add.setPincode(user.getAddress().getPincode());
		add.setUser(asli);
		asli.setAddress(add);
		
		for(Orders i:user.getOrders()) {
			Orders order=new Orders();
			order.setCost(i.getCost());
			order.setUser(asli);
			asli.getOrders().add(order);
			for(product j:i.getProducts()) {
				product pro=new product();
				pro.setCost(j.getCost());
				pro.setName(j.getName());
				pro.setOrder(order);
				order.getProducts().add(pro);
				for(Category ct:j.getCategory()) {
					Category cat=new Category();
					cat.setName(ct.getName());
					pro.getCategory().add(cat);
					cat.getProducts().add(pro);
				}
			}
		}
		
		return this.userrepo.save(asli);
	}
	
	public User getById(int id) {
		Optional<User> opt=this.userrepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new RuntimeException("User Details not found for the ID "+id);
		}
	}

}
