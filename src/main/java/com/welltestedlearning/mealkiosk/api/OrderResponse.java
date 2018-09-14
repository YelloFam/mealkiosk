package com.welltestedlearning.mealkiosk.api;

public class OrderResponse {
  private Long orderNumber; // This is the Kitchen's internal ID number
  private Long kioskId;     // This is your Meal Kiosk's MealOrder ID
  private String status;    // Current status of the order

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Long getKioskId() {
    return kioskId;
  }

  public void setKioskId(Long kioskId) {
    this.kioskId = kioskId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
