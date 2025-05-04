package com.example.Banco.pattern.proxy;

import com.example.Banco.model.Cliente;

/**
 * Proxy que controla o acesso ao serviço bancário real.
 *
 * Só permite a execução da operação se o cliente estiver autenticado.
 */
public class ServicoBancarioProxy implements ServicoBancario {

    private final Cliente cliente;
    private final ServicoBancario servicoReal;

    public ServicoBancarioProxy(Cliente cliente) {
        this.cliente = cliente;
        this.servicoReal = new ServicoBancarioReal();
    }

    @Override
    public void realizarOperacao(String tipo, double valor) {
        if (cliente.isAutenticado()) {
            System.out.println("[LOG] Cliente " + cliente.getNome() + " autorizado.");
            servicoReal.realizarOperacao(tipo, valor);
        } else {
            System.out.println("[LOG] Cliente " + cliente.getNome() + " não autenticado. Operação bloqueada.");
        }
    }
}
