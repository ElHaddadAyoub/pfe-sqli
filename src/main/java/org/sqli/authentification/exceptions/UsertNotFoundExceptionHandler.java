package org.sqli.authentification.exceptions;


class UserNotFoundExceptionHandler {
    private int id;



    public UserNotFoundExceptionHandler(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
