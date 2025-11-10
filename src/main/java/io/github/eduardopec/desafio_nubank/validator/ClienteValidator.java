package io.github.eduardopec.desafio_nubank.validator;

import io.github.eduardopec.desafio_nubank.model.dto.ClienteRequestDTO;
import io.github.eduardopec.desafio_nubank.repository.ClienteRepository;
import io.github.eduardopec.desafio_nubank.service.exceptions.DuplicateResourceException;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {

    private final ClienteRepository repository;

    public ClienteValidator(ClienteRepository repository) {
        this.repository = repository;
    }

    public void validar(ClienteRequestDTO request) {
        validarEmailDuplicado(request);
    }

    public void validarEmailDuplicado(ClienteRequestDTO request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email já cadastrado: " + request.getEmail());
        }
    }
}
