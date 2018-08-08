package com.welltestedlearning.mealkiosk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChickenSandwichTest {
  @Test
  public void baseChickenSandwichCosts6() throws Exception {
    ChickenSandwich chickenSandwich = new ChickenSandwich();

    assertThat(chickenSandwich.price())
        .isEqualTo(6);
  }

  @Test
  public void chickenSandwichDefaultsToSpicy() throws Exception {
    ChickenSandwich chickenSandwich = new ChickenSandwich();

    assertThat(chickenSandwich.isSpicy())
        .isTrue();
  }

  @Test
  public void chickenSandwichCanBeNotSpicy() throws Exception {
    ChickenSandwich chickenSandwich = new ChickenSandwich(false);

    assertThat(chickenSandwich.isSpicy())
        .isFalse();
  }

}
