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

  @Test
  public void regularBurgerWithLargeFriesIs10Dollars() throws Exception {
    // Given a request...
    MealOrderRequest mealOrderRequest = new MealOrderRequest();
    mealOrderRequest.setBurger("none"); // $5
    mealOrderRequest.setFriesSize("large"); // $5

    // When calling controller.mealOrder
    MealOrderApiController controller = new MealOrderApiController();
    MealOrderResponse response = controller.mealOrder(mealOrderRequest);

    // Then assertThat the response has the right price
    assertThat(response.getPrice())
        .isEqualTo(10);
  }
}