package com.welltestedlearning.mealkiosk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToppingsTest {
  @Test
  public void noToppingsIsZeroPrice() {
    Toppings toppings = new Toppings();

    assertThat(toppings.price())
        .isZero();
  }

  @Test
  public void baconAndCheeseCosts3() {
    Toppings toppings = new Toppings();
    toppings.addTopping(BurgerTopping.CHEESE);
    toppings.addTopping(BurgerTopping.BACON);

    assertThat(toppings.price())
        .isEqualTo(3);
  }
}