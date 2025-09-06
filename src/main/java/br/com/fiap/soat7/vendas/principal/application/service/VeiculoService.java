package br.com.fiap.soat7.vendas.principal.application.service;

import br.com.fiap.soat7.vendas.principal.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.principal.domain.entity.VeiculoEntity;
import br.com.fiap.soat7.vendas.principal.domain.model.Veiculo;
import br.com.fiap.soat7.vendas.principal.infrastructure.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VeiculoService implements VeiculoUseCase {

    private final VeiculoRepository repository;

    @Override
    public Veiculo createVeiculo(Veiculo veiculo) {
        VeiculoEntity entity = new VeiculoEntity();
        entity.setAno(veiculo.getAno());
        entity.setCor(veiculo.getCor());
        entity.setPreco(veiculo.getPreco());
        entity.setStatus("estoque");
        entity.setMarca(veiculo.getMarca());
        entity.setModelo(veiculo.getModelo());
        return this.toModel(repository.save(entity));
    }

    @Override
    public Veiculo getVeiculo(Long id) {
        return this.toModel(Objects.requireNonNull(repository.findById(id).orElse(null)));
    }

    @Override
    public List<Veiculo> listVeiculos() {
        return repository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public void removeVeiculo(Long id) {
        repository.deleteById(id);
    }

    public Veiculo editVeiculo(Long id, Veiculo updatedVeiculo) {
        Optional<VeiculoEntity> existingVeiculo = repository.findById(id);
        if (existingVeiculo.isPresent()) {
            VeiculoEntity entity = existingVeiculo.get();
            entity.setAno(updatedVeiculo.getAno());
            entity.setCor(updatedVeiculo.getCor());
            entity.setPreco(updatedVeiculo.getPreco());
            entity.setStatus(updatedVeiculo.getStatus());
            entity.setMarca(updatedVeiculo.getMarca());
            entity.setModelo(updatedVeiculo.getModelo());
            return this.toModel(repository.save(entity));
        }
        return null;
    }

    private Veiculo toModel(VeiculoEntity entity){
        Veiculo veiculo = new Veiculo();
        veiculo.setId(entity.getId());
        veiculo.setAno(entity.getAno());
        veiculo.setPreco(entity.getPreco());
        veiculo.setCor(entity.getCor());
        veiculo.setModelo(entity.getModelo());
        veiculo.setMarca(entity.getMarca());
        veiculo.setStatus(entity.getStatus());
        return veiculo;
    }
}
