package com.example.Banco.controller;

import com.example.Banco.dto.OperacaoDTO;
import com.example.Banco.service.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável pelos endpoints relacionados a operações bancárias.
 */
@RestController
@RequestMapping("/api/banco")
@RequiredArgsConstructor
public class BancoController {

    private final BancoService bancoService;

    /**
     * Endpoint para realizar uma operação de saque.
     *
     * @param dto Dados da operação (clienteId e valor)
     * @return Resultado da operação (mensagem de sucesso ou erro)
     */
    @PostMapping("/sacar")
    public ResponseEntity<String> sacar(@RequestBody OperacaoDTO dto) {
        return bancoService.sacar(dto);
    }
}
