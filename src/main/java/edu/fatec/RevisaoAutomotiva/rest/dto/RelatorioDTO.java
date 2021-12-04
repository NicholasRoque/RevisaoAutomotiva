package edu.fatec.RevisaoAutomotiva.rest.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class RelatorioDTO {


    private String modelo;

    private Integer ano;

    private String placa;

    private Map<String,Integer> qtdServicos;


}
