package org.sqli.authentification.exceptions;

public class ResponseException {
    private String error;


    public ResponseException( String error) {
        this.error = error;

    }

    public ResponseException() {

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
