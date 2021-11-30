package edu.fatec.RevisaoAutomotiva.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.RevisaoAutomotiva.domain.model.Revisao;
import edu.fatec.RevisaoAutomotiva.domain.repository.CarroRepository;
import edu.fatec.RevisaoAutomotiva.domain.repository.RevisaoRepository;
import edu.fatec.RevisaoAutomotiva.exception.CarroNotFoundException;

import edu.fatec.RevisaoAutomotiva.rest.dto.RevisaoDTO;

@Service
public class CarroService {


    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private RevisaoRepository revisaoRepository;

    public void addRevisao(RevisaoDTO revisaoDTO, Integer codCarro){
        carroRepository.findById(codCarro).ifPresentOrElse((carro) -> {
            Revisao revisao = revisaoDTO.toRevisao();
            revisao.setCarro(carro);
            revisaoRepository.save(revisao);
        }, ()-> {
            throw new CarroNotFoundException("Carro não encontrado.");
        });
    }

    public Map<String,Integer> relatorioServico(Integer codCarro){
        Map<String,Integer> qdtServicos = new HashMap<String,Integer>();
        carroRepository.findById(codCarro).ifPresentOrElse((carro) -> {
            carro.getRevisoes().forEach(revisao -> {
                revisao.getServicos().forEach(servico -> {
                    String descricao = servico.getDescricao();
                    if(qdtServicos.containsKey(descricao)){
                        Integer qtd = qdtServicos.get(descricao)+1;
                        qdtServicos.put(descricao, qtd);
                    } else {
                        qdtServicos.put(descricao, 1);
                    }
                });
            });
        }, () -> {
            throw new CarroNotFoundException("Carro não encontrado.");
        });
        return qdtServicos;
    }

}
