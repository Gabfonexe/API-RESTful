package me.gabriel.bootcamp_dio_2024.domain.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabriel.bootcamp_dio_2024.domain.model.Usuario;
import me.gabriel.bootcamp_dio_2024.domain.repository.UsuarioRepository;
import me.gabriel.bootcamp_dio_2024.domain.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{


  private final UsuarioRepository usuarioRepository;


  public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public Usuario procurarPorId(Long id) {
    return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }


  @Override
  public Usuario criar(Usuario usuarioParaCriar) {
    if (usuarioParaCriar.getId() != null && usuarioRepository.existsById(usuarioParaCriar.getId())){
      throw new IllegalArgumentException("Esse ID de usuário já existe");
    }
    return usuarioRepository.save(usuarioParaCriar);
  }

}
