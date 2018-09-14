package com.welltestedlearning.mealkiosk.api;

import com.welltestedlearning.mealkiosk.adapter.MealBuilder;
import com.welltestedlearning.mealkiosk.domain.MealOrder;
import com.welltestedlearning.mealkiosk.domain.MealOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MealOrderApiIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MealOrderRepository mealOrderRepository;

  @Test
  public void postCreatesNewMealOrder() throws Exception {
    mockMvc.perform(post("/api/mealorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"burger\": \"cheese\", \"drinkSize\": \"large\", \"friesSize\": \"regular\"}"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value("0"));
  }

  @Test
  public void getWithIdReturnsPriceAndId() throws Exception {
    MealOrder mealOrder = MealBuilder.builder().burger("cheese").build();
    mealOrder.setId(1L); // force id to be 1 for this test
    mealOrderRepository.save(mealOrder);

    mockMvc.perform(get("/api/mealorder/1"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(1))
           .andExpect(jsonPath("$.price").value("6"));
  }

  @Test
  public void getWithNonExistentIdReturnsNotFound() throws Exception {
    mockMvc.perform(get("/api/mealorder/999"))
           .andExpect(status().isNotFound());
  }
}