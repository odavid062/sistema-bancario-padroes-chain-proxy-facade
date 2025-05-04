package com.example.Banco.pattern.chain;

import com.example.Banco.model.RequisicaoOperacao;

/**
 * Handler que valida se a operação excede o limite diário permitido.
 */
public class LimiteDiarioHandler implements Handler {

    private Handler proximo;
    private static final double LIMITE_DIARIO = 1000.0;

    @Override
    public boolean handle(RequisicaoOperacao req) {
        if (req.getValor() > LIMITE_DIARIO) {
            System.out.println("Valor excede o limite diário permitido.");
            return false;
        }
        return proximo == null || proximo.handle(req);
    }

    @Override
    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }
}
