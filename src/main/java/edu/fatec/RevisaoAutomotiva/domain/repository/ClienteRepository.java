package edu.fatec.RevisaoAutomotiva.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.RevisaoAutomotiva.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    Optional<Cliente> findByCpf(String cpf);
    
}
