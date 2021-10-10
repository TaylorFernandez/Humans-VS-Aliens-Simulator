package weapon;

import exceptions.WeaponException;

public abstract class GenericWeapon extends java.lang.Object implements Weapon {
  protected int baseDamage;
  protected int currentAmmo;
  protected int maxAmmo;
  protected int maxRange;
  protected int rateOfFire;
  protected int shotsLeft;
  
  public GenericWeapon(){
  }
  
  public abstract int fire(int distance) throws WeaponException;
  
  public abstract java.lang.String toString();
  
  public int getNumAttachments() {
    return 0;
  }
  
  public void reload() {
    currentAmmo = maxAmmo;
  }
  
  public int getBaseDamage() {
    return baseDamage;
  }
  
  public int getMaxRange() {
    return maxRange;
  }
  
  public int getRateOfFire() {
    return rateOfFire;
  }
  
  public int getMaxAmmo() {
    return maxAmmo;
  }
  
  public int getCurrentAmmo() {
    return currentAmmo;
  }
  
  public int getShotsLeft() {
    return shotsLeft;
  }
  
  public void updateTime(int time) {
    
  }
}
