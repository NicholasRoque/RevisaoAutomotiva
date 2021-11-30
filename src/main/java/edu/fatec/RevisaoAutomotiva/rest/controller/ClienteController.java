package edu.fatec.RevisaoAutomotiva.rest.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import edu.fatec.RevisaoAutomotiva.domain.model.Cliente;
import edu.fatec.RevisaoAutomotiva.exception.ClienteCadastradoException;
import edu.fatec.RevisaoAutomotiva.exception.ClienteNotFoundException;
import edu.fatec.RevisaoAutomotiva.rest.dto.CarroDTO;
import edu.fatec.RevisaoAutomotiva.rest.dto.ClienteDTO;
import edu.fatec.RevisaoAutomotiva.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
@Api(tags = "Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    @ApiOperation(value = "Cria um cliente.")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
        @ApiResponse(code = 201,message = "Cliente criado com sucesso."),
        @ApiResponse(code = 400,message = "Cliente já existente."),
        @ApiResponse(code = 400,message = "Informações incorretas.")
    })
    public void createCliente(@RequestBody @Valid ClienteDTO clienteDTO) throws ClienteCadastradoException{
        try {
            clienteService.createCliente(clienteDTO);
        } catch (ClienteCadastradoException e) {
            throw new ClienteCadastradoException(e.getMessage());
        }
    }

    @PatchMapping("/{codCliente}/carros/add")
    @Transactional
    @ApiOperation(value = "Adiciona o carro de um cliente.")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
        @ApiResponse(code = 201,message = "Carro adicionado com sucesso."),
        @ApiResponse(code = 404,message = "Cliente não encontrado."),
        @ApiResponse(code = 400,message = "Informações incorretas.")
    })
    public void addCarro(@RequestBody @Valid CarroDTO carroDTO,@PathVariable Integer codCliente) throws ClienteNotFoundException{
        try {
            clienteService.addCarro(carroDTO,codCliente);
        } catch (ClienteNotFoundException e) {
            throw new ClienteNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os clientes.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 201,message = "Clientes retornados com sucesso.")
    public List<Cliente> listClientes(){
        return clienteService.listClientes();
    }
}
