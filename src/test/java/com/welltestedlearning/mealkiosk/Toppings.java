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

  public void add(BurgerTopping burgerTopping) {
    toppings.add(burgerTopping);
  }
}
