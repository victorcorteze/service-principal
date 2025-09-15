package br.com.fiap.soat7.vendas.principal.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "veiculo")
@Entity
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    private BigDecimal preco;
    private String status;

}
