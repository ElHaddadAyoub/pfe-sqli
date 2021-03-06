package org.sqli.authentification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.dao.GroupRepository;
import org.sqli.authentification.dao.UserRepository;
import org.sqli.authentification.exceptions.AuthException;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public GroupRepository groupRepository;

    //method 1 autentification best case
    public static int i = 0;

    public User authUserbyLoginAndPassword(User user){

        User us = userRepository.findUserByLoginAndPassword(user.getLogin() , user.getPassword());

        if(us == null){
            User usa = userRepository.findUserByLogin(user.getLogin());
            if(usa.getLoginAttempts()==3){
                usa.setEnabled(false);
                userRepository.save(usa);
                throw new AuthException("error :You have reached 3 failed authentication attempts, your account will be disabled");
            }else{
                i++;
                usa.setLoginAttempts(i);
                userRepository.save(usa);
                throw new AuthException("Error : Authentication error :"+usa.getLoginAttempts());
            }

        }else if(us.getEnabled()== false){
            throw new AuthException("error :User disabled");
        }
        else{
            return us;
        }

    }



    //method save user
    public User createAccount(User user){

        user.setLoginAttempts(0);
        user.setEnabled(true);
        //test group if exist
        int id  = user.getGroup().getId();
        Group grp = groupRepository.findGroupById(id);


        //test login if exist in db with double
        String loginUs = user.getLogin();
        User userLogi = userRepository.findUserByLogin(loginUs);
        //boolean validPassword =  user.getPassword().equals(user.getPasswordConfirmation());
        //String pwdConfirmation = .;
        if(grp==null){
            throw new AuthException("error :Group (group in input) is not valid");
        }
        else if(userLogi != null){
            throw new AuthException("error :Login (login in input) is not valid");
        }

        User us = userRepository.save(user);
        return us;

    }




    //Supperesion compte :

    public void deleteAccount(String login){
        User userTest = userRepository.findUserByLogin(login);
        if(userTest != null){
            userRepository.delete(userTest);
            //throw new AuthException("success : Login (login in input) is deleted");
        }else{
            throw new AuthException("error :Group (group in input) is not valid");
        }



    }





}
