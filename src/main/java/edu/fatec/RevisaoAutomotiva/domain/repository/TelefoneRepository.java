package edu.fatec.RevisaoAutomotiva.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.RevisaoAutomotiva.domain.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone,Integer> {
    
}

