package com.mutual.prueba.infrastructure.mapper;

import com.mutual.prueba.domain.entity.Money;
import com.mutual.prueba.infrastructure.dto.MoneyDto;
import com.mutual.prueba.shared.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper
public interface MoneyMapper extends EntityMapper<MoneyDto, Money> {

}
