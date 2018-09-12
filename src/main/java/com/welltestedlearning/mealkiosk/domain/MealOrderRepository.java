package com.welltestedlearning.mealkiosk.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MealOrderRepository {

  private Map<Long, MealOrder> mealOrderMap = new HashMap<>();
  private AtomicLong counter = new AtomicLong(0);

  public MealOrderRepository() {
  }

  public MealOrderRepository(MealOrder mealOrder) {
    save(mealOrder);
  }

  public List<MealOrder> findAll() {
    return new ArrayList<>(mealOrderMap.values());
  }

  public MealOrder findOne(Long id) {
    MealOrder mealOrder = mealOrderMap.get(id);
    if (mealOrder == null) {
      throw new IllegalArgumentException();
    }
    return mealOrder;
  }

  public MealOrder save(MealOrder mealOrder) {
    assignId(mealOrder);
    mealOrderMap.put(mealOrder.getId(), mealOrder);
    return mealOrder;
  }

  private void assignId(MealOrder mealOrder) {
    if (mealOrder.getId() == null) {
      mealOrder.setId(counter.getAndIncrement());
    }
  }
}
