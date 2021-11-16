package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.EnvironmentException;
import exceptions.WeaponException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.MockGenericWeapon;
import weapon.Pistol;
import weapon.PowerBooster;

public class TestCommands {
  
  @Test
  public void testAttack() throws WeaponException, EnvironmentException, AttachmentException {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm("Bob", 20);
    LifeForm lf2 = new MockLifeForm("John", 40);
    environment.addLifeForm(lf, 1, 2);
    environment.addLifeForm(lf2, 1, 3);
    PowerBooster gun = new PowerBooster(new Pistol());
    lf.pickUpWeapon(gun);
    lf.setDirection(2);
    AttackCommand a = new AttackCommand(environment);
    a.execute();
//    lf.attack(lf2, (int) environment.getDistance(lf, lf2));
    assertEquals(22, lf2.getCurrentLifePoints());
  }
  
  @Test
  public void testReload() {
    
  }
}

