package com.welltestedlearning.mealkiosk.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOptionTest {

  @Test
  public void enumToString() throws Exception {
    assertThat(DrinkOption.LARGE.toString())
        .isEqualTo("Large");
  }
}