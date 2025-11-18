package com.example.estoque_api.service;

import com.example.estoque_api.model.response.EstoqueResponse;
import com.example.estoque_api.model.response.ProdutoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EstoqueService {

    private final WebClient produtoWebClient;

    public EstoqueService(WebClient produtoWebClient) {
        this.produtoWebClient = produtoWebClient;
    }

    public ProdutoResponse buscarProduto(Long id) {
        return produtoWebClient
                .get()
                .uri("/produtos/{id}", id)
                .retrieve()
                .bodyToMono(ProdutoResponse.class)
                .block();
    }

    public EstoqueResponse consultarEstoque(Long id) {
        try {
            var produto = buscarProduto(id);
            boolean abaixo = produto.quantidadeEstoque() < 10;

            return new EstoqueResponse(
                    produto.id(),
                    produto.nome(),
                    produto.quantidadeEstoque(),
                    abaixo ? "O estoque está abaixo do limite mínimo (10)" : "OK"
            );
        } catch (Exception e) {
            return new EstoqueResponse(
                    id,
                    "Produto indisponível",
                    0,
                    "Não foi possível consultar o estoque (erro: " + e.getMessage() + ")"
            );
        }
    }
}
