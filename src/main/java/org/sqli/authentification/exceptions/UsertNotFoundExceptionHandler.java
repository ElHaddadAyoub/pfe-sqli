package org.sqli.authentification.exceptions;


public class UsertNotFoundExceptionHandler {
    private String id;



    public UsertNotFoundExceptionHandler(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
