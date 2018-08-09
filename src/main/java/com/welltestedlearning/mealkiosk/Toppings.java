package com.welltestedlearning.mealkiosk;

import java.util.ArrayList;
import java.util.List;

public class Toppings {

  private List<BurgerTopping> toppings = new ArrayList<>();

  public int price() {
    int toppingsPrice = 0;
    for (BurgerTopping topping : toppings) {
      toppingsPrice = toppingsPrice + topping.price();
    }
    return toppingsPrice;
  }

  public void addTopping(BurgerTopping burgerTopping) {
    toppings.add(burgerTopping);
  }

  @Override
  public String toString() {
    return "Toppings{" +
        "toppings=" + toppings +
        '}';
  }

  public List<BurgerTopping> items() {
    return new ArrayList<>(toppings);
  }
}
