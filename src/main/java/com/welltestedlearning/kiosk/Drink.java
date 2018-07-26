package com.welltestedlearning.kiosk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Drink extends Quantifiable implements MenuItem {

  public static final String DRINK_REGULAR = "regular";
  public static final String DRINK_LARGE = "large";

  private String drinkSize = ""; // regular or large

  private static final Logger LOGGER = LoggerFactory.getLogger(Drink.class);

  public Drink() {
  }

  public Drink(String theDrinkSize) throws DrinkSizeNotValidException {
//    if (notValid(theDrinkSize)) {
//      throw new DrinkSizeNotValidException("Drink size is not valid: " + theDrinkSize);
//    }
    drinkSize = theDrinkSize;
  }

  private boolean notValid(String theDrinkSize) {
    return true;
  }

  @Override
  public int basePrice() {
    int price = 0;
    if (drinkSize.equals(DRINK_REGULAR)) {
      price = 1;
    } else if (drinkSize.equals(DRINK_LARGE)) {
      price = 2;
    }
    return price;
  }

  @Override
  public void display() {
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return "Drink Size: " + drinkSize;
  }
}
