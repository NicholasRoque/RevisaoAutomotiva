package edu.fatec.RevisaoAutomotiva.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.fatec.RevisaoAutomotiva.domain.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class CarroDTO {


    @NotEmpty(message = "{campo.modelo.obrigatorio}")
    private String modelo;

    @NotNull(message = "{campo.ano.obrigatorio}")
    private Integer ano;

    @NotEmpty(message = "{campo.placa.obrigatorio}")
    private String placa;

    @NotNull(message = "{campo.valorDeCompra.obrigatorio}")
    private Float valorDeCompra;

    public Carro toCarro(){

        return Carro
                .builder()
                .modelo(this.modelo)
                .ano(this.ano)
                .placa(this.placa)
                .valorDeCompra(this.valorDeCompra)
                .build();
    }

}
