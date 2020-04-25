package com.jyot.springweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jyot.springweb.entities.Product;
import com.jyot.springweb.repos.ProductRepository;


@RestController
@RequestMapping(value = "Productapi")
public class ProductRestController {

	@Autowired
	ProductRepository repository;
	
	//FindAll Method
	@RequestMapping(value="/products/",method=RequestMethod.GET)
	public List<Product> getProduct(){
		return repository.findAll();
		
	}
	
	//FindById Method
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	//update Method
	@RequestMapping(value="/products/",method=RequestMethod.PUT )
	public Product updateProduct(Product product) {
		return repository.save(product);
	}
	
	
	//delete Method
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE )
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}