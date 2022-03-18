package org.sqli.authentification.dao;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private Boolean enabled;
    private int loginAttempts;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id" ,nullable = false)
    private Group group;



    public User() {
    }

    public User(int id, String login, String password, Boolean enabled, int loginAttempts) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.loginAttempts = loginAttempts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
