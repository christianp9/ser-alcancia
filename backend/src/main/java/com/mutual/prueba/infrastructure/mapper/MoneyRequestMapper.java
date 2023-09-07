package com.mutual.prueba.infrastructure.mapper;

import com.mutual.prueba.domain.entity.Money;
import com.mutual.prueba.infrastructure.controller.dto.MoneyRequestDto;
import com.mutual.prueba.shared.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper
public interface MoneyRequestMapper extends EntityMapper<MoneyRequestDto, Money> {

}
