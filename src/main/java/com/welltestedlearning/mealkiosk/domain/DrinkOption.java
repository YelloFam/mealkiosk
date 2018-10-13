package com.welltestedlearning.mealkiosk.domain;

public enum DrinkOption {
  REGULAR,
  LARGE;

  @Override
  public String toString() {
    String name = name().toLowerCase();
    return Character.toUpperCase(name.charAt(0)) + name.substring(1);
  }
}
