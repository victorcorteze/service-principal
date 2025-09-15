package br.com.fiap.soat7.vendas.principal.infrastructure.repository;

import br.com.fiap.soat7.vendas.principal.domain.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
}
