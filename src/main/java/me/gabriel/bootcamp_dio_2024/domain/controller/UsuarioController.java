package me.gabriel.bootcamp_dio_2024.domain.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.gabriel.bootcamp_dio_2024.domain.model.Usuario;
import me.gabriel.bootcamp_dio_2024.domain.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

  // o final implica na injeção de dependência manual do UsuarioService, por isso passo ele como parametro no construtor da classe UsuarioController. Por isso não utilizo o "@Autowired"

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService){
    this.usuarioService = usuarioService;
  }

  @GetMapping("/{id}") // path parameter
  public ResponseEntity<Usuario> procurarPorId(@PathVariable Long id){
    var usuario = usuarioService.procurarPorId(id);
    return ResponseEntity.ok(usuario);
  }

  @PostMapping 
  public ResponseEntity<Usuario> criar(@RequestBody Usuario usuarioParaCriar){ 
    var usuarioCriado = usuarioService.criar(usuarioParaCriar);
    // Em Api Rest, além de retornar o usuário criado e importante também retornar a localização dele (localização do recurso), por isso a implementação abaixo:
    URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioCriado.getId()).toUri();
    return ResponseEntity.created(local).body(usuarioCriado);
  }

  
}
