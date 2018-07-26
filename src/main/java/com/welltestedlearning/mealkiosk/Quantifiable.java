package com.welltestedlearning.mealkiosk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Quantifiable {
  protected int quantity = 1;

  private static final Logger LOG = LoggerFactory.getLogger(Quantifiable.class);

  public int price() {
    LOG.info("Price with quantity {}", quantity);

    return basePrice() * quantity;
  }

  public abstract int basePrice();
}
