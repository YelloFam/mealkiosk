package com.welltestedlearning.mealkiosk.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerTest {

  @Test
  public void burgerWithNoToppingsCosts5() throws Exception {
    Burger burger = new Burger();

    int price = burger.price();

    assertThat(price)
              .isEqualTo(5);
  }

  @Test
  public void cheeseburgerCosts6() throws Exception {
    Burger burger = new Burger();
    burger.addTopping(BurgerTopping.CHEESE);

    assertThat(burger.price())
              .isEqualTo(6);
  }

  @Test
  public void regularBurgerWithAvocadoCosts8() throws Exception {
    Burger burger = new Burger(BurgerTopping.AVOCADO);

    assertThat(burger.price())
              .isEqualTo(8);
  }

  @Test
  public void baconBurgerCosts7() throws Exception {
    Burger burger = new Burger();
    burger.addTopping(BurgerTopping.BACON);

    assertThat(burger.price())
        .isEqualTo(7);
  }

  @Test
  public void baconCheeseburgerCosts8() throws Exception {
    Burger burger = new Burger();
    burger.addTopping(BurgerTopping.BACON);
    burger.addTopping(BurgerTopping.CHEESE);

    assertThat(burger.price())
            .isEqualTo(8);
  }

  @Test
  public void burgerWithMultipleToppingsCheeseBaconCosts8() throws Exception {
    Toppings toppings = new Toppings();
    toppings.addTopping(BurgerTopping.BACON);
    toppings.addTopping(BurgerTopping.CHEESE);
    Burger burger = new Burger(toppings);

    assertThat(burger.price())
        .isEqualTo(8);
  }
}