package com.welltestedlearning.mealkiosk.domain;

public class ChickenSandwich {

  public static final int BASE_SANDWICH_PRICE = 6;

  private boolean spicy;
  private Toppings toppings = new Toppings();

  public ChickenSandwich(boolean isSpicy) {
    spicy = isSpicy;
  }

  public ChickenSandwich() {
    spicy = true;
  }

  public int price() {
    return BASE_SANDWICH_PRICE + toppings.price();
  }

  public boolean isSpicy() {
    return spicy;
  }

  public void addTopping(BurgerTopping burgerTopping) {
    toppings.addTopping(burgerTopping);
  }
}
