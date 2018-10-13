package com.welltestedlearning.mealkiosk.adapter.api;

import com.welltestedlearning.mealkiosk.domain.MealOrder;

public class MealOrderResponse {
  private int price;
  private String id;
  private String status;
  private Long orderNumber;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public static MealOrderResponse from(MealOrder mealOrder) {
    MealOrderResponse mealOrderResponse = new MealOrderResponse();

    mealOrderResponse.setPrice(mealOrder.price());
    mealOrderResponse.setId(mealOrder.getId().toString());
    mealOrderResponse.setOrderNumber(mealOrder.orderNumber());

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
