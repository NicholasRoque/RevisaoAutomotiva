package edu.fatec.RevisaoAutomotiva.rest.dto;

import javax.validation.constraints.NotEmpty;

import edu.fatec.RevisaoAutomotiva.domain.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class EnderecoDTO {

    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;
    
    @NotEmpty(message = "{campo.bairro.obrigatorio}")
    private String bairro;
    
    @NotEmpty(message = "{campo.rua.obrigatorio}")
    private String rua;
    
    @NotEmpty(message = "{campo.numero.obrigatorio}")
    private String numero;
    
    public Endereco toEndereco(){
        return Endereco
                .builder()
                .cidade(this.cidade)
                .bairro(this.bairro)
                .rua(this.rua)
                .numero(this.numero)
                .build();
    }
}
