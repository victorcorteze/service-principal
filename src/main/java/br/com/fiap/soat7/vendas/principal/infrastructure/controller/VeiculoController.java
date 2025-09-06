package br.com.fiap.soat7.vendas.principal.infrastructure.controller;

import br.com.fiap.soat7.vendas.principal.application.port.usecase.VeiculoUseCase;
import br.com.fiap.soat7.vendas.principal.domain.model.Veiculo;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoUseCase service;

    public VeiculoController(VeiculoUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Veiculo create(@RequestBody Veiculo dto) {
        return service.createVeiculo(dto);
    }

    @GetMapping("/{id}")
    public Veiculo get(@PathVariable Long id) {
        return service.getVeiculo(id);
    }

    @GetMapping
    public List<Veiculo> list() {
        return service.listVeiculos()
                .stream()
                .sorted(Comparator.comparing(Veiculo::getPreco))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public Veiculo update(@PathVariable Long id,@RequestBody Veiculo dto) {
        return service.editVeiculo(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.removeVeiculo(id);
    }
}
