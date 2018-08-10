package com.welltestedlearning.mealkiosk.domain;

/**
 * A pre-defined meal that has a fixed price
 *
 */
public class SpecialMealOrder extends MealOrder {

  public SpecialMealOrder() {
    addBurger(BurgerTopping.CHEESE);
    addDrink(Drink.DRINK_LARGE);
    addFries(Fries.LARGE);
  }

  @Override
  public int price() {
    return 9;
  }
}
