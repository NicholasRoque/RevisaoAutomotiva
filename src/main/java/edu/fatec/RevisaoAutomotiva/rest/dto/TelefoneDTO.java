package edu.fatec.RevisaoAutomotiva.rest.dto;

import javax.validation.constraints.NotEmpty;

import edu.fatec.RevisaoAutomotiva.domain.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class TelefoneDTO {

    @NotEmpty(message = "{campo.ddd.obrigatorio}")
    private Integer ddd;
    
    @NotEmpty(message = "{campo.numero.obrigatorio}")
    private Integer numero;

    public Telefone toTelefone(){
        return Telefone
                .builder()
                .ddd(this.ddd)
                .numero(this.numero)
                .build();
    }
    
    
}
