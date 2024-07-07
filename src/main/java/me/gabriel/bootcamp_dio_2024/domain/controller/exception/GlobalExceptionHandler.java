package me.gabriel.bootcamp_dio_2024.domain.controller.exception;


import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import me.gabriel.bootcamp_dio_2024.domain.model.Usuario;
import me.gabriel.bootcamp_dio_2024.domain.service.UsuarioService;

@RestControllerAdvice
public class GlobalExceptionHandler {


  private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
  
  
  //Exception para caso tente criar uma conta de mesmo número
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){
    return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  //Exception para caso não ache o ID 
  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException){                  
    return new ResponseEntity<>("ID não encontrado", HttpStatus.NOT_FOUND);
                              //como não há uma msg definida no Service, definirei aqui
  }

  ///QualQuer Exception
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException){
    var msg = "Ocorreu um Erro Inesperado";
    logger.error(msg, unexpectedException);
    return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR); //COD 500
  }

}
