package com.welltestedlearning.mealkiosk.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealOrderTest {

  @Test
  public void emptyMealIsZeroPrice() throws Exception {
    MealOrder mealOrder = new MealOrder();

    assertThat(mealOrder.price()).isZero();
  }

  @Test
  public void mealWithRegularBurgerAndRegularFriesIs8() throws Exception {
    MealOrder mealOrder = new MealOrder();
    mealOrder.addBurger();
    mealOrder.addFries(Fries.REGULAR);

    assertThat(mealOrder.price()).isEqualTo(8);
  }

  @Test
  public void mealWithCheeseBurgerIs6() throws Exception {
    MealOrder mealOrder = new MealOrder();
    mealOrder.addBurger(BurgerTopping.CHEESE);

    mealOrder.display();

    assertThat(mealOrder.price()).isEqualTo(6);
  }

  @Test
  public void mealWithRegularBurgerLargeDrinkCosts7() throws Exception {
    MealOrder mealOrder = new MealOrder();
    mealOrder.addBurger();
    mealOrder.addDrink(Drink.DRINK_LARGE);

    assertThat(mealOrder.price()).isEqualTo(7);
  }

}
