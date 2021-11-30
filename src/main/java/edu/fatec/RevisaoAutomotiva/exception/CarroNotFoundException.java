package edu.fatec.RevisaoAutomotiva.exception;

public class CarroNotFoundException extends RuntimeException{
    public CarroNotFoundException(String message){
        super(message);
    }
}
