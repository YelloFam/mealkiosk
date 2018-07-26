package com.welltestedlearning.kiosk;

import java.util.ArrayList;
import java.util.List;

public class MealOrder {
  private List<MenuItem> items = new ArrayList<>();

  public static MealOrder createBurgerOnlyOrder(BurgerOption burgerOption) {
    return new MealOrder(burgerOption);
  }

  public static void main(String[] args) {
    MealOrder drinkOrder = new MealOrder();
    drinkOrder.addDrink(Drink.DRINK_LARGE);
    drinkOrder.display();

    MealOrder burgerOrder = createBurgerOnlyOrder(BurgerOption.REGULAR);
    burgerOrder.display();
  }

  public MealOrder() {
  }

  public MealOrder(BurgerOption burger) {
    addBurger(burger.name().toLowerCase());
  }

  public void addDrink(String drinkType) {
    items.add(new Drink(drinkType));
  }


  public void addBurger(String burgerType) {
    items.add(new Burger(burgerType));
  }

  public MealOrder(String burgerType) {
    addBurger(burgerType);
  }

  public MealOrder(String burgerType, String drinkSize) {
    addBurger(burgerType);
    addDrink(drinkSize);
  }

  public MealOrder(BurgerOption burger,
                   DrinkOption drink) {
    addBurger(burger.name().toLowerCase());
    addDrink(drink.name().toLowerCase());
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
}

