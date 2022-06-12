package com.spring.recrutement.exception;

public class CandidatureNotFoundException extends RuntimeException{
    public CandidatureNotFoundException(String message) {
        super(message);
    }
}
