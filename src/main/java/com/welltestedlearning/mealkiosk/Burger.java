package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

  private BurgerToppings burgerOption;

  public Burger() {
  }

  public Burger(BurgerToppings theBurgerOption) {
    burgerOption = theBurgerOption;
  }

  @Override
  public int price() {
    if (burgerOption == null) {
      return 5;
    }
   return 5 + burgerOption.price();
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
