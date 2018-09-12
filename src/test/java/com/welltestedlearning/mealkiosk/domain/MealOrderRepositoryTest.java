package com.welltestedlearning.mealkiosk.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MealOrderRepositoryTest {

  @Test
  public void findAllOnNewRepositoryReturnsEmptyList() throws Exception {
    MealOrderRepository mealOrderRepository = new MealOrderRepository();
    assertThat(mealOrderRepository.findAll())
        .isEmpty();
  }

  @Test
  public void findAllShouldReturn1MealOrder() {
    MealOrder mealOrder = new MealOrder();
    mealOrder.addBurger(BurgerTopping.CHEESE);
    mealOrder.setId(1L);

    MealOrderRepository mealOrderRepository = new MealOrderRepository(mealOrder);
    List<MealOrder> all = mealOrderRepository.findAll();
    assertThat(all)
        .hasSize(1);
    assertThat(all.get(0).getId())
        .isEqualTo(1L);
  }

  // First test for non-existent ID (method should return random object)
  @Test
  public void findOneShouldReturnNullForNonExistentId() throws Exception {
    MealOrderRepository mealOrderRepository = new MealOrderRepository();

    assertThatThrownBy(() -> {
      mealOrderRepository.findOne(999L);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void findOneShouldReturnOrderForExistingId() throws Exception {
    MealOrder mealOrder = new MealOrder();
    mealOrder.setId(1L);

    MealOrderRepository mealOrderRepository = new MealOrderRepository(mealOrder);

    MealOrder one = mealOrderRepository.findOne(1L);
    assertThat(one)
        .isNotNull();
    assertThat(one.getId())
        .isEqualTo(1L);
  }

  @Test
  public void saveNewMealOrderCanBeFoundByItsId() throws Exception {
    MealOrderRepository mealOrderRepository = new MealOrderRepository();

    MealOrder mealOrder = new MealOrder();

    MealOrder savedMealOrder = mealOrderRepository.save(mealOrder);

    assertThat(mealOrderRepository.findOne(savedMealOrder.getId()))
        .isNotNull();
  }

  @Test
  public void newlySavedMealOrdersHaveUniqueIds() {
    MealOrderRepository mealOrderRepository = new MealOrderRepository();

    MealOrder mealOrder1 = new MealOrder();
    MealOrder savedMealOrder1 = mealOrderRepository.save(mealOrder1);

    MealOrder mealOrder2 = new MealOrder();
    MealOrder savedMealOrder2 = mealOrderRepository.save(mealOrder2);

    assertThat(savedMealOrder1.getId())
        .isNotEqualTo(savedMealOrder2.getId());
  }

  @Test
  public void updateExistingMealOrderOverwritesPreviouslySavedOrder() throws Exception {
    MealOrderRepository mealOrderRepository = new MealOrderRepository();
    MealOrder mealOrder = new MealOrder();
    MealOrder savedMealOrder = mealOrderRepository.save(mealOrder);

    MealOrder newlySavedOrder = mealOrderRepository.save(savedMealOrder);

    assertThat(savedMealOrder.getId())
        .isEqualTo(newlySavedOrder.getId());
  }

}