package io.github.eduardopec.desafio_nubank.controller;

import io.github.eduardopec.desafio_nubank.model.dto.ContatoRequestDTO;
import io.github.eduardopec.desafio_nubank.model.dto.ContatoResponseDTO;
import io.github.eduardopec.desafio_nubank.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> cadastrar(@Valid @RequestBody ContatoRequestDTO request) {
        ContatoResponseDTO response = service.cadastrar(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
