package io.github.eduardopec.desafio_nubank.service;

import io.github.eduardopec.desafio_nubank.model.Contato;
import io.github.eduardopec.desafio_nubank.model.dto.ContatoRequestDTO;
import io.github.eduardopec.desafio_nubank.model.dto.ContatoResponseDTO;
import io.github.eduardopec.desafio_nubank.repository.ContatoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public ContatoResponseDTO cadastrar(ContatoRequestDTO request) {
        Contato contato = request.toEntity();
        Contato salvar = repository.save(contato);
        return ContatoResponseDTO.fromEntity(salvar);
    }
}
