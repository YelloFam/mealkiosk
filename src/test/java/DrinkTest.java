import com.welltestedlearning.kiosk.Drink;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

  @Test
  public void drinkSizeOfRegularReturns1() throws Exception {
    Drink drink = new Drink(Drink.DRINK_REGULAR);
    assertEquals(1, drink.price());
  }

  @Test
  public void drinkSizeOfLargeReturns2() throws Exception {
    Drink drink = new Drink(Drink.DRINK_LARGE);
    assertEquals(2, drink.price());
  }

}
