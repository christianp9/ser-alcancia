package com.mutual.prueba.application.impl;

import com.mutual.prueba.application.MoneyApplicationService;
import com.mutual.prueba.config.exception.ErrorException;
import com.mutual.prueba.domain.entity.Money;
import com.mutual.prueba.domain.entity.MoneyGroupByValue;
import com.mutual.prueba.domain.service.MoneyService;
import com.mutual.prueba.shared.infrastructure.enums.Mensajes;
import com.mutual.prueba.shared.infrastructure.enums.Value;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyApplicationServiceImpl implements MoneyApplicationService {

  @Autowired
  private MoneyService moneyService;

  @Override
  public Money save(Money money) {
    valideValue(money.getValue());
    return moneyService.save(money);
  }

  @Override
  public Integer findAllQuantity() {
    return moneyService.findAllQuantity();
  }

  @Override
  public Double findAllValue() {
    return moneyService.findAllValue();
  }

  @Override
  public Integer findQuantityByValue(Double value) {
    valideValue(value);
    return moneyService.findQuantityByValue(value);
  }

  @Override
  public Double findValue(Double value) {
    valideValue(value);
    return moneyService.findValue(value);
  }

  private void valideValue(Double value) {
    Optional<Value> optionalValue = Value.finById(value);
    if (optionalValue.isEmpty()) {
      throw new ErrorException(Mensajes.MENSAJES_ERROR_VALOR_INVALIDO.getMensaje());
    }
  }

  @Override
  public List<MoneyGroupByValue> groupByValue(){
    List<Object[]> moneyGroup = moneyService.groupByValue();
   return  moneyGroup.stream()
        .map(obj -> new MoneyGroupByValue(((Number) obj[1]).doubleValue(),
            ((Number) obj[2]).doubleValue(),
            ((Number) obj[0]).doubleValue()))
        .collect(Collectors.toList());
  }
}
