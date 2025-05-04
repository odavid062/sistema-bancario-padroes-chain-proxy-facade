package com.example.Banco.pattern.chain;

import com.example.Banco.model.RequisicaoOperacao;

/**
 * Handler que verifica se a conta possui saldo suficiente para a operação.
 */
public class SaldoHandler implements Handler {

    private Handler proximo;

    @Override
    public boolean handle(RequisicaoOperacao req) {
        if (req.getConta().getSaldo() < req.getValor()) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        return proximo == null || proximo.handle(req);
    }

    @Override
    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }
}
