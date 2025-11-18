package com.example.estoque_api.controller;

import com.example.estoque_api.model.response.EstoqueResponse;
import com.example.estoque_api.service.EstoqueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EstoqueControllerTest {
    @Mock
    private EstoqueService estoqueService;

    @InjectMocks
    private EstoqueController estoqueController;

    private EstoqueResponse estoqueResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        estoqueResponse = new EstoqueResponse(
                1L,
                "Produto Teste",
                5,
                "O estoque está abaixo do limite mínimo (10)"
        );
    }

    @Test
    void testConsultar() {

        when(estoqueService.consultarEstoque(1L)).thenReturn(estoqueResponse);

        ResponseEntity<EstoqueResponse> response = estoqueController.consultar(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(estoqueResponse, response.getBody());

        verify(estoqueService, times(1)).consultarEstoque(1L);
    }

}
