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
@Entity(name = "tb_cartao")
public class Cartao {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true) // Significa que só pode haver 1 número de cartão para cada 
  private String numero;

  @Column(name = "limite_disponivel",scale = 13, precision = 2) // 11 inteiros e 2 decimais de precisão
  private BigDecimal limite;

}
