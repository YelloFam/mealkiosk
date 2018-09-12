package com.welltestedlearning.mealkiosk.api;

import com.welltestedlearning.mealkiosk.domain.MealOrderRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealOrderApiControllerTest {

  @Test
  public void mealOrderIsStoredInRepository() throws Exception {
    MealOrderRepository mealOrderRepository = new MealOrderRepository();

    MealOrderRequest mealOrderRequest = new MealOrderRequest();
    mealOrderRequest.setBurger("none");

    MealOrderApiController controller = new MealOrderApiController(mealOrderRepository);
    MealOrderResponse response = controller.mealOrder(mealOrderRequest);

    assertThat(mealOrderRepository.findAll())
        .hasSize(1);
  }

  @Test
  public void mealOrderBurgerCheeseWithLargeDrinkIs8Dollars() {
    MealOrderRequest mealOrderRequest = new MealOrderRequest();
    mealOrderRequest.setBurger("cheese"); // $6
    mealOrderRequest.setDrinkSize("large"); // $2

    MealOrderApiController controller = new MealOrderApiController(new MealOrderRepository());
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
    MealOrderApiController controller = new MealOrderApiController(new MealOrderRepository());
    MealOrderResponse response = controller.mealOrder(mealOrderRequest);

    // Then assertThat the response has the right price
    assertThat(response.getPrice())
        .isEqualTo(10);
  }
}