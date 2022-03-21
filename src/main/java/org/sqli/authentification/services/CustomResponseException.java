package org.sqli.authentification.services;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.sqli.authentification.exceptions.AuthException;
import org.sqli.authentification.exceptions.ResponseException;

public class CustomResponseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ResponseException> loginExceptionHandler(AuthException ex){
        ResponseException errorAuth = new ResponseException();
        errorAuth.setError(ex.getMessage());

        return new ResponseEntity<>( errorAuth, HttpStatus.BAD_REQUEST);

    }
}
