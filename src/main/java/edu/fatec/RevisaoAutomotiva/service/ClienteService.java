package edu.fatec.RevisaoAutomotiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.RevisaoAutomotiva.domain.model.Carro;
import edu.fatec.RevisaoAutomotiva.domain.model.Cliente;
import edu.fatec.RevisaoAutomotiva.domain.repository.CarroRepository;
import edu.fatec.RevisaoAutomotiva.domain.repository.ClienteRepository;
import edu.fatec.RevisaoAutomotiva.domain.repository.TelefoneRepository;
import edu.fatec.RevisaoAutomotiva.exception.ClienteCadastradoException;
import edu.fatec.RevisaoAutomotiva.exception.ClienteNotFoundException;
import edu.fatec.RevisaoAutomotiva.rest.dto.CarroDTO;
import edu.fatec.RevisaoAutomotiva.rest.dto.ClienteDTO;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    public void createCliente(ClienteDTO clienteDTO){
        clienteRepository.findByCpf(clienteDTO.getCpf()).ifPresentOrElse((cliente)->{
            throw new ClienteCadastradoException("Cliente já cadastrado.");
        }, ()->{
            final Cliente cliente = clienteDTO.toCliente();
            clienteDTO.toCliente().getTelefones().forEach(t ->{
                t.setCliente(cliente);
                telefoneRepository.save(t);
            });
            clienteDTO.toCliente().getCarros().forEach(c ->{
                c.setCliente(cliente);
                carroRepository.save(c);
            });
            System.out.println(cliente.toString());

            clienteRepository.save(cliente);
            
        });
    }

    public void addCarro(CarroDTO carroDTO, Integer codCliente){
        clienteRepository.findById(codCliente).ifPresentOrElse((cliente) -> {
            Carro carro = carroDTO.toCarro();
            carro.setCliente(cliente);
            carroRepository.save(carro);
        }, ()-> {
            throw new ClienteNotFoundException("Cliente não encontrado.");
        });
    }

    public List<Cliente> listClientes(){
        return clienteRepository.findAll();
    }
}
