package com.generateToken.generateToken.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
  private int statusCode;
  private String message;

  public ApiResponse(T data) {
    this.statusCode = 200;
    this.message = "Successfully registered"; // Default success status code
  }

  public ApiResponse(T data, int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getMessage() {
    return message;
  }
}
