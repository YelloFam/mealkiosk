package com.welltestedlearning.mealkiosk;

import com.welltestedlearning.mealkiosk.domain.Fries;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FriesTest {

  @Test
  public void smallFriesAre3() {
    Fries fries = new Fries(Fries.REGULAR);

    assertThat(fries.price())
        .isEqualTo(3);
  }

  @Test
  public void largeFriesAre5() {
    Fries fries = new Fries(Fries.LARGE);

    assertThat(fries.price())
        .isEqualTo(5);
  }

}
