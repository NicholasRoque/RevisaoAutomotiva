package edu.fatec.RevisaoAutomotiva.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.RevisaoAutomotiva.domain.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico,Integer> {
    Optional<Servico> findByDescricao(String descricao);
}
