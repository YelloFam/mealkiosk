package com.welltestedlearning.mealkiosk;

import java.util.ArrayList;
import java.util.List;

public class Burger implements MenuItem {

  public static final int BURGER_BASE_PRICE = 5;

  private List<BurgerTopping> burgerToppings = new ArrayList<>();

  public Burger() {
  }

  public Burger(BurgerTopping theBurgerTopping) {
    addTopping(theBurgerTopping);
  }

  @Override
  public int price() {
    return BURGER_BASE_PRICE + calculateToppingsPrice();
  }

  private int calculateToppingsPrice() {
    int toppingsPrice = 0;
    // calculate sum of all toppings
    for (BurgerTopping topping : burgerToppings) {
      toppingsPrice = toppingsPrice + topping.price();
    }
    return toppingsPrice;
  }

  public void addTopping(BurgerTopping topping) {
    burgerToppings.add(topping);
  }

  public void display() {
    System.out.println("Burger: " + burgerToppings);
  }

  @Override
  public String toString() {
    return "Burger {" +
        "burgerToppings=" + burgerToppings +
        '}';
  }
}
