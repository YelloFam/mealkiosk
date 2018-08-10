package com.welltestedlearning.mealkiosk.console;

import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.MealOrder;

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
