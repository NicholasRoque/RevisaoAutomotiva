package edu.fatec.RevisaoAutomotiva.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.RevisaoAutomotiva.domain.model.Revisao;
import edu.fatec.RevisaoAutomotiva.domain.repository.CarroRepository;
import edu.fatec.RevisaoAutomotiva.domain.repository.RevisaoRepository;
import edu.fatec.RevisaoAutomotiva.exception.CarroNotFoundException;
import edu.fatec.RevisaoAutomotiva.exception.RevisaoNotFoundException;
import edu.fatec.RevisaoAutomotiva.rest.dto.RevisaoDTO;

@Service
public class RevisaoService {

    @Autowired
    private RevisaoRepository revisaoRepository;

    public void updateData(RevisaoDTO revisaoDTO, Integer codRevisao){
        revisaoRepository.findById(codRevisao).ifPresentOrElse((revisao) -> {
            revisao.setData(revisaoDTO.getData());
            revisaoRepository.save(revisao);
        }, ()-> {
            throw new RevisaoNotFoundException("Revisão não encontrada.");
        });
    }

    public void removeRevisao(Integer codRevisao){
        revisaoRepository.findById(codRevisao).ifPresentOrElse((revisao) -> {
            revisaoRepository.delete(revisao);
        }, () -> {
            throw new RevisaoNotFoundException("Revisão não encontrada.");
        });
    }

}
