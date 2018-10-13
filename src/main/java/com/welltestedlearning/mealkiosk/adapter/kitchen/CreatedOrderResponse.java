package com.welltestedlearning.mealkiosk.adapter.kitchen;

public class CreatedOrderResponse {
  private Long orderNumber;
  private Long kioskId;

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

}
