package com.welltestedlearning.mealkiosk.api;

public class MealOrderRequest {
  private String burger;
  private String drinkSize;
  private String friesSize;

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

  public void setFriesSize(String friesSize) {
    this.friesSize = friesSize;
  }

  public String getFriesSize() {
    return friesSize;
  }

  @Override
  public String toString() {
    return "MealOrderRequest: " +
        "burger='" + burger + '\'' +
        ", drinkSize='" + drinkSize + '\'' +
        ", friesSize='" + friesSize + '\'';
  }
}
