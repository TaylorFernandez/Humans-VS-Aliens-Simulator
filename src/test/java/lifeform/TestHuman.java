package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHuman {

  @Test
  public void testInitialization() {
    Human Doug;
    Doug = new Human("Doug", 50, 0);
    assertEquals("Doug", Doug.getName());
  }

  @Test
  public void testSetArmor() {
    Human Doug;
    Doug = new Human("Doug", 50, 0);
    Doug.setArmorPoints(100);
    assertEquals(100, Doug.getArmorPoints());
  }

  @Test
  public void testGetArmor() {
    Human Doug;
    Doug = new Human("Doug", 50, 0);
    Doug.setArmorPoints(100);
    assertEquals(100, Doug.getArmorPoints());
  }

  @Test
  public void testNegativeArmor() {
    Human Doug;
    Doug = new Human("Doug", 50, 0);
    Doug.setArmorPoints(-10);
    assertEquals(0, Doug.getArmorPoints());
  }
}
