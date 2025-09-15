package br.com.fiap.soat7.vendas.principal.infrastructure.controller;

import br.com.fiap.soat7.vendas.principal.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.principal.domain.model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VeiculoControllerTest {

    @Mock
    private VeiculoUseCase service;

    @InjectMocks
    private VeiculoController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Veiculo veiculo = new Veiculo(1L, "Toyota", "Corolla", "2022", "Preto", BigDecimal.valueOf(100000), "Disponível");
        when(service.createVeiculo(veiculo)).thenReturn(veiculo);

        Veiculo result = controller.create(veiculo);

        assertEquals(veiculo, result);
        verify(service, times(1)).createVeiculo(veiculo);
    }

    @Test
    void testGet() {
        Veiculo veiculo = new Veiculo(1L, "Toyota", "Corolla", "2022", "Preto", BigDecimal.valueOf(100000), "Disponível");
        when(service.getVeiculo(1L)).thenReturn(veiculo);

        Veiculo result = controller.get(1L);

        assertEquals(veiculo, result);
        verify(service, times(1)).getVeiculo(1L);
    }

    @Test
    void testList() {
        List<Veiculo> veiculos = List.of(
                new Veiculo(1L, "Toyota", "Corolla", "2022", "Preto", BigDecimal.valueOf(100000), "Disponível"),
                new Veiculo(2L, "Honda", "Civic", "2021", "Branco", BigDecimal.valueOf(90000), "Disponível")
        );
        when(service.listVeiculos()).thenReturn(veiculos);

        List<Veiculo> result = controller.list();

        assertEquals(veiculos.size(), result.size());
        verify(service, times(1)).listVeiculos();
    }

    @Test
    void testUpdate() {
        Veiculo veiculo = new Veiculo(1L, "Toyota", "Corolla", "2022", "Preto", BigDecimal.valueOf(100000), "Disponível");
        when(service.editVeiculo(1L, veiculo)).thenReturn(veiculo);

        Veiculo result = controller.update(1L, veiculo);

        assertEquals(veiculo, result);
        verify(service, times(1)).editVeiculo(1L, veiculo);
    }

    @Test
    void testDelete() {
        controller.delete(1L);

        verify(service, times(1)).removeVeiculo(1L);
    }
}