package com.mutual.prueba.infrastructure.dto;

import com.mutual.prueba.shared.infrastructure.dto.BaseEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MoneyDto extends BaseEntity {

  private Double value;

}
