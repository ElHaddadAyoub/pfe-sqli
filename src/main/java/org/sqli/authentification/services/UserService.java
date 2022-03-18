package org.sqli.authentification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.User;
import org.sqli.authentification.entitie.UserRepository;
import org.sqli.authentification.exceptions.UserNotFoundException;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    //method 1 autentification best case
    public User authUserbyLoginAndPassword(User user){


        User us = userRepository.findUserByLoginAndPassword(user.getLogin() , user.getPassword());
        if(us != null ){
            if(!us.getEnabled()){
                throw new UserNotFoundException("User Disabled");
            }
            return us;
        }
        else{
            throw new UserNotFoundException("Authentification error");
        }
    }



    //method save user
    public User createAccount(User user){

        User us =  userRepository.save(user);

        return us;
    }




    //Supperesion compte :
    public void deleteAccount(String login){
        if(userRepository.findUserByLogin(login)){
            User us = userRepository.deleteUserByLogin(login);

        }else{
            throw new UserNotFoundException("Login (login in input) is not found");
        }



    }





}
