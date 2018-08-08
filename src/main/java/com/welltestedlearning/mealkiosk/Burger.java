package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

  public static final int BURGER_BASE_PRICE = 5;

  private Toppings burgerToppings = new Toppings();

  public Burger() {
  }

  public Burger(BurgerTopping theBurgerTopping) {
    addTopping(theBurgerTopping);
  }

  @Override
  public int price() {
    return BURGER_BASE_PRICE + burgerToppings.price();
  }

  public void addTopping(BurgerTopping topping) {
    burgerToppings.addTopping(topping);
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
