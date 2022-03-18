package org.sqli.authentification.dao;

import javax.persistence.*;

@Entity
@Table(name = "group")
public class Group {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "group")
    private User user;

    public Group() {
    }

    public Group(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
