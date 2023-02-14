package com.example.demo.repository;

import com.example.demo.model.users.User;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Integer> {

     List<User> findAll();

     User save(User user);

     User insert(User user);



}
