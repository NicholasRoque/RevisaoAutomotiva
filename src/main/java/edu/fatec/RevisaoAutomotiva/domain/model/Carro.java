package edu.fatec.RevisaoAutomotiva.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "carro")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCarro;

    @Column
    private String modelo;
    
    @Column
    private Integer ano;

    @Column
    private String placa;

    @Column
    private Float valorDeCompra;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codCliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carro")
    private List<Revisao> revisoes = new ArrayList<Revisao>();
}
