package io.github.eduardopec.desafio_nubank.controller;

import io.github.eduardopec.desafio_nubank.model.dto.ClienteRequestDTO;
import io.github.eduardopec.desafio_nubank.model.dto.ClienteResponseDTO;
import io.github.eduardopec.desafio_nubank.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> lista = service.listarClientes();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> listarClientesPorId(@PathVariable Long id) {
        ClienteResponseDTO cliente = service.listarClientesPorId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(@Valid @RequestBody ClienteRequestDTO request) {
        ClienteResponseDTO response = service.cadastrar(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
