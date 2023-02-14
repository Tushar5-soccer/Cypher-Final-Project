package com.example.demo.service.interfaces;

import com.example.demo.model.users.SignInRequest;
import com.example.demo.model.users.SignInResponse;
import com.example.demo.model.users.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);

    public List<User> signUp(User user);

    public SignInResponse signIn(SignInRequest signInRequest);


}
