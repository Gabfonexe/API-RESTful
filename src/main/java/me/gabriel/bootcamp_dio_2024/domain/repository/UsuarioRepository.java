package me.gabriel.bootcamp_dio_2024.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.gabriel.bootcamp_dio_2024.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  
}
