package com.welltestedlearning.mealkiosk.adapter.kitchen;

import com.welltestedlearning.mealkiosk.domain.Displayable;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.MenuItem;

import java.util.List;
import java.util.stream.Collectors;

public class SendOrderRequest {
  private static final String KIOSK_NAME = "TED";

  private String kioskName;
  private Long kioskId;
  private List<String> items;

  public static List<String> toStrings(List<MenuItem> menuItems) {
    return menuItems.stream()
                    .map(Displayable::display)
                    .collect(Collectors.toList());

//    List<String> strings = new ArrayList<>();
//    for (MenuItem menuItem: menuItems) {
//      strings.add(menuItem.display());
//    }
//    return strings;
  }

  public static SendOrderRequest from(MealOrder mealOrder) {
    SendOrderRequest sendOrderRequest = new SendOrderRequest();
    sendOrderRequest.setKioskId(mealOrder.getId());
    sendOrderRequest.setKioskName(KIOSK_NAME);
    sendOrderRequest.setItems(toStrings(mealOrder.menuItems()));
    return sendOrderRequest;
  }

  public String getKioskName() {
    return kioskName;
  }

  public void setKioskName(String kioskName) {
    this.kioskName = kioskName;
  }

  public Long getKioskId() {
    return kioskId;
  }

  public void setKioskId(Long kioskId) {
    this.kioskId = kioskId;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }
}
