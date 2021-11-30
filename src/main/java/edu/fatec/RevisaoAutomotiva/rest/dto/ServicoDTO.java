package edu.fatec.RevisaoAutomotiva.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.fatec.RevisaoAutomotiva.domain.model.Carro;
import edu.fatec.RevisaoAutomotiva.domain.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class ServicoDTO {

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.valorServico.obrigatorio}")
    private Float valorServico;

    public Servico toServico(){

        return Servico
                .builder()
                .descricao(this.descricao)
                .valorServico(this.valorServico)
                .build();
    }

}
