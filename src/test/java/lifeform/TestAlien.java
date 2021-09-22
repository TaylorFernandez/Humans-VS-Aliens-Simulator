package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.RecoveryRateException;
import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;

public class TestAlien {

  @Test
  public void testInitialization() {
    Alien allen;
    allen = new Alien("Allen", 25);
    assertEquals("Allen", allen.getName());
    assertEquals(25, allen.getMaxLifePoints());
  }

  @Test
  public void testHurtAlien() throws RecoveryRateException {
    Alien allen;
    allen = new Alien("Allen", 10, new RecoveryLinear(3));
    allen.takeHit(5);
    allen.recover();
    assertEquals(8, allen.getCurrentLifePoints());
  }
}

//@Test
//public void testUninitialized() {
//  try {
//    Temperature t = new Temperature();
//    t.getCelsius();
//    fail();
//  } catch (TemperatureException e) {
//    //This is expected
//  }
//}
