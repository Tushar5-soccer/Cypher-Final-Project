package com.example.demo.service.implementation;

import com.example.demo.model.users.SignInRequest;
import com.example.demo.model.users.SignInResponse;
import com.example.demo.model.users.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> signUp(User user) {
        String password = user.getPassword();
        String encryptedToken = hash(password);
        user.setPassword(encryptedToken);
        userRepository.save(user);
        Query query = new Query();
        query.addCriteria(Criteria.where("image").is("book.png"));

        List<User> events = mongoTemplate.find(query, User.class);

        return events;
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        SignInResponse signInResponse = new SignInResponse();
        String userName = signInRequest.getUserName();
        String password = signInRequest.getPassword();
        String token = hash(password);


        Query query = new Query();
        Criteria criteria1 = Criteria.where("userName").is(userName);
        Criteria criteria2 = Criteria.where("password").is(token);
        query.addCriteria(criteria1);
        query.addCriteria(criteria2);

        signInResponse.setUserName(userName);

        User user = mongoTemplate.findOne(query, User.class);
        if(user == null){
            signInResponse.setMessage("Authentication Failed");
        }else{
            signInResponse.setMessage("Authentication Successful");
        }

        return signInResponse;
    }


    String hash(String str){

        return null;
    }


}
