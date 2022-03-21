package org.sqli.authentification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.entitie.User;
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
    public ResponseEntity<?> saveUser(@RequestBody User user){
       User createdUser =  userService.createAccount(user);
        return new ResponseEntity<User>(createdUser , HttpStatus.OK);
    }


    @DeleteMapping("/user/{login}")
    public ResponseEntity<String> deleteCompte(@PathVariable String login){
        userService.deleteAccount(login);
        return new ResponseEntity<String>("success : Login (login in input) is deleted" , HttpStatus.OK);
    }






}
