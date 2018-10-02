package com.welltestedlearning.mealkiosk.domain;

public class Burger implements MenuItem {

  public static final int BURGER_BASE_PRICE = 5;

  private Toppings burgerToppings = new Toppings();

  public Burger() {
  }

  public Burger(BurgerTopping theBurgerTopping) {
    addTopping(theBurgerTopping);
  }

  public Burger(Toppings toppings) {
    burgerToppings = toppings;
  }

  @Override
  public int price() {
    return BURGER_BASE_PRICE + burgerToppings.price();
  }

  public void addTopping(BurgerTopping topping) {
    burgerToppings.addTopping(topping);
  }

  public String display() {
    return "Burger: " + burgerToppings.display();
  }

  @Override
  public String toString() {
    return "Burger {" +
        "burgerToppings=" + burgerToppings +
        '}';
  }
}
