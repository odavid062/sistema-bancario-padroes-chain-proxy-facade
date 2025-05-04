package com.example.Banco.pattern.proxy;

/**
 * Implementação concreta do serviço bancário.
 *
 * Executa a operação sem aplicar validações ou regras de segurança.
 * A proteção de acesso é responsabilidade do proxy.
 */
public class ServicoBancarioReal implements ServicoBancario {

    @Override
    public void realizarOperacao(String tipo, double valor) {
        System.out.println("Operação '" + tipo + "' realizada no valor de R$" + valor);
    }
}
