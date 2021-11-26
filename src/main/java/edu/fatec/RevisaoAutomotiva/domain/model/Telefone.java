package edu.fatec.RevisaoAutomotiva.domain.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "telefone")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTelefone;

    @Column
    private Integer ddd;
    
    @Column
    private Integer numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codCliente")
    private Cliente cliente;
}
