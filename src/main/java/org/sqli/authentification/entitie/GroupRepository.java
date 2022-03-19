package org.sqli.authentification.entitie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.dao.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
   // Long getGroupById(int toIntExact);
    //int getGroupById(int id);
}
