package com.example.Banco.service;

import com.example.Banco.model.RequisicaoOperacao;
import com.example.Banco.pattern.chain.AutenticacaoHandler;
import com.example.Banco.pattern.chain.Handler;
import com.example.Banco.pattern.chain.LimiteDiarioHandler;
import com.example.Banco.pattern.chain.SaldoHandler;
import org.springframework.stereotype.Service;

/**
 * Serviço que aplica validações nas operações bancárias.
 *
 * Implementa a cadeia de responsabilidade para organizar as regras de negócio.
 */
@Service
public class ValidacaoService {

    /**
     * Executa a cadeia de validações sobre a requisição.
     *
     * @param req Requisição da operação (cliente, conta, valor, etc.)
     * @return true se todas as validações forem aprovadas; false caso contrário
     */
    public boolean validar(RequisicaoOperacao req) {
        Handler autenticacao = new AutenticacaoHandler();
        Handler saldo = new SaldoHandler();
        Handler limite = new LimiteDiarioHandler();

        autenticacao.setProximo(saldo);
        saldo.setProximo(limite);

        return autenticacao.handle(req);
    }
}
