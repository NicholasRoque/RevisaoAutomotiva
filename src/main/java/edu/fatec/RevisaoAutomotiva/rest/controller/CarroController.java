package edu.fatec.RevisaoAutomotiva.rest.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import edu.fatec.RevisaoAutomotiva.exception.CarroNotFoundException;
import edu.fatec.RevisaoAutomotiva.exception.ClienteNotFoundException;
import edu.fatec.RevisaoAutomotiva.rest.dto.RevisaoDTO;
import edu.fatec.RevisaoAutomotiva.service.CarroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/carros")
@Api(tags = "Carro")
public class CarroController {

    @Autowired
    private CarroService carroService;


    @PatchMapping("/{codCarro}/revisoes/add")
    @Transactional
    @ApiOperation(value = "Adiciona uma revisão a um carro.")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
        @ApiResponse(code = 201,message = "Revisão adicionada com sucesso."),
        @ApiResponse(code = 404,message = "Carro não encontrado."),
        @ApiResponse(code = 400,message = "Informações incorretas.")
    })
    public void addRevisao(@RequestBody @Valid RevisaoDTO revisaoDTO,@PathVariable Integer codCarro) throws CarroNotFoundException{
        try {
            carroService.addRevisao(revisaoDTO,codCarro);
        } catch (ClienteNotFoundException e) {
            throw new CarroNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/{codCarro}/relatorio")
    @ApiOperation(value = "Retorna um relatorio com a quantidade de servicos de determinado veiculo.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 200,message = "Clientes retornados com sucesso.")
    public Map<String,Integer> relatorioServico(@PathVariable Integer codCarro) throws CarroNotFoundException{
        try {
            return carroService.relatorioServico(codCarro);
        } catch (CarroNotFoundException e) {
            throw new CarroNotFoundException(e.getMessage());
        }
    }

}
