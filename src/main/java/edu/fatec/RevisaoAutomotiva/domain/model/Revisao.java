package edu.fatec.RevisaoAutomotiva.domain.model;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "revisao")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Revisao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codRevisao;

    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @Column
    private String estado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codCarro")
    private Carro carro;
}
