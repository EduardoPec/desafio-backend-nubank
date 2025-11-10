package io.github.eduardopec.desafio_nubank.model.dto;

import io.github.eduardopec.desafio_nubank.model.Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoResponseDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDateTime dataCadastro;
    private Long clienteId;
    private String clienteNome;

    public static ContatoResponseDTO fromEntity(Contato contato) {
        return new ContatoResponseDTO(
                contato.getId(),
                contato.getNome(),
                contato.getTelefone(),
                contato.getEmail(),
                contato.getDataCadastro(),
                contato.getCliente().getId(),
                contato.getCliente().getNome()
        );
    }
}
