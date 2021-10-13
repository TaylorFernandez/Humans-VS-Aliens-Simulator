package lifeform;

import exceptions.WeaponException;
import weapon.Weapon;

public abstract class LifeForm{
  String name;
  int points;
  int attack;
  protected Weapon weapon;

  /**
   * LifeForms
   * 
   * @param n name of life form
   * @param p points for life form constructor to create the lifeform with a name
   *          and amount of lifepoints.
   */
  public LifeForm(String n, int p) {
    name = n;
    points = p;
  }

  /**
   * constructor for lifeForm
   * 
   * @param n
   * @param p
   * @param attack
   */
  public LifeForm(String n, int p, int attack) {
    name = n;
    points = p;
    this.attack = attack;
  }

  /**
   * 
   * @return the name
   */
  public String getName() {
    /**
     * @return the name of the lifeform
     */
    return name;
  }

  /**
   * 
   * @return the points
   */
  public int getCurrentLifePoints() {
    /**
     * @return the number of life points
     */
    return points;
  }

  /**
   * hits an enity
   * 
   * @param damage
   */
  public void takeHit(int damage) {
    if (points - damage < 0) {
      points = 0;
    } else if (points - damage >= 0) {
      points -= damage;
    }
  }

  /**
   * 
   * @return attack strength
   */
  public int getAttackStrength() {
    return this.attack;
  }

  /**
   * attacks
   * 
   * @param opponent
   * @throws WeaponException 
   */
  public void attack(LifeForm opponent, int distance) throws WeaponException {
    if(weapon == null) {
      if (points <= 0) {
        attack = 0;
      } else {
        opponent.takeHit(this.attack);

      }
    }else {
      if(distance < weapon.getMaxRange() && distance > 5)
      {
        weapon.fire(distance);
      }else {
        opponent.takeHit(this.attack);
      }
    }
  }
  
  /**
   * Method allows LifeForm to pick up weapons
   * @param w - weapon intended to be picked up
   */
  
  public boolean pickUpWeapon(Weapon w) {
    if(weapon == null) {
      weapon = w;
      return true;
    }else {
      return false;
    }
  }
  
  public Weapon dropWeapon() {
    Weapon oldWeapon = weapon;
    weapon = null;
    return oldWeapon;
  }
}
