package me.gabriel.bootcamp_dio_2024.domain.service;

import me.gabriel.bootcamp_dio_2024.domain.model.Usuario;

public interface UsuarioService {
// faço essa interface para realizar o encapsulamento da userserviimpl

  Usuario procurarPorId(Long id);

  Usuario criar(Usuario usuarioParaCriar);

  
  
}
