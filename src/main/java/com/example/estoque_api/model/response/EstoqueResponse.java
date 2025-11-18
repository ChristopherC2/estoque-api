package com.example.estoque_api.model.response;

public record EstoqueResponse(
        Long id,
        String nome,
        Integer quantidadeEstoque,
        String status
) {}