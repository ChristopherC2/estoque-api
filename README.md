# Estoque API

API responsável por consultar o estoque de um produto  
comunicando-se com o serviço **produto-api**.

## 🛠 Tecnologias
- Java 17
- Spring Boot 3
- WebClient (Spring WebFlux)
- Spring Web

## 🔗 Funcionalidade

O serviço recebe o ID e consulta o serviço de produtos.

### Requisição:
**GET /estoque/{id}**

### Exemplo de resposta:
```json
{
  "id": 1,
  "nome": "Teclado Mecânico",
  "quantidadeEstoque": 3,
  "estoqueBaixo": true
}
```
📝 Observações

O estoque-api não possui banco.

Toda a informação vem da consulta ao produto-api.

Estrutura simples, focada em comunicação entre microserviços.
