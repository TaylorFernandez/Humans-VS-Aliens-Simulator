package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestEnvironment {
  @Test
  public void testInitialization() {
    Environment environment = Environment.getEnvironment(1, 1);
  }

  @Test
  public void testAddLifeForm() {
    Environment environment = Environment.getEnvironment(2, 3);
    LifeForm lf = new MockLifeForm("Bob", 20);
    environment.addLifeForm(lf, 1, 2);
    assertEquals(lf, environment.getLifeForm(1, 2));
  }

  @Test
  public void testBorderOne() {
    Environment environment = Environment.getEnvironment(4, 6);
    LifeForm lf = new MockLifeForm("Bob", 50);
    environment.addLifeForm(lf, 1, 2);
    assertEquals(lf, environment.getLifeForm(1, 2));
  }

  @Test
  public void testBorderTwo() {
    Environment environment = Environment.getEnvironment(1, 1);
    LifeForm lf = new MockLifeForm("Bob", 70);
    environment.addLifeForm(lf, 0, 0);
    assertEquals(lf, environment.getLifeForm(0, 0));
  }

  @Test
  public void testRemoveLifeForm() {
    Environment environment = Environment.getEnvironment(2, 3);
    LifeForm lf = new MockLifeForm("Bob", 20);
    environment.addLifeForm(lf, 1, 2);
    assertEquals(lf, environment.getLifeForm(1, 2));
    environment.removeLifeForm(1, 2);
    assertEquals(null, environment.getLifeForm(1, 2));
  }
  
  @Test
  public void testSingleton() {
    MockLifeForm form1  = new MockLifeForm("Bob", 100);
    Environment env1 = Environment.getEnvironment(2,2);
    Environment env2 = Environment.getEnvironment(1,1);
    
    env1.addLifeForm(form1,  1, 1);
    
    assertEquals(env2.getLifeForm(1, 1), form1);
  }
}
