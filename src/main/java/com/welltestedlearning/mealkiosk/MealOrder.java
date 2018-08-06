package com.welltestedlearning.mealkiosk;

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

  public MealOrder(BurgerOption burgerOption) {
    addBurger(burgerOption);
  }

  public void addDrink(String drinkSize) {
    items.add(new Drink(drinkSize));
  }

  public void addFries(String friesSize) {
    items.add(new Fries(friesSize));
  }

  public void addBurger(BurgerOption burgerOption) {
    items.add(new Burger(burgerOption));
  }

  public MealOrder(BurgerOption burger,
                   DrinkOption drink) {
    addBurger(burger);
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

