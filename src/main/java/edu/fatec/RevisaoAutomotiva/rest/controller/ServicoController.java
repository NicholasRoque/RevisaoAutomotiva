package edu.fatec.RevisaoAutomotiva.rest.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import edu.fatec.RevisaoAutomotiva.domain.model.Servico;
import edu.fatec.RevisaoAutomotiva.exception.ServicoCadastradoException;
import edu.fatec.RevisaoAutomotiva.rest.dto.ServicoDTO;
import edu.fatec.RevisaoAutomotiva.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/servicos")
@Api(tags = "Serviço")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    @Transactional
    @ApiOperation(value = "Cria um serviço.")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
        @ApiResponse(code = 201,message = "Serviço criado com sucesso."),
        @ApiResponse(code = 400,message = "Informações incorretas.")
    })
    public void createServico(@RequestBody @Valid ServicoDTO servicoDTO) throws ServicoCadastradoException{
        try {
            servicoService.createServico(servicoDTO);
        } catch (ServicoCadastradoException e) {
            throw new ServicoCadastradoException(e.getMessage());
        }
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os serviços.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 200,message = "Serviços retornados com sucesso.")
    public List<Servico> listServicos(){
        return servicoService.listServicos();
    }


}
