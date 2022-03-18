package org.sqli.authentification.dao;

import javax.persistence.*;

@Entity(name = "USER")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ENABLED")
    private Boolean enabled;


    @Column(name = "LOGINATTEMPTS" , nullable = true)
    private int loginAttempts;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "GROUP_ID" ,nullable = false)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User() {
    }

    public User(Integer id, String login, String password, Boolean enabled, int loginAttempts) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.loginAttempts = loginAttempts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }


}
