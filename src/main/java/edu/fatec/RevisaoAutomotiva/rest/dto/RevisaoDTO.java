package edu.fatec.RevisaoAutomotiva.rest.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.fatec.RevisaoAutomotiva.domain.model.Carro;
import edu.fatec.RevisaoAutomotiva.domain.model.Revisao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class RevisaoDTO {

    @NotNull(message = "{campo.data.obrigatorio}")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    public Revisao toRevisao(){

        return Revisao
                .builder()
                .data(this.data)
                .estado("Agendado")
                .build();
    }

}
