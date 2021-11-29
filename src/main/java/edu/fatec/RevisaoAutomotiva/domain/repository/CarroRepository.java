package edu.fatec.RevisaoAutomotiva.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.RevisaoAutomotiva.domain.model.Carro;

public interface CarroRepository extends JpaRepository<Carro,Integer> {
    
}

