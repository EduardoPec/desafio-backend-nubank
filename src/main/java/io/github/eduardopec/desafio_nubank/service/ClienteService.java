package io.github.eduardopec.desafio_nubank.service;

import io.github.eduardopec.desafio_nubank.model.Cliente;
import io.github.eduardopec.desafio_nubank.model.dto.ClienteRequestDTO;
import io.github.eduardopec.desafio_nubank.model.dto.ClienteResponseDTO;
import io.github.eduardopec.desafio_nubank.repository.ClienteRepository;
import io.github.eduardopec.desafio_nubank.service.exceptions.ResourceNotFoundException;
import io.github.eduardopec.desafio_nubank.validator.ClienteValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteValidator validator;

    public ClienteService(ClienteRepository repository, ClienteValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<ClienteResponseDTO> listarClientes() {
        return repository.findAll().stream()
                .map(ClienteResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO listarClientesPorId(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado. ID: " + id));
        return ClienteResponseDTO.fromEntity(cliente);
    }

    public ClienteResponseDTO cadastrar(ClienteRequestDTO request) {
        validator.validar(request);
        Cliente cliente = request.toEntity();
        Cliente salvar = repository.save(cliente);
        return ClienteResponseDTO.fromEntity(salvar);
    }
}
