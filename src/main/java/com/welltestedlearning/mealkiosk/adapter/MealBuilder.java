package com.welltestedlearning.mealkiosk.adapter;

import com.welltestedlearning.mealkiosk.domain.Burger;
import com.welltestedlearning.mealkiosk.domain.BurgerTopping;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.Toppings;

public class MealBuilder {

  private String burgerOrder;

  public void addBurgerString(String burgerOrderString) {
    burgerOrder = burgerOrderString;
  }

  public MealOrder build() {
    Toppings toppings = parseToppings(burgerOrder);

    Burger burger = new Burger(toppings);

    MealOrder mealOrder = new MealOrder();
    mealOrder.addItem(burger);

    return mealOrder;
  }

  public static Toppings parseToppings(String order) {
    order = order.trim();
    if (order.isEmpty()) {
      throw new InvalidOrderTextException("Order string can't be empty.");
    }

    Toppings toppings = new Toppings();

    String[] toppingArray = order.split(",");

    for (String s : toppingArray) {
      String toppingString = s.trim();
      if (!toppingString.equals("none")) {
        BurgerTopping burgerTopping = parseTopping(toppingString);
        toppings.addTopping(burgerTopping);
      }
    }

    return toppings;
  }

  private static BurgerTopping parseTopping(String toppingString) {
    try {
      return BurgerTopping.valueOf(toppingString.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new InvalidOrderTextException("Topping '" + toppingString + "' is not a valid topping.");
    }
  }
}
