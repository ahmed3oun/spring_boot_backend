package com.spring.recrutement.exception;

public class CompetenceNotFoundException extends RuntimeException{
    public CompetenceNotFoundException(String message) {
        super(message);
    }
}
