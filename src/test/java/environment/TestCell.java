package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class
 * 
 * @author lh2565
 *
 */
public class TestCell {
  /**
   * As initialization, the Cell should be empty and not contain a LifeForm.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }

  @Test
  public void testAddLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empt so this hould fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }

  @Test
  public void testRemoveLifeForm() {
    LifeForm remove = new MockLifeForm("Lenny", 40);
    Cell cell = new Cell();
    boolean fail = cell.addLifeForm(remove);
    assertTrue(fail);
    cell.removeLifeForm();
    assertEquals(null, cell.getLifeForm());
    assertTrue(fail);
  }

  @Test
  public void testNoAdd() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }
}
