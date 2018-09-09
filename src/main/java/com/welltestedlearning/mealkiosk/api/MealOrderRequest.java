package com.welltestedlearning.mealkiosk.api;

public class MealOrderRequest {
  private String burger;
  private String drinkSize;

  public String getBurger() {
    return burger;
  }

  public void setBurger(String burger) {
    this.burger = burger;
  }

  public String getDrinkSize() {
    return drinkSize;
  }

  public void setDrinkSize(String drinkSize) {
    this.drinkSize = drinkSize;
  }

  @Override
  public String toString() {
    return "MealOrderRequest: " +
        "burger='" + burger + '\'' +
        ", drinkSize='" + drinkSize + '\'';
  }
}
