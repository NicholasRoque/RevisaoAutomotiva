package edu.fatec.RevisaoAutomotiva.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.RevisaoAutomotiva.domain.model.Revisao;

public interface RevisaoRepository extends JpaRepository<Revisao,Integer> {
    
}
