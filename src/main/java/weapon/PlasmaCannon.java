//Taylor Fernandez

package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon{
  
  //Constructor for the Plasma Cannon
  public PlasmaCannon() {
    baseDamage = 50;
    maxRange = 40;
    rateOfFire = 1;
    maxAmmo = 4;
    shotsLeft = rateOfFire;
    currentAmmo = maxAmmo;
  }

  /**
   * method that calculated damage dealt to a LifeForm.
   * Calculates damage. Damage decreases as currentAmmo decreases.
   * returns 0 when distance is greater than maxRange and throws an exception when there is a negative distance
   * @param distance - distance between the shooter and target
   */
  @Override
  public int fire(int distance) throws WeaponException {
    if(distance < 0) {
      throw new WeaponException("Negative Shooting Distance");
    }
    if(distance <= maxRange) {
      double temp = baseDamage * (currentAmmo / maxAmmo);
      int damage = (int) Math.floor(temp);
      return damage;
    }
    return 0;
    
  }

  /**
   * returns the weapon and its attachments as a string
   */
  @Override
  public String toString() {
    return "PlasmaCannon";
  }

}