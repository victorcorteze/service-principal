package br.com.fiap.soat7.vendas.principal.application.port.usecase;

import br.com.fiap.soat7.vendas.principal.domain.model.Veiculo;

import java.util.List;

public interface VeiculoUseCase {

    Veiculo createVeiculo(Veiculo vehicle);
    Veiculo getVeiculo(Long id);
    List<Veiculo> listVeiculos();
    void removeVeiculo(Long id);
    Veiculo editVeiculo(Long id, Veiculo vehicle);

}
