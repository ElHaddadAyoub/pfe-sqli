package org.sqli.authentification.exceptions;


public class UsertNotFoundExceptionHandler {
    private int id;



    public UsertNotFoundExceptionHandler(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
