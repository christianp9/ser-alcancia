package com.mutual.prueba.infrastructure.repository;

import com.mutual.prueba.infrastructure.dto.MoneyDto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository extends JpaRepository<MoneyDto, UUID> {

  @Query("select sum(m.value) from MoneyDto m")
  Optional<Double> valueAll();

  List<MoneyDto> findByValue(Double value);

  @Query("select sum(m.value) from MoneyDto m where m.value = ?1")
  Optional<Double> valueByMoneyValue(Double value);

  @Query("select sum(m.value),COUNT(m), m.value from MoneyDto m group by m.value ")
  List<Object[]> groupByValue();
}
