package edu.fatec.RevisaoAutomotiva.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "cliente")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCliente;

    @Column(unique = true)
    private String cpf;
    
    @Column
    private String nome;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente")
    private List<Carro> carros = new ArrayList<Carro>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente")
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codEndereco", referencedColumnName = "codEndereco")
    private Endereco endereco;
}
