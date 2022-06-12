package com.spring.recrutement.exception;

public class CandidatNotFoundException extends RuntimeException{

    public CandidatNotFoundException(String message) {
        super(message);
    }
}
