package org.sqli.authentification.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqli.authentification.dao.User;
import org.sqli.authentification.services.UserService;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/auth")
    public User authUser(@RequestBody User user){
        return userService.authUserbyLoginAndPassword(user);
    }



    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.createAccount(user);
    }





}
