package com.mutual.prueba.config.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("API Error Message")
public class ApiError<T> extends Message {

  public static final String API_ERROR_DEFAULT_CODE = "000000";

  @ApiModelProperty(name = "errors")
  @JsonProperty("errors")
  private T errors;

  @Builder
  public ApiError(String code, String message, T errors) {
    super(code, message);
    this.errors = errors;
  }
}
