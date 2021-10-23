package environment;

import java.util.ArrayList;

import exceptions.EnvironmentException;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A Cell that can hold a LifeForm
 * 
 * @author lh2565
 *
 */
public class Cell {
  ArrayList<Weapon> weapons = new ArrayList<Weapon>();
  LifeForm being;
  boolean bool;

  /**
   * @return the LifeForm in this Cell.
   */
  public LifeForm getLifeForm() {
    return being;
  }
  
  /**
   * adds weapon to the ArrayList
   * 
   * @param weapon - weapon being added
   */
  
  public void addWeapon(Weapon w) throws EnvironmentException{
    if(weapons.size() < 2) {
       weapons.add(w);
    }else {
      throw new EnvironmentException("Can't have more than two weapons on a cell");
     }
  }
  
  
  /**
   * gets the first weapon in the ArrayList
   * 
   *@returns firstWeapon
   */
   public Weapon getWeapon1() {
     return weapons.get(0);
   }
   
   /**
    * gets the second weapon in the ArrayList
    * 
    * @return second Weapon
    */
   
   public Weapon getWeapon2() {
     return weapons.get(1);
   }
   
   /**
    * gets the number of weapons in the cell
    * 
    * @return number of Weapons
    */
   
   public int getWeaponsCount() {
     return weapons.size();
   }
   
   public void removeWeapon(Weapon w) {
     weapons.remove(w);
   }
  /**
   * Treis to add the LifeForm to the Cell. Will not add if a LifeFrom is already
   * present.
   * 
   * @param entity
   * @return true if the LifeForm was added to the Cell, false otherwise
   */
  public boolean addLifeForm(LifeForm entity) {
    if (being == null) {
      being = entity;
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }

  public void removeLifeForm() {
    being = null;
    bool = false;
  }
}
