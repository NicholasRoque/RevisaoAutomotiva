package edu.fatec.RevisaoAutomotiva.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.RevisaoAutomotiva.domain.model.Servico;
import edu.fatec.RevisaoAutomotiva.domain.repository.ServicoRepository;
import edu.fatec.RevisaoAutomotiva.exception.ServicoCadastradoException;
import edu.fatec.RevisaoAutomotiva.rest.dto.ServicoDTO;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public void createServico(ServicoDTO servicoDTO){
        servicoRepository.findByDescricao(servicoDTO.getDescricao()).ifPresentOrElse((servico) -> {
            throw new ServicoCadastradoException("Serviço já cadastrado.");
        }, ()-> {
            servicoRepository.save(servicoDTO.toServico());
        });
    }

    public List<Servico> listServicos(){
        return servicoRepository.findAll();
    }

}
