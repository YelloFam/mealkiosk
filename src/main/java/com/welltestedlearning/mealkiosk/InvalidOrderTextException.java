package com.welltestedlearning.mealkiosk;

public class InvalidOrderTextException extends RuntimeException {
  public InvalidOrderTextException(String message) {
    super(message);
  }

  public InvalidOrderTextException(String message, Throwable cause) {
    super(message, cause);
  }
}
