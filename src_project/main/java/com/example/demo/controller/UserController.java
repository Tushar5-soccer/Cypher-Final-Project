package com.example.demo.controller;

import com.example.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    
}
