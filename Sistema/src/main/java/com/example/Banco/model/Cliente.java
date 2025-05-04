package com.example.Banco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um cliente do sistema bancário.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    /**
     * Indica se o cliente está autenticado no sistema.
     */
    private boolean autenticado;

    /**
     * Relacionamento 1:1 com a conta bancária do cliente.
     * A conta é persistida automaticamente junto com o cliente.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id")
    private ContaBancaria conta;
}
