package edu.fatec.RevisaoAutomotiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.RevisaoAutomotiva.domain.model.Cliente;
import edu.fatec.RevisaoAutomotiva.domain.repository.ClienteRepository;
import edu.fatec.RevisaoAutomotiva.exception.ClienteCadastradoException;
import edu.fatec.RevisaoAutomotiva.rest.dto.ClienteDTO;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public void createCliente(ClienteDTO clienteDTO){
        clienteRepository.findByCpf(clienteDTO.getCpf()).ifPresentOrElse((cliente)->{
            throw new ClienteCadastradoException("Cliente já cadastrado.");
        }, ()->{
            clienteRepository.save(clienteDTO.toCliente());
        });
    }

    public List<Cliente> listClientes(){
        return clienteRepository.findAll();
    }
}
