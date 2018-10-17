package com.welltestedlearning.mealkiosk.domain;

import java.util.List;

public interface MealOrderRepository {
  List<MealOrder> findAll();

  MealOrder findOne(Long id);

  MealOrder save(MealOrder mealOrder);
}
