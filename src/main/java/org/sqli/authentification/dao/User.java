package org.sqli.authentification.dao;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "USER")

public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    @JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty( value = "enabled", access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ENABLED")
    private Boolean enabled;
    @Column(name = "LOGINATTEMPTS" , nullable = true)
    @JsonProperty( value = "loginAttempts", access = JsonProperty.Access.WRITE_ONLY)
    private int loginAttempts;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID" )
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
