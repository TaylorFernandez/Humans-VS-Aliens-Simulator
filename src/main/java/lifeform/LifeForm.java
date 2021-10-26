package lifeform;

import exceptions.WeaponException;
import weapon.Weapon;

public abstract class LifeForm {
  String name;
  int points;
  int attack;
  protected Weapon weapon;
  int row;
  int col;

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
   * sets the location of the LifeForm
   */
  public void setLocation(int rowPos, int colPos) {
    row = rowPos;
    col = colPos;
  }
  
  /**
   * gets the column of the LifeForm
   */
  public int getCol() {
    return col;
  }
  
  /**
   * gets the row of the LifeForm
   * @return
   */
  public int getRow() {
    return row;
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
    return name;
  }

  /**
   * 
   * @return the points
   */
  public int getCurrentLifePoints() {
    return points;
  }

  /**
   * hits an enity
   * 
   * @param damage
   */
  public void takeHit(int damage) {
    if (getCurrentLifePoints() - damage < 0) {
      points = 0;
    } else if (points - damage >= 0) {
      points = getCurrentLifePoints() - damage;
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
   * @param entity is the target
   */
  public void attack(LifeForm entity) {
    if (getCurrentLifePoints() > 0) {
      entity.takeHit(getAttackStrength());
    }
  }

  /**
   * attacks
   * 
   * @param opponent
   * @throws WeaponException
   */
  public void attack(LifeForm opponent, int distance) throws WeaponException {
    if (points > 0) {
      if (!hasWeapon() || weapon.getCurrentAmmo() <= 0) {
        if (distance <= 5) {
          opponent.takeHit(getAttackStrength());
        }
      } else {
        opponent.takeHit(weapon.fire(distance));
      }
    }
  }

  /**
   * Method allows LifeForm to pick up weapons
   * 
   * @param w - weapon intended to be picked up
   */

  public boolean pickUpWeapon(Weapon w) {
    if (!hasWeapon()) {
      weapon = w;
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * allows the LifeForm to drop a weapon
   */
  public Weapon dropWeapon() {
    if (hasWeapon()) {
      Weapon oldWeapon = weapon;
      weapon = null;
      return oldWeapon;
    }
    return null;
  }

  /**
   * Returns true if the caller has a weapon
   */
  public boolean hasWeapon() {
    if (weapon == null) {
      return false;
    }
    return true;
  }
}
