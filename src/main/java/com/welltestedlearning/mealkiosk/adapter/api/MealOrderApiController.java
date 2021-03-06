package com.welltestedlearning.mealkiosk.adapter.api;

import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.KitchenService;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.MealOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealOrderApiController {

  private KitchenService kitchenService;
  private MealOrderRepository mealOrderRepository;

  // We need this so that we're backward compatible with tests that use this constructor
  public MealOrderApiController() {
  }

  @Autowired  // if we keep the above default constructor,
  // @Autowired tells Spring to use this constructor
  public MealOrderApiController(MealOrderRepository mealOrderRepository,
      KitchenService kitchenService) {
    this.mealOrderRepository = mealOrderRepository;
    this.kitchenService = kitchenService;
  }


  //---- Controller methods ----

  @PostMapping("/api/mealorder")
  public MealOrderResponse mealOrder(@RequestBody MealOrderRequest mealOrderRequest) {

    MealBuilder mealBuilder = MealBuilder.builder();
    MealOrder mealOrder = mealOrderRequest.build(mealBuilder);

    MealOrder savedMealOrder = mealOrderRepository.save(mealOrder);

    Long orderNumber = kitchenService.sendOrder(savedMealOrder);
    savedMealOrder.updateOrderNumber(orderNumber);

    mealOrderRepository.save(mealOrder);

    return MealOrderResponse.from(savedMealOrder);
  }

  @GetMapping("/api/mealorder/{id}")
  public MealOrderResponse findMealOrder(@PathVariable("id") Long id) {
    MealOrder foundMealOrder;
    try {
      foundMealOrder = mealOrderRepository.findOne(id);
    } catch (IllegalArgumentException e) {
      throw new NoSuchOrderException();
    }

    MealOrderResponse response = MealOrderResponse.from(foundMealOrder);

    String status = kitchenService.statusFor(foundMealOrder.orderNumber());
    response.setStatus(status);

    return response;
  }

}
