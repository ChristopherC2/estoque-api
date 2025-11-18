package com.example.estoque_api.controller;

import com.example.estoque_api.model.response.EstoqueResponse;
import com.example.estoque_api.service.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
@Tag(name = "Estoque", description = "Operações de consulta de estoque")
public class EstoqueController {

    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consulta o estoque de um produto pelo ID",
            description = "Retorna informações do estoque, incluindo quantidade disponível e status."
    )
    public ResponseEntity<EstoqueResponse> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarEstoque(id));
    }
}