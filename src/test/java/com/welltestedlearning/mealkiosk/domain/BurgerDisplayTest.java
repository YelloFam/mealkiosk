package com.welltestedlearning.mealkiosk.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerDisplayTest {
  @Test
  public void plainBurgerDisplaysCorrectly() throws Exception {
    Burger plainBurger = new Burger();
    assertThat(plainBurger.display())
        .isEqualTo("Burger: none");
  }

  @Test
  public void burgerWithCheeseDisplaysCorrectly() throws Exception {
    Burger cheeseBurger = new Burger(BurgerTopping.CHEESE);
    assertThat(cheeseBurger.display())
        .isEqualTo("Burger: cheese");
  }

  @Test
  public void burgerWithCheeseAndBaconDisplaysCorrectly() throws Exception {
    Toppings toppings = new Toppings();
    toppings.addTopping(BurgerTopping.CHEESE);
    toppings.addTopping(BurgerTopping.BACON);
    Burger baconCheeseBurger = new Burger(toppings);

    assertThat(baconCheeseBurger.display())
        .isEqualTo("Burger: cheese, bacon");
  }
}