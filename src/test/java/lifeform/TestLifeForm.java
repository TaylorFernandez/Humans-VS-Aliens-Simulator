package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests that functionality provided by the LifefForm class
 * 
 * @author lh2565
 *
 */
public class TestLifeForm {
  /**
   * When a LifeForm is created, it should know its name and how many life points
   * it has.
   */
  @Test
  public void testInitialization() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
    assertEquals(40, entity.getCurrentLifePoints());
  }
  @Test
  public void testTakeHit() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
    entity.takeHit(10);
    assertEquals(30, entity.getCurrentLifePoints());
  }
}
