package com.example.Banco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa uma conta bancária.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Saldo atual da conta.
     */
    private double saldo;

    /**
     * Limite máximo diário para transações.
     */
    private double limiteDiario;
}
