package com.example.Banco.pattern.proxy;

/**
 * Interface que define um serviço bancário genérico.
 *
 * Aplicação do padrão Proxy: permite que o acesso ao serviço real
 * seja controlado por um intermediário (proxy).
 */
public interface ServicoBancario {

    /**
     * Executa a operação bancária especificada.
     *
     * @param tipo  Tipo da operação (ex: "Saque", "Depósito", etc.)
     * @param valor Valor da transação
     */
    void realizarOperacao(String tipo, double valor);
}
