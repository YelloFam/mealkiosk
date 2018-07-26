import com.welltestedlearning.kiosk.Burger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class BurgerTest {

  @Test
  public void regularBurgerCosts5() throws Exception {
    Burger burger = new Burger(Burger.BURGER_REGULAR);
    int price = burger.price();
    assertThat(price)
              .isEqualTo(5);
  }

  @Test
  public void cheeseburgerCosts6() throws Exception {
    Burger burger = new Burger(Burger.BURGER_CHEESE);
    assertEquals(6, burger.price());
  }

  @Test
  public void threeBurgersCost15() throws Exception {
    Burger burger = new Burger(Burger.BURGER_REGULAR, 3);
    int price = burger.price();
    assertEquals(15, price);
  }

  @Test
  public void negativeBurgerIsNegative() throws Exception {
    Burger burger = new Burger(Burger.BURGER_REGULAR, -1);
    assertEquals(-5, burger.price());
  }
}