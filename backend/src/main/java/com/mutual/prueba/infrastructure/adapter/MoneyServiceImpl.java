package com.mutual.prueba.infrastructure.adapter;

import com.mutual.prueba.domain.entity.Money;
import com.mutual.prueba.domain.service.MoneyService;
import com.mutual.prueba.infrastructure.mapper.MoneyMapper;
import com.mutual.prueba.infrastructure.repository.MoneyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService {

  @Autowired
  private MoneyRepository moneyRepository;
  @Autowired
  private MoneyMapper moneyMapper;

  @Override
  public Money save(Money money) {
    return moneyMapper.toEntity(moneyRepository.save(moneyMapper.toDto(money)));
  }

  @Override
  public Integer findAllQuantity() {
    return moneyRepository.findAll().size();
  }

  @Override
  public Double findAllValue() {
    Optional<Double> doubleOptional = moneyRepository.valueAll();
    if (doubleOptional.isEmpty()) {
      return 0d;
    }
    return doubleOptional.get();
  }

  @Override
  public Integer findQuantityByValue(Double value) {
    return moneyRepository.findByValue(value).size();
  }

  @Override
  public Double findValue(Double value) {
    Optional<Double> doubleOptional = moneyRepository.valueByMoneyValue(value);
    if (doubleOptional.isEmpty()) {
      return 0d;
    }
    return doubleOptional.get();
  }

  public List<Object[]> groupByValue(){
   return moneyRepository.groupByValue();
  }
}
