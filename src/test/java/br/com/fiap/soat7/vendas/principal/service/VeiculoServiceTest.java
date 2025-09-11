package br.com.fiap.soat7.vendas.principal.service;

import br.com.fiap.soat7.vendas.principal.application.service.VeiculoService;
import br.com.fiap.soat7.vendas.principal.domain.entity.VeiculoEntity;
import br.com.fiap.soat7.vendas.principal.domain.model.Veiculo;
import br.com.fiap.soat7.vendas.principal.infrastructure.repository.VeiculoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VeiculoServiceTest {

    @Mock
    private VeiculoRepository repository;

    @InjectMocks
    private VeiculoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateVeiculo() {
        Veiculo veiculo = new Veiculo(null, "Toyota", "Corolla", "2022", "Preto", BigDecimal.valueOf(100000), "estoque");
        VeiculoEntity entity = new VeiculoEntity();
        entity.setId(1L);
        entity.setAno("2022");
        entity.setCor("Preto");
        entity.setPreco(BigDecimal.valueOf(100000));
        entity.setStatus("estoque");
        entity.setMarca("Toyota");
        entity.setModelo("Corolla");

        when(repository.save(any(VeiculoEntity.class))).thenReturn(entity);

        Veiculo result = service.createVeiculo(veiculo);

        assertEquals(1L, result.getId());
        verify(repository, times(1)).save(any(VeiculoEntity.class));
    }

    @Test
    void testGetVeiculo() {
        VeiculoEntity entity = new VeiculoEntity();
        entity.setId(1L);
        entity.setAno("2022");
        entity.setCor("Preto");
        entity.setPreco(BigDecimal.valueOf(100000));
        entity.setStatus("estoque");
        entity.setMarca("Toyota");
        entity.setModelo("Corolla");

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        Veiculo result = service.getVeiculo(1L);

        assertEquals(1L, result.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testListVeiculos() {
        VeiculoEntity entity1 = new VeiculoEntity();
        entity1.setId(1L);
        entity1.setAno("2022");
        entity1.setCor("Preto");
        entity1.setPreco(BigDecimal.valueOf(100000));
        entity1.setStatus("estoque");
        entity1.setMarca("Toyota");
        entity1.setModelo("Corolla");

        VeiculoEntity entity2 = new VeiculoEntity();
        entity2.setId(2L);
        entity2.setAno("2021");
        entity2.setCor("Branco");
        entity2.setPreco(BigDecimal.valueOf(90000));
        entity2.setStatus("estoque");
        entity2.setMarca("Honda");
        entity2.setModelo("Civic");

        when(repository.findAll()).thenReturn(List.of(entity1, entity2));

        List<Veiculo> result = service.listVeiculos();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testRemoveVeiculo() {
        service.removeVeiculo(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testEditVeiculo() {
        VeiculoEntity entity = new VeiculoEntity();
        entity.setId(1L);
        entity.setAno("2022");
        entity.setCor("Preto");
        entity.setPreco(BigDecimal.valueOf(100000));
        entity.setStatus("estoque");
        entity.setMarca("Toyota");
        entity.setModelo("Corolla");

        Veiculo updatedVeiculo = new Veiculo(1L, "Toyota", "Corolla", "2023", "Azul", BigDecimal.valueOf(110000), "estoque");

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(any(VeiculoEntity.class))).thenReturn(entity);

        Veiculo result = service.editVeiculo(1L, updatedVeiculo);

        assertEquals("2023", result.getAno());
        assertEquals("Azul", result.getCor());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(VeiculoEntity.class));
    }
}
