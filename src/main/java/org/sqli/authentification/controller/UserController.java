package org.sqli.authentification.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.dao.User;
import org.sqli.authentification.services.UserService;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestBody User user){
         User user1 = userService.authUserbyLoginAndPassword(user);
        return new ResponseEntity<User>(user1 , HttpStatus.OK);

    }



    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.createAccount(user);
    }

/*
    @DeleteMapping("/User/{login}")
    public ResponseEntity<?> deleteCompte(@PathVariable String login){
        userService.deleteAccount(login);
        return new ResponseEntity<String>("Login (in input) is deleted " , HttpStatus.OK);
    }
*/





}
