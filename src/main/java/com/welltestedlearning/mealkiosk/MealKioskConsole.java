package com.welltestedlearning.mealkiosk;

import java.util.Scanner;

public class MealKioskConsole {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Burger: none/cheese/bacon/avocado? ");
    String order = scanner.nextLine();

    MealBuilder mealBuilder = new MealBuilder();
    mealBuilder.addBurgerString(order);

    MealOrder mealOrder = mealBuilder.build();
    mealOrder.display();
  }
}
