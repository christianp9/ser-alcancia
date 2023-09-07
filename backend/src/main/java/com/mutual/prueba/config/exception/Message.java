package com.mutual.prueba.config.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp = LocalDateTime.now();

  public Message(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
