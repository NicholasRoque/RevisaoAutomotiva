package edu.fatec.RevisaoAutomotiva.rest.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import edu.fatec.RevisaoAutomotiva.exception.RevisaoNotFoundException;
import edu.fatec.RevisaoAutomotiva.rest.dto.RevisaoDTO;
import edu.fatec.RevisaoAutomotiva.service.RevisaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/revisoes")
@Api(tags = "Revisão")
public class RevisaoController {

    @Autowired
    private RevisaoService revisaoService;


    @PatchMapping("/{codRevisao}/data")
    @Transactional
    @ApiOperation(value = "Muda a data de uma revisão.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
        @ApiResponse(code = 201,message = "Data da revisão alterada com sucesso."),
        @ApiResponse(code = 404,message = "Revisão não encontrada."),
        @ApiResponse(code = 400,message = "Informações incorretas.")
    })
    public void updateData(@RequestBody @Valid RevisaoDTO revisaoDTO,@PathVariable Integer codRevisao) throws RevisaoNotFoundException{
        try {
            revisaoService.updateData(revisaoDTO,codRevisao);
        } catch (RevisaoNotFoundException e) {
            throw new RevisaoNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{codRevisao}")
    @Transactional
    @ApiOperation(value = "Cancela uma revisão.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
        @ApiResponse(code = 201,message = "Revisão removida com sucesso."),
        @ApiResponse(code = 404,message = "Revisão não encontrada."),
        @ApiResponse(code = 400,message = "Informações incorretas.")
    })
    public void removeRevisao(@PathVariable Integer codRevisao) throws RevisaoNotFoundException{
        try {
            revisaoService.removeRevisao(codRevisao);
        } catch (RevisaoNotFoundException e) {
            throw new RevisaoNotFoundException(e.getMessage());
        }
    }

}
