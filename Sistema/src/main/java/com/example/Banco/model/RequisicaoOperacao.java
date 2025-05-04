package com.example.Banco.model;

import lombok.Data;

/**
 * Classe de apoio utilizada internamente para representar
 * uma requisição de operação bancária com todos os dados necessários.
 *
 * Essa estrutura é usada na cadeia de responsabilidade (handlers).
 */
@Data
public class RequisicaoOperacao {

    private Cliente cliente;
    private ContaBancaria conta;
    private String tipoOperacao;
    private double valor;
}
