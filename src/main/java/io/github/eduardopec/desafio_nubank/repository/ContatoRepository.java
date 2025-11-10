package io.github.eduardopec.desafio_nubank.repository;

import io.github.eduardopec.desafio_nubank.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
