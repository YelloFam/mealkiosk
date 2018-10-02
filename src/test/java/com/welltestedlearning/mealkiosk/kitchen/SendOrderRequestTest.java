package com.welltestedlearning.mealkiosk.kitchen;

import com.welltestedlearning.mealkiosk.domain.Burger;
import com.welltestedlearning.mealkiosk.domain.BurgerTopping;
import com.welltestedlearning.mealkiosk.domain.Drink;
import com.welltestedlearning.mealkiosk.domain.Fries;
import com.welltestedlearning.mealkiosk.domain.MenuItem;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SendOrderRequestTest {
  @Test
  public void menuItemsTransformedToListOfStrings() throws Exception {
    List<MenuItem> menuItems =
        Arrays.asList(new Drink(Drink.DRINK_LARGE),
                      new Fries(Fries.LARGE),
                      new Burger(BurgerTopping.AVOCADO));

    List<String> strings = SendOrderRequest.toStrings(menuItems);

    assertThat(strings)
        .hasSize(3)
        .containsExactlyInAnyOrder(
            "Drink: large",
            "Fries: large",
            "Burger: avocado");
  }
}