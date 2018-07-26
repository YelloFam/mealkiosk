package com.welltestedlearning.kiosk;

public class DrinkSizeNotValidException extends RuntimeException {
  public DrinkSizeNotValidException(String message) {
    super(message);
  }

  public DrinkSizeNotValidException(String message, Throwable cause) {
    super(message, cause);
  }
}
