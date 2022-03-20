package org.sqli.authentification.entitie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.dao.User;

public interface UserRepository extends JpaRepository<User , Integer> {
    //User findUser(User user);
     User findUserByLoginAndPassword(String login ,String password);

     User findUserByLogin(String login);

     //User deleteUserByLogin(String login);




}
