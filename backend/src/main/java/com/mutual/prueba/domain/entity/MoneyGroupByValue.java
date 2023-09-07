package com.mutual.prueba.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MoneyGroupByValue {

  private Double quantity;
  private Double denomination;
  private Double moneyByDenomination;

}
