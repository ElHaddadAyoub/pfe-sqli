package org.sqli.authentification.dao;

import javax.persistence.*;

@Entity(name = "USER_GROUP")

public class Group {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;
    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "group")
    private User user;

    public Group() {
    }

    public Group(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
