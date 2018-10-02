package com.welltestedlearning.mealkiosk.domain;

public class Fries implements MenuItem {

  public static final String REGULAR = "regular";
  public static final String LARGE = "large";

  private final String size;

  // validate this
  public Fries(String friesSize) {
    size = friesSize;
  }

  @Override
  public String display() {
    return "Fries: " + size;
  }

  @Override
  public int price() {
      int price = 0;
      if (size.equals(REGULAR)) {
        price = 3;
      } else if (size.equals(LARGE)) {
        price = 5;
      }
      return price;
  }

}
