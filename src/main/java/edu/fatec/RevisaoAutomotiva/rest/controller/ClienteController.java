package edu.fatec.RevisaoAutomotiva.rest.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
@Api(tags = "Cliente")
public class ClienteController {

    @PostMapping
    @ApiOperation(value = "Cria um usuário.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
        @ApiResponse(code = 200,message = "Usuário encontrado."),
        @ApiResponse(code = 400,message = "Usuário já existente.")
    })
    public void createCliente() {
    }
}
