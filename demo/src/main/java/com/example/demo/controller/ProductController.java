package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
    @GetMapping("/home")
    public String hello() {
    	return"Hello! Welcome in Boot Spring Application";
    }
    
    @GetMapping("/product-list")
    public List<Product> getProductList(){
		return new ProductService().getProductList();
    }
    
    @PostMapping("/product")
    public Product save(Product p) {
    	return null;
    }
}
