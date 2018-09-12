package com.welltestedlearning.mealkiosk.api;

import com.welltestedlearning.mealkiosk.domain.MealOrder;

public class MealOrderResponse {
  private int price;
  private String id;

  public static MealOrderResponse from(MealOrder mealOrder) {
    MealOrderResponse mealOrderResponse = new MealOrderResponse();
    mealOrderResponse.setPrice(mealOrder.price());
    mealOrderResponse.setId(mealOrder.getId().toString());
    return mealOrderResponse;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
