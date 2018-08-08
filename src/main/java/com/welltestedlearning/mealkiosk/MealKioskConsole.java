package com.welltestedlearning.mealkiosk;

import java.util.Scanner;

public class MealKioskConsole {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Drink size? (regular, large): ");
    String inputSize = scanner.nextLine();
    inputSize = inputSize.toLowerCase();

    Drink drink;
    if (inputSize.equals("regular")) {
      drink = new Drink(Drink.DRINK_REGULAR);
    } else if (inputSize.equals("large")) {
      drink = new Drink(Drink.DRINK_LARGE);
    } else {
      throw new DrinkSizeNotValidException("Don't know the Drink Size: '" + inputSize + "'");
    }

    System.out.println("Here's your drink: " + drink + ", which costs $" + drink.price());
  }
}
