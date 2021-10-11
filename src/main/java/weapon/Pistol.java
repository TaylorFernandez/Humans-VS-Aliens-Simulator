package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon {
  /**
   * Pistol
   */
  public Pistol() {
    baseDamage = 10;
    maxRange = 50;
    rateOfFire = 2;
    maxAmmo = 10;
    shotsLeft = rateOfFire;
    currentAmmo = maxAmmo;
  }
  
  @Override
  public int fire(int distance) throws WeaponException {
    
    if(distance < 0) {
      throw new WeaponException("negative Fire Distance");
    }
    
    //Check to see if the weapon can be fired again.
    if (shotsLeft <= 0 || currentAmmo <= 0) {
      return 0;
    }
    
    double temp = (double)baseDamage*(((double)maxRange - (double)distance + 10)/(double)maxRange);
    int damage = (int) Math.floor(temp);
    currentAmmo--;
    shotsLeft--;
    if(distance <= maxRange) {     
      return damage;
    } else {
      return 0;
    }
  }
  
  public java.lang.String toString()  {
    return null;
  }
}