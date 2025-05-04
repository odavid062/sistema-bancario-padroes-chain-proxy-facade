package com.example.Banco.repository;

import com.example.Banco.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório JPA para a entidade ContaBancaria.
 *
 * Oferece operações CRUD e suporte para consultas personalizadas.
 */
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    // Exemplo de método customizado:
    // List<ContaBancaria> findByTipoConta(String tipo);
}
