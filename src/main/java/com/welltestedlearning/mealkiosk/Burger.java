package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

  private BurgerOption burgerOption;

  public Burger() {
    burgerOption = BurgerOption.REGULAR;
  }

  public Burger(BurgerOption theBurgerOption) {
    burgerOption = theBurgerOption;
  }

  @Override
  public int price() {
    if (burgerOption != null) {
       return burgerOption.price();
    }
    return 0;
  }

  public void display() {
    System.out.println("Burger: " + burgerOption);
  }

  @Override
  public String toString() {
    return "Burger {" +
        "burgerOption=" + burgerOption +
        '}';
  }
}
