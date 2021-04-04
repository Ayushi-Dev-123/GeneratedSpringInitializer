package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductService {
   private List<Product>list;
   
   public ProductService() {
      list = new ArrayList<Product>();
      list.add(new Product(1,"Laptop",50000,"10 inch screen",2));     
      list.add(new Product(2,"Mice",3000,"",3));
      list.add(new Product(3,"Speaker",10000,"High quality sound ",4));
      list.add(new Product(4,"Keyboard",300,"",6));
      list.add(new Product(5,"Mouse",200,"wireless",5));
      list.add(new Product(6,"Camera",5000,"32mp",10));
   }
   
   public List<Product> getProductList(){
	   return list;
   }
   
}
