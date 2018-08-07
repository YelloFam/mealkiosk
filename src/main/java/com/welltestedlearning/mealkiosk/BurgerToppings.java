package com.welltestedlearning.mealkiosk;

public enum BurgerToppings {
  CHEESE(1),
  BACON(2),
  AVOCADO(3)
  ;

  private final int price;

  private BurgerToppings(int thePrice) {
    price = thePrice;
  }

  public int price() {
    return price;
  }
}
