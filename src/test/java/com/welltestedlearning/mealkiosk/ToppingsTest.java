package com.welltestedlearning.mealkiosk;

import com.welltestedlearning.mealkiosk.domain.BurgerTopping;
import com.welltestedlearning.mealkiosk.domain.Toppings;
import org.junit.Test;

import java.util.List;

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

    List<BurgerTopping> items = toppings.items();
    assertThat(items)
        .containsExactlyInAnyOrder(BurgerTopping.CHEESE, BurgerTopping.BACON);
  }
}