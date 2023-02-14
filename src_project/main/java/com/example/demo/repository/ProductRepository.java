package com.example.demo.repository;

import com.example.demo.model.products.Product;
import com.example.demo.model.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Integer> {

    List<Product> findAll();

    Product save(Product product);

    Product insert(Product product);



}
