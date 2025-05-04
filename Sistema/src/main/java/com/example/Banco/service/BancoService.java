package com.example.Banco.service;

import com.example.Banco.dto.OperacaoDTO;
import com.example.Banco.model.Cliente;
import com.example.Banco.pattern.facade.BancoFacade;
import com.example.Banco.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável por processar operações bancárias.
 * Utiliza a fachada BancoFacade para aplicar regras de negócio.
 */
@Service
@RequiredArgsConstructor
public class BancoService {

    private final ClienteRepository clienteRepository;
    private final BancoFacade bancoFacade;

    /**
     * Realiza uma operação de saque.
     *
     * @param dto DTO com ID do cliente e valor do saque
     * @return Resposta HTTP com mensagem de sucesso ou erro
     */
    public ResponseEntity<String> sacar(OperacaoDTO dto) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(dto.getClienteId());

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            String resultado = bancoFacade.executarOperacao("Saque", dto.getValor(), cliente);
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Cliente não encontrado.");
        }
    }
}
