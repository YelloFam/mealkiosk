package com.welltestedlearning.mealkiosk;

public class ChickenSandwich {

  public static final int BASE_SANDWICH_PRICE = 6;

  private boolean spicy;

  public ChickenSandwich(boolean isSpicy) {
    spicy = isSpicy;
  }

  public ChickenSandwich() {
    spicy = true;
  }

  public int price() {
    return BASE_SANDWICH_PRICE;
  }

  public boolean isSpicy() {
    return spicy;
  }

}
