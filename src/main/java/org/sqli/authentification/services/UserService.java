package org.sqli.authentification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.Group;
import org.sqli.authentification.dao.User;
import org.sqli.authentification.entitie.GroupRepository;
import org.sqli.authentification.entitie.UserRepository;
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

        //userRepository.save(user);
        //Group grp = groupRepository.getGroupById(user.getGroup().getId());
        //user.setGroup(grp);
        user.setLoginAttempts(0);
        user.setEnabled(true);
        int id  = user.getGroup().getId();
        Group grp = groupRepository.findGroupById(id);
        if(grp==null){
            throw new AuthException("error :Group (group in input) is not valid");
        }
        User us = userRepository.save(user);
        return us;

    }




    //Supperesion compte :
    /*
    public void deleteAccount(String login){
        if(userRepository.findUserByLogin(login)){
            User us = userRepository.deleteUserByLogin(login);

        }else{
            //throw new UserNotFoundException("Login (login in input) is not found");
        }



    }
*/




}
