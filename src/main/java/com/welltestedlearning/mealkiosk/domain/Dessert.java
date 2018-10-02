package com.welltestedlearning.mealkiosk.domain;

public class Dessert implements MenuItem {
  @Override
  public int price() {
    return 1;
  }

  @Override
  public String display() {
    return "Dessert";
  }
}
