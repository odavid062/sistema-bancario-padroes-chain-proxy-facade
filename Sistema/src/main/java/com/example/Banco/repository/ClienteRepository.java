package com.example.Banco.repository;

import com.example.Banco.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório JPA para a entidade Cliente.
 *
 * Fornece métodos padrão para operações CRUD e permite
 * a criação de consultas customizadas por convenção.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Exemplos de métodos customizáveis:
    // Optional<Cliente> findByCpf(String cpf);
    // List<Cliente> findByNomeContaining(String nome);
}
