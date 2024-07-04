package me.gabriel.bootcamp_dio_2024.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_conta")
public class Conta {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true) //  significa que a conta deve ter um número único
  private String numero;

  private String agencia;

  @Column(scale = 13, precision = 2) // 11 inteiros e 2 decimais de precisão
  private BigDecimal saldo;

  @Column(name = "limite_adicional", scale = 13, precision = 2)
  private BigDecimal limite;

}
