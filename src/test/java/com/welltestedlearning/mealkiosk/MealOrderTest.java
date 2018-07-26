package com.welltestedlearning.mealkiosk;

import com.welltestedlearning.mealkiosk.Burger;
import com.welltestedlearning.mealkiosk.BurgerOption;
import com.welltestedlearning.mealkiosk.DrinkOption;
import com.welltestedlearning.mealkiosk.MealOrder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MealOrderTest {

  @Test
  public void mealWithRegularBurgerRegularDrinkCosts6() throws Exception {
    MealOrder mealOrder = new MealOrder(BurgerOption.REGULAR, DrinkOption.REGULAR);
    int price = mealOrder.price();
    assertEquals(6, price);
  }



  @Test
  public void mealWithBurgerAsEnum() throws Exception {
    MealOrder mealOrder = new MealOrder(BurgerOption.CHEESEBURGER);
    assertEquals(6, mealOrder.price());
  }


  @Test
  public void mealWithBurgerAsString() throws Exception {
    MealOrder mealOrder = new MealOrder(Burger.BURGER_REGULAR);
    assertEquals(5, mealOrder.price());
  }
}
