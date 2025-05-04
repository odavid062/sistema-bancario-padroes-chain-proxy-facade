package com.example.Banco.pattern.facade;

import org.springframework.stereotype.Component;
import com.example.Banco.model.Cliente;
import com.example.Banco.model.RequisicaoOperacao;
import com.example.Banco.pattern.chain.AutenticacaoHandler;
import com.example.Banco.pattern.chain.Handler;
import com.example.Banco.pattern.chain.LimiteDiarioHandler;
import com.example.Banco.pattern.chain.SaldoHandler;
import com.example.Banco.pattern.proxy.ServicoBancario;
import com.example.Banco.pattern.proxy.ServicoBancarioProxy;

/**
 * Facade que encapsula o fluxo completo de validação e execução de operações bancárias.
 *
 * Aplica os padrões de projeto:
 * - Facade: simplifica o uso das validações e execução.
 * - Chain of Responsibility: executa verificações encadeadas.
 * - Proxy: protege o acesso ao serviço bancário real.
 */
@Component
public class BancoFacade {

    /**
     * Executa uma operação bancária com validações de segurança e saldo.
     *
     * @param tipo    Tipo da operação (ex: "Saque", "Transferência")
     * @param valor   Valor a ser movimentado
     * @param cliente Cliente que está solicitando a operação
     * @return Mensagem indicando sucesso ou falha da operação
     */
    public String executarOperacao(String tipo, double valor, Cliente cliente) {
        RequisicaoOperacao req = new RequisicaoOperacao();
        req.setCliente(cliente);
        req.setConta(cliente.getConta());
        req.setTipoOperacao(tipo);
        req.setValor(valor);

        // Monta a cadeia de responsabilidade
        Handler autenticacao = new AutenticacaoHandler();
        Handler saldo = new SaldoHandler();
        Handler limite = new LimiteDiarioHandler();

        autenticacao.setProximo(saldo);
        saldo.setProximo(limite);

        // Executa as validações encadeadas
        if (!autenticacao.handle(req)) {
            return "Operação bloqueada por segurança.";
        }

        // Utiliza o padrão Proxy para proteger a lógica sensível da operação
        ServicoBancario servico = new ServicoBancarioProxy(cliente);
        servico.realizarOperacao(tipo, valor);

        return "Operação realizada com sucesso.";
    }
}
