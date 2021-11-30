package edu.fatec.RevisaoAutomotiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.RevisaoAutomotiva.domain.repository.RevisaoRepository;
import edu.fatec.RevisaoAutomotiva.domain.repository.ServicoRepository;
import edu.fatec.RevisaoAutomotiva.exception.RevisaoNotFoundException;
import edu.fatec.RevisaoAutomotiva.rest.dto.RevisaoDTO;

@Service
public class RevisaoService {

    @Autowired
    private RevisaoRepository revisaoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

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

    public void addServico(List<Integer> listCodServico,Integer codRevisao){
        revisaoRepository.findById(codRevisao).ifPresentOrElse((revisao) -> {
            listCodServico.forEach(codServico -> {
                servicoRepository.findById(codServico).ifPresent(servico -> {
                    revisao.getServicos().add(servico);
                    servico.getRevisoes().add(revisao);
                    servicoRepository.save(servico);
                });
                revisaoRepository.save(revisao);
            });
            
        }, () -> {
            throw new RevisaoNotFoundException("Revisão não encontrada.");
        });
    }

    

}
