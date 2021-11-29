package edu.fatec.RevisaoAutomotiva.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import edu.fatec.RevisaoAutomotiva.domain.model.Carro;
import edu.fatec.RevisaoAutomotiva.domain.model.Cliente;
import edu.fatec.RevisaoAutomotiva.domain.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class ClienteDTO {
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    private List<CarroDTO> carros = new ArrayList<CarroDTO>();

    private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();

    private @Valid EnderecoDTO endereco = new EnderecoDTO();

    public Cliente toCliente(){
        List<Telefone> telefonesCliente = new ArrayList<Telefone>();
        List<Carro> carrosCliente = new ArrayList<Carro>();

        this.telefones.forEach(t -> {
            telefonesCliente.add(t.toTelefone());
        });

        this.carros.forEach(c -> {
            carrosCliente.add(c.toCarro());
        });
        return Cliente
                .builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .endereco(this.endereco.toEndereco())
                .telefones(telefonesCliente)
                .carros(carrosCliente)
                .build();
    }

}
