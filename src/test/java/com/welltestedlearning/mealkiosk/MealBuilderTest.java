package com.welltestedlearning.mealkiosk;

import com.welltestedlearning.mealkiosk.adapter.InvalidOrderTextException;
import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.BurgerTopping;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.Toppings;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.fail;

public class MealBuilderTest {

  @Test
  public void orderWithNoneStringCosts5() throws Exception {
    MealBuilder mealBuilder = new MealBuilder();
    mealBuilder.addBurgerString("none");

    MealOrder mealOrder = mealBuilder.build();

    assertThat(mealOrder.price())
        .isEqualTo(5);
  }

  @Test
  public void orderWithCheeseStringCosts6() throws Exception {
    MealBuilder mealBuilder = new MealBuilder();
    mealBuilder.addBurgerString("cheese");

    MealOrder mealOrder = mealBuilder.build();

    assertThat(mealOrder.price())
        .isEqualTo(6);
  }

  @Test
  public void orderWithBaconAndCheeseParsedInto2Toppings() throws Exception {
    String order = "bacon, cheese";
    Toppings toppings = MealBuilder.parseToppings(order);

    assertThat(toppings.items())
        .containsExactlyInAnyOrder(BurgerTopping.BACON, BurgerTopping.CHEESE);
  }

  @Test
  public void emptyOrderStringThrowsInvalidOrderException() throws Exception {
    try {
      MealBuilder.parseToppings("");
      fail("Expected exception to be thrown");
    } catch (InvalidOrderTextException e) {
      // test passed
    }
  }

  @Test
  public void invalidToppingThrowsInvalidOrderException() throws Exception {
    assertThatThrownBy(() -> {
      MealBuilder.parseToppings("chesee");
    })
    .isInstanceOf(InvalidOrderTextException.class)
    .hasMessage("Topping 'chesee' is not a valid topping.");

  }
}
