package com.example.Banco.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * DTO utilizado para transportar os dados de uma operação bancária (ex: saque).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperacaoDTO {

    /**
     * Identificador do cliente que está realizando a operação.
     */
    private Long clienteId;

    /**
     * Valor da operação a ser executada.
     */
    private double valor;
}
