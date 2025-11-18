package com.example.estoque_api.model.response;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        Double preco,
        Integer quantidadeEstoque
) {}