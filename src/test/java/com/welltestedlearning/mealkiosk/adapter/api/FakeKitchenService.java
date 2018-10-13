package com.welltestedlearning.mealkiosk.adapter.api;

import com.welltestedlearning.mealkiosk.domain.KitchenService;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class FakeKitchenService implements KitchenService {
  @Override
  public Long sendOrder(MealOrder mealOrder) {
    System.out.println("Order sent:");
    mealOrder.display();
    return 1L;
  }

  @Override
  public String statusFor(Long orderNumber) {
    return "COOKING";
  }
}