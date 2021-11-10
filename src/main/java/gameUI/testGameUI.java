package gameUI;

import environment.Environment;
import exceptions.AttachmentException;
import lifeform.Alien;
import lifeform.Human;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Scope;
import weapon.Weapon;

public class testGameUI {

  public static void main(String[] args) throws AttachmentException {
   Environment env = Environment.getEnvironment(6,6);
   Weapon w1 = new Pistol();
   Weapon w2 = new ChainGun();
   Weapon w3 = new Scope(new PlasmaCannon());
   Weapon w4 = new PlasmaCannon();
   
   Human human = new Human("Bob", 100, 4);
   Alien alien = new Alien("Jim", 100);
   env.addLifeForm(human, 1,3);
   env.addLifeForm(alien, 1,2);
   
   alien.pickUpWeapon(w3);
   human.pickUpWeapon(w2);
   
   env.addWeapon(w1, 1, 0);
   env.addWeapon(w2, 1, 1);
   env.addWeapon(w4, 1, 2);
   env.addWeapon(w1, 1, 3);
   env.addWeapon(w2, 1, 3);
   
   GameUI ui = new GameUI(env.getNumRows(), env.getNumCols(), env);
       

  }

}
