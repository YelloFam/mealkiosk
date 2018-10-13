package com.welltestedlearning.mealkiosk.adapter.printer;

import com.welltestedlearning.mealkiosk.domain.KitchenService;
import com.welltestedlearning.mealkiosk.domain.MealOrder;

public class PrinterKitchenService implements KitchenService {
  @Override
  public Long sendOrder(MealOrder mealOrder) {
    mealOrder.display();
    return null;
  }

  @Override
  public String statusFor(Long orderNumber) {
    return null;
  }
}
