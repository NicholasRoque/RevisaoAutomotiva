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

@Entity(name = "servico")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codServico;

    @Column
    private String descricao;

    @Column
    private Float valorServico;

    @JsonIgnore
    @ManyToMany(mappedBy = "servicos")
    List<Revisao> revisoes;

    public void removeRevisao(Revisao revisao){
        this.revisoes.remove(revisao);
        revisao.getServicos().remove(this);
    } 
}
