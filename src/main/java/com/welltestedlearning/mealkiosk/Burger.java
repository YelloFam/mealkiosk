package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

  private BurgerOption burgerOption;

  public Burger(BurgerOption theBurgerOption) {
    burgerOption = theBurgerOption;
  }

  @Override
  public int price() {
    if (burgerOption.equals(BurgerOption.REGULAR)) {
      return 5;
    } else if (burgerOption.equals(BurgerOption.CHEESEBURGER)) {
      return 6;
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
