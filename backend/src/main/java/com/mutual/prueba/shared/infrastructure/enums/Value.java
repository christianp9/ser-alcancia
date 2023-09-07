package com.mutual.prueba.shared.infrastructure.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Value {

  CINCUENTA(50d),
  CIEN(100d),
  DOCIENTOS(200d),
  QUINIENTOS(500d),
  MIL(1000d);

  private Double value;

  Value(Double value) {
    this.value = value;
  }

  public static Optional<Value> finById(Double value) {
    return Value.getValues().stream().filter(value1 -> value1.value.equals(value)).findFirst();
  }

  public static List<Value> getValues() {
    return Arrays.asList(CINCUENTA, CIEN, DOCIENTOS, QUINIENTOS, MIL);
  }
}
