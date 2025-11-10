package io.github.eduardopec.desafio_nubank.repository;

import io.github.eduardopec.desafio_nubank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
