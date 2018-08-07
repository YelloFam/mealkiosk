package com.welltestedlearning.mealkiosk;

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
    Burger burger = new Burger(BurgerOption.CHEESEBURGER);

    assertThat(burger.price())
              .isEqualTo(6);
  }

  @Test
  public void baconCheeseburgerCosts8() throws Exception {
    Burger burger = new Burger(BurgerOption.BACONCHEESEBURGER);

    assertThat(burger.price())
            .isEqualTo(8);
  }

}