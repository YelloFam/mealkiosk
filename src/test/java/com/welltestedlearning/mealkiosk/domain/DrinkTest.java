package com.welltestedlearning.mealkiosk.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkTest {

  @Test
  public void drinkSizeOfRegularReturns1() throws Exception {
    Drink drink = new Drink(Drink.DRINK_REGULAR);
    assertThat(drink.price())
        .isEqualTo(1);
  }

  @Test
  public void drinkSizeOfLargeReturns2() throws Exception {
    Drink drink = new Drink(Drink.DRINK_LARGE);
    assertThat(drink.price())
        .isEqualTo(2);
  }

}
