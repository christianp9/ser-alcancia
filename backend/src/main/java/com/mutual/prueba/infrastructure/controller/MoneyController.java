package com.mutual.prueba.infrastructure.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.mutual.prueba.application.MoneyApplicationService;
import com.mutual.prueba.infrastructure.controller.dto.MoneyGroupByValueRestDto;
import com.mutual.prueba.infrastructure.controller.dto.MoneyRequestDto;
import com.mutual.prueba.infrastructure.mapper.MoneyGroupByValueMapper;
import com.mutual.prueba.infrastructure.mapper.MoneyRequestMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/money", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoneyController {


  private final MoneyApplicationService moneyApplicationService;
  private final MoneyRequestMapper moneyRequestMapper;
  private final MoneyGroupByValueMapper moneyGroupByValueMapper;

  @PostMapping("/")
  public ResponseEntity<Object> save(@RequestBody MoneyRequestDto money) {
     moneyApplicationService.save(moneyRequestMapper.toEntity(money));
     return new ResponseEntity<>(CREATED);
  }

  @GetMapping("/canitdadMonedas")
  public ResponseEntity<Integer>  findAllQuantity() {
    return new ResponseEntity<>(moneyApplicationService.findAllQuantity(),OK);
  }

  @GetMapping("canitdadDinero")
  public ResponseEntity<Double> findAllValue() {
    return new ResponseEntity<>(moneyApplicationService.findAllValue(),OK);
  }

  @GetMapping("/canitdadMonedasTipos/{value}")
  public ResponseEntity<Integer> findQuantityByValue(@PathVariable Double value) {
    return new ResponseEntity<>(moneyApplicationService.findQuantityByValue(value),OK);
  }

  @GetMapping("/canitdadDineroTipos/{value}")
  public ResponseEntity<Double> findValue(@PathVariable Double value) {
    return new ResponseEntity<>(moneyApplicationService.findValue(value),OK);
  }

  @GetMapping("/groupByValue")
  public ResponseEntity<List<MoneyGroupByValueRestDto>> groupByValue() {
    List<MoneyGroupByValueRestDto> moneyGroupByValueRestDtos = moneyGroupByValueMapper.toDto(moneyApplicationService.groupByValue());
    if (moneyGroupByValueRestDtos.isEmpty()){
      return new ResponseEntity<>(moneyGroupByValueRestDtos,NO_CONTENT);
    }
    return new ResponseEntity<>(moneyGroupByValueRestDtos,OK);
  }
}
