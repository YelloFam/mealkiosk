package com.welltestedlearning.mealkiosk.domain;

public interface KitchenService {
  Long sendOrder(MealOrder mealOrder);

  String statusFor(Long orderNumber);
}
