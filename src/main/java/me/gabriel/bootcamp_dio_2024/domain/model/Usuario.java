package me.gabriel.bootcamp_dio_2024.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_user")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @OneToOne(cascade = CascadeType.ALL) // Se o user for deletado, todas as suas contas também serão
  private Conta conta;

  @OneToOne(cascade = CascadeType.ALL)
  private Cartao cartao;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // o fetch eager significa que quando buscar um usuario, ele irá buscar uma lista de funcionalidades
  private List<Funcionalidade> funcionalidades;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Novidade> novidades;

  
}
