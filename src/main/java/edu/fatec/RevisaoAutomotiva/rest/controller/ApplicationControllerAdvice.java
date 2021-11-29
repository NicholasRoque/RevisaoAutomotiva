package edu.fatec.RevisaoAutomotiva.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.fatec.RevisaoAutomotiva.ApiErrors;
import edu.fatec.RevisaoAutomotiva.exception.ClienteCadastradoException;

/**
 * Classe responsável pelo tratamento de erros
 */
@RestControllerAdvice
public class ApplicationControllerAdvice {

    /* @ExceptionHandler(CredencialException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrors handleCredencialException(CredencialException ex){
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    } */

    @ExceptionHandler(ClienteCadastradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleClienteCadastradoException(ClienteCadastradoException ex){
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    } 

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(erro-> erro.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(errors);
    }

    
    
}


