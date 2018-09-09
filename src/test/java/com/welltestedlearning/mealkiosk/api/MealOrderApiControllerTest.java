package com.welltestedlearning.mealkiosk.api;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealOrderApiControllerTest {

  @Test
  public void mealOrderBurgerCheeseWithLargeDrinkIs8Dollars() {
    MealOrderRequest mealOrderRequest = new MealOrderRequest();
    mealOrderRequest.setBurger("cheese"); // $6
    mealOrderRequest.setDrinkSize("large"); // $2

    MealOrderApiController controller = new MealOrderApiController();
    MealOrderResponse response = controller.mealOrder(mealOrderRequest);

    assertThat(response.getPrice())
        .isEqualTo(8);
  }
}