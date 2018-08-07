package com.welltestedlearning.mealkiosk;

public enum BurgerOption {
  CHEESEBURGER(6),
  REGULAR(5),
  BACONCHEESEBURGER(8)
  ;
  
  private final int price;
  
  private BurgerOption(int thePrice) {
    price = thePrice;
  }
  
  public int price() {
    return price;
  }
}
