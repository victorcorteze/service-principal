package br.com.fiap.soat7.vendas.principal.domain.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    private BigDecimal preco;
    private String status;

}
