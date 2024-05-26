package com.casealpe.nfeapi.api.exception;

public class InvalidNfeException extends RuntimeException{

    private static final String MESSAGE = "Invalid Nfe";

    public InvalidNfeException() {
        super(MESSAGE);
    }
}
