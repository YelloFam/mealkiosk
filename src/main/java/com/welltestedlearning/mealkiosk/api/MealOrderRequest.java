package com.welltestedlearning.mealkiosk.api;

public class MealOrderRequest {
  private String burger;
  private String drink;

  public String getBurger() {
    return burger;
  }

  public void setBurger(String burger) {
    this.burger = burger;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }
}
