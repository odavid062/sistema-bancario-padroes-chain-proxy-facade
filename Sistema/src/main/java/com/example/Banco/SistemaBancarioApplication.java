package com.example.Banco;

import com.example.Banco.model.Cliente;
import com.example.Banco.model.ContaBancaria;
import com.example.Banco.pattern.facade.BancoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação bancária.
 * Executa cenários de teste ao iniciar a aplicação.
 */
@SpringBootApplication
public class SistemaBancarioApplication implements CommandLineRunner {

	@Autowired
	private BancoFacade bancoFacade;

	public static void main(String[] args) {
		SpringApplication.run(SistemaBancarioApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Cenário 1: cliente autenticado com saldo suficiente
		ContaBancaria conta = new ContaBancaria();
		conta.setId(1L);
		conta.setSaldo(1200.0);

		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNome("João");
		cliente.setAutenticado(true);
		cliente.setConta(conta);

		String resultado1 = bancoFacade.executarOperacao("Saque", 800.0, cliente);
		System.out.println("[RESULTADO 1] " + resultado1);

		// Cenário 2: operação acima do limite diário
		String resultado2 = bancoFacade.executarOperacao("Saque", 1200.0, cliente);
		System.out.println("[RESULTADO 2] " + resultado2);

		// Cenário 3: cliente não autenticado
		cliente.setAutenticado(false);
		String resultado3 = bancoFacade.executarOperacao("Saque", 100.0, cliente);
		System.out.println("[RESULTADO 3] " + resultado3);
	}
}
