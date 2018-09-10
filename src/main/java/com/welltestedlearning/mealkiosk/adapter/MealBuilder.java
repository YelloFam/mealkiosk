package com.welltestedlearning.mealkiosk.adapter;

import com.welltestedlearning.mealkiosk.domain.Burger;
import com.welltestedlearning.mealkiosk.domain.BurgerTopping;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.Toppings;

public class MealBuilder {

  private String burgerOrder;
  private String drinkSize;
  private String friesSize;

  // factory method for the builder pattern
  public static MealBuilder builder() {
    return new MealBuilder();
  }

  // return the same instance to allow for chained/fluent method calls
  public MealBuilder burger(String burgerOrderString) {
    burgerOrder = burgerOrderString;
    return this;
  }

  public MealBuilder drink(String size) {
    drinkSize = size;
    return this;
  }

  public MealBuilder fries(String fries) {
    friesSize = fries;
    return this;
  }

  public MealOrder build() {
    Toppings toppings = parseToppings(burgerOrder);

    Burger burger = new Burger(toppings);

    MealOrder mealOrder = new MealOrder();
    mealOrder.addItem(burger);

    if (drinkSize != null) {
      mealOrder.addDrink(drinkSize);
    }

    if (friesSize != null) {
      mealOrder.addFries(friesSize);
    }

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
