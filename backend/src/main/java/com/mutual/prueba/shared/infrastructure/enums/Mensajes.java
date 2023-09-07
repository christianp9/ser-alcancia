package com.mutual.prueba.shared.infrastructure.enums;

import lombok.Getter;

@Getter
public enum Mensajes {

  MENSAJES_ERROR_VALOR_INVALIDO("El valor ingresado es invalido");

  private String mensaje;

  Mensajes(String mensaje) {
    this.mensaje = mensaje;
  }

}
