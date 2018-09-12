package com.welltestedlearning.mealkiosk.api;

import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.MealOrderRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealOrderApiController {

  private MealOrderRepository mealOrderRepository;

  // We need this so that we're backward compatible with tests that use this constructor
  public MealOrderApiController() {
  }

  // This constructor supports "dependency injection": passing in the repo for the controller to use
  public MealOrderApiController(MealOrderRepository mealOrderRepository) {
    this.mealOrderRepository = mealOrderRepository;
  }

  //---- Controller methods ----

  @PostMapping("/api/mealorder")
  public MealOrderResponse mealOrder(@RequestBody MealOrderRequest mealOrderRequest) {

    MealBuilder mealBuilder = MealBuilder.builder();
    MealOrder mealOrder = mealOrderRequest.build(mealBuilder);

    int price = mealOrder.price();

    mealOrderRepository.save(mealOrder);

    MealOrderResponse mealOrderResponse = new MealOrderResponse();
    mealOrderResponse.setPrice(price);

    return mealOrderResponse;
  }

}
