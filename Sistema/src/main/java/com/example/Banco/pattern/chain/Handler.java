package com.example.Banco.pattern.chain;

import com.example.Banco.model.RequisicaoOperacao;

/**
 * Interface do padrão Chain of Responsibility.
 * Define um manipulador que processa uma requisição e delega ao próximo, se necessário.
 */
public interface Handler {

    /**
     * Executa o processamento da requisição.
     *
     * @param req Objeto contendo os dados da operação bancária.
     * @return true se a operação for aceita, false caso contrário.
     */
    boolean handle(RequisicaoOperacao req);

    /**
     * Define o próximo handler na cadeia.
     *
     * @param proximo Próximo manipulador a ser executado.
     */
    void setProximo(Handler proximo);
}
