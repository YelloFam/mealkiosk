package com.welltestedlearning.mealkiosk.adapter.api;

import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.FakeMealOrderRepository;
import com.welltestedlearning.mealkiosk.domain.KitchenService;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.MealOrderRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealOrderApiControllerTest {

  private static final KitchenService DUMMY_KITCHEN_SERVICE = new FakeKitchenService();

  @Test
  public void getReturnsExistingMealOrderById() throws Exception {
    // Given: a repository with a meal order saved
    MealOrderRepository mealOrderRepository = new FakeMealOrderRepository();
    MealOrder mealOrder = MealBuilder.builder().burger("cheese").build();
    MealOrder savedMealOrder = mealOrderRepository.save(mealOrder);

    // And: an API Controller with the repository
    MealOrderApiController controller =
        new MealOrderApiController(mealOrderRepository, DUMMY_KITCHEN_SERVICE);

    // When: we do a GET for the ID
    Long savedMealOrderId = savedMealOrder.getId();
    MealOrderResponse response = controller.findMealOrder(savedMealOrderId);

    // Then: we expect the response to have the same ID and price
    assertThat(response.getId())
        .isEqualTo(savedMealOrderId.toString());
    assertThat(response.getPrice())
        .isEqualTo(mealOrder.price());
  }

  @Test
  public void mealOrderIsStoredInRepository() throws Exception {
    MealOrderRepository mealOrderRepository = new FakeMealOrderRepository();

    MealOrderRequest mealOrderRequest = new MealOrderRequest();
    mealOrderRequest.setBurger("none");

    MealOrderApiController controller = new MealOrderApiController(mealOrderRepository,
                                                                   DUMMY_KITCHEN_SERVICE);
    MealOrderResponse response = controller.mealOrder(mealOrderRequest);

    assertThat(mealOrderRepository.findAll())
        .hasSize(1);
  }

  @Test
  public void mealOrderBurgerCheeseWithLargeDrinkIs8Dollars() {
    MealOrderRequest mealOrderRequest = new MealOrderRequest();
    mealOrderRequest.setBurger("cheese"); // $6
    mealOrderRequest.setDrinkSize("large"); // $2

    MealOrderApiController controller = new MealOrderApiController(
        new FakeMealOrderRepository(), DUMMY_KITCHEN_SERVICE);
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
    MealOrderApiController controller = new MealOrderApiController(
        new FakeMealOrderRepository(), DUMMY_KITCHEN_SERVICE);
    MealOrderResponse response = controller.mealOrder(mealOrderRequest);

    // Then assertThat the response has the right price
    assertThat(response.getPrice())
        .isEqualTo(10);
  }
}