package com.mutual.prueba.config.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@ControllerAdvice
@RestControllerAdvice
public class GlobalRestExceptionHandler {

  @ExceptionHandler(ErrorException.class)
  public ResponseEntity<ApiError> resolveErrorException(HttpServletRequest request,
      HttpServletResponse response, ErrorException e) {
    log.error(e.getMessage(), e);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ApiError.builder().code(e.getCode()).message(e.getMessage()).build());
  }

  @ExceptionHandler(RestException.class)
  public ResponseEntity<ApiError> resolveRestException(HttpServletRequest request,
      HttpServletResponse response, RestException e) {
    log.error(e.getMessage(), e);
    return ResponseEntity.status(e.getStatus()).body(
        ApiError.builder().code(e.getCode()).message(e.getMessage()).errors(e.getErrors()).build());
  }
}
