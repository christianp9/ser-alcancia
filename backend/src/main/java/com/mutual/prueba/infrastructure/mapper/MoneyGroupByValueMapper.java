package com.mutual.prueba.infrastructure.mapper;

import com.mutual.prueba.domain.entity.MoneyGroupByValue;
import com.mutual.prueba.infrastructure.controller.dto.MoneyGroupByValueRestDto;
import com.mutual.prueba.shared.infrastructure.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper
public interface MoneyGroupByValueMapper extends EntityMapper<MoneyGroupByValueRestDto, MoneyGroupByValue> {

}
