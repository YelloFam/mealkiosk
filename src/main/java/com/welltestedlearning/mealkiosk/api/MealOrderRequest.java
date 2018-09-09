package com.welltestedlearning.mealkiosk.api;

public class MealOrderRequest {
  private String burger;

  public String getBurger() {
    return burger;
  }

  public void setBurger(String burger) {
    this.burger = burger;
  }

  @Override
  public String toString() {
    return "MealOrderRequest: " +
        "burger='" + burger + '\'';
  }
}
