package edu.fatec.RevisaoAutomotiva.exception;

public class RevisaoNotFoundException extends RuntimeException{
    public RevisaoNotFoundException(String message){
        super(message);
    }
}
