package com.example.Banco.pattern.chain;

import com.example.Banco.model.RequisicaoOperacao;

/**
 * Handler responsável por verificar se o cliente está autenticado.
 * Parte da cadeia de responsabilidade (Chain of Responsibility).
 */
public class AutenticacaoHandler implements Handler {

    private Handler proximo;

    @Override
    public boolean handle(RequisicaoOperacao req) {
        if (!req.getCliente().isAutenticado()) {
            System.out.println("Cliente não autenticado.");
            return false;
        }
        return proximo == null || proximo.handle(req);
    }

    @Override
    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }
}
