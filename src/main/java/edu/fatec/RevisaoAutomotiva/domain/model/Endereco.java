package edu.fatec.RevisaoAutomotiva.domain.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "endereco")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEndereco;

    @Column
    private String cidade;
    
    @Column
    private String bairro;
    
    @Column
    private String rua;
    
    @Column
    private String numero;
}
