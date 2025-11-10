package io.github.eduardopec.desafio_nubank.model.dto;

import io.github.eduardopec.desafio_nubank.model.Contato;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "ID do cliente é obrigatório")
    private Long clienteId;

    public Contato toEntity() {
        Contato contato = new Contato();
        contato.setNome(this.nome);
        contato.setTelefone(this.telefone);
        contato.setEmail(this.email);
        return contato;
    }
}
