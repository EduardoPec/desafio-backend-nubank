package io.github.eduardopec.desafio_nubank.service;

import io.github.eduardopec.desafio_nubank.model.Cliente;
import io.github.eduardopec.desafio_nubank.model.Contato;
import io.github.eduardopec.desafio_nubank.model.dto.ContatoRequestDTO;
import io.github.eduardopec.desafio_nubank.model.dto.ContatoResponseDTO;
import io.github.eduardopec.desafio_nubank.repository.ClienteRepository;
import io.github.eduardopec.desafio_nubank.repository.ContatoRepository;
import io.github.eduardopec.desafio_nubank.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ClienteRepository clienteRepository;

    public ContatoService(ClienteRepository clienteRepository, ContatoRepository contatoRepository) {
        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;
    }

    public ContatoResponseDTO cadastrar(ContatoRequestDTO request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado. ID: " + request.getClienteId()));
        Contato contato = request.toEntity();
        contato.setCliente(cliente);
        Contato salvar = contatoRepository.save(contato);
        return ContatoResponseDTO.fromEntity(salvar);
    }
}
