package com.welltestedlearning.kiosk;

public class Burger extends Quantifiable implements MenuItem {

  public static final String BURGER_CHEESE = "cheeseburger";
  public static final String BURGER_REGULAR = "regular";

  private String burgerType;

  public Burger(String newBurgerType) {
    burgerType = newBurgerType;
  }

  public Burger(String newBurgerType, int newQuantity) {
    burgerType = newBurgerType;
    quantity = newQuantity;
  }

  public Burger(BurgerOption burgerOption) {
    burgerType = burgerOption.name().toLowerCase();
  }

  @Override
  public int basePrice() {
    if (burgerType.equals(BURGER_REGULAR)) {
      return 5;
    } else if (burgerType.equals(BURGER_CHEESE)) {
      return 6;
    }
    return 0;
  }

  public void display() {
    System.out.println("Burger: " + burgerType);
  }

  @Override
  public String toString() {
    return "Burger{" +
        "burgerType='" + burgerType + '\'' +
        '}';
  }
}
