package com.mutual.prueba.infrastructure.controller.dto;

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
public class MoneyGroupByValueRestDto {

  private Double quantity;
  private Double denomination;
  private Double moneyByDenomination;

}
