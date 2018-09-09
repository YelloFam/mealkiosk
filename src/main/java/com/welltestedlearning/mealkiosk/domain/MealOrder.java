package com.welltestedlearning.mealkiosk.domain;

import java.util.ArrayList;
import java.util.List;

public class MealOrder {
  private List<MenuItem> items = new ArrayList<>();


  public MealOrder() {
  }

  public MealOrder(BurgerTopping burgerOption) {
    addBurger(burgerOption);
  }

  public MealOrder(String drinkSize) {
    addDrink(drinkSize);
  }

  public MealOrder(BurgerTopping burger,
      DrinkOption drink) {
    addBurger(burger);
    addDrink(drink.name().toLowerCase());
  }

  public void addDrink(String drinkSize) {
    items.add(new Drink(drinkSize));
  }

  public void addFries(String friesSize) {
    items.add(new Fries(friesSize));
  }

  public void addBurger() {
    items.add(new Burger());
  }

  public void addBurger(BurgerTopping burgerOption) {
    items.add(new Burger(burgerOption));
  }

  public void addItem(MenuItem menuItem) {
    items.add(menuItem);
  }

  public int price() {
    // loop over all items and sum their price
    int price = 0;
    for (MenuItem item: items) {
      price = price + item.price();
    }
    return price;
  }

  public void display() {
    for (MenuItem item: items) {
       item.display();
    }
    System.out.println(price());
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("MealOrder: ");
    for (MenuItem item : items) {
      sb.append("->").append(item.toString());
    }
    sb.append(", $").append(price());
    return sb.toString();
  }

  public List<MenuItem> menuItems() {
    return items;
  }
}

