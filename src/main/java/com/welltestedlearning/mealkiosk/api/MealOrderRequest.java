package com.welltestedlearning.mealkiosk.api;

import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.MealOrder;

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

  public String getFriesSize() {
    return friesSize;
  }

  public void setFriesSize(String friesSize) {
    this.friesSize = friesSize;
  }

  @Override
  public String toString() {
    return "MealOrderRequest{" +
        "burger='" + burger + '\'' +
        ", drinkSize='" + drinkSize + '\'' +
        ", friesSize='" + friesSize + '\'' +
        '}';
  }

  // Inversion of Control: lowers the "Connascence" (see http://connascence.io/)
  public MealOrder build(MealBuilder mealBuilder) {
    return mealBuilder
        .burger(burger)
        .drink(drinkSize)
        .fries(friesSize)
        .build();
  }
}
