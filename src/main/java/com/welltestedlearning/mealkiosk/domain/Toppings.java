package com.welltestedlearning.mealkiosk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Toppings implements Displayable {

  private List<BurgerTopping> toppings = new ArrayList<>();

  public int price() {
    int toppingsPrice = 0;
    for (BurgerTopping topping : toppings) {
      toppingsPrice = toppingsPrice + topping.price();
    }
    return toppingsPrice;
  }

  public void addTopping(BurgerTopping burgerTopping) {
    toppings.add(burgerTopping);
  }

  @Override
  public String display() {
    if (toppings.isEmpty()) {
      return "none";
    }

//    String join = String.join(", ",
//                              toppings.stream()
//                                      .map(bt -> (bt.name().toLowerCase()))
//                                      .collect(Collectors.toList()));

//    new StringJoiner(", ").add();

    return toppings.stream()
                   .map(BurgerTopping::name)
                   .map(String::toLowerCase)
                   .collect(Collectors.joining(", "));
//
//
//    String toppingString = "";
//    for (int i = 0; i < toppings.size(); i++) {
//      toppingString += toppings.get(i).toString().toLowerCase();
//      toppingString += ", ";
//    }
//
//    for (BurgerTopping burgerTopping: toppings) {
//      toppingString += burgerTopping.toString().toLowerCase() + ", ";
//    }
//
//    return toppingString.substring(0, toppingString.length() - 2);
  }

  @Override
  public String toString() {
    return "Toppings{" +
        "toppings=" + toppings +
        '}';
  }

  public List<BurgerTopping> items() {
    return new ArrayList<>(toppings);
  }
}
