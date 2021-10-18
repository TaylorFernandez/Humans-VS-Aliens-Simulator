package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.TimerObserver;

//I think we should remove "extends java.lang.Object
//I don't that it does anything

public abstract class GenericWeapon extends java.lang.Object implements Weapon, TimerObserver {
  protected int baseDamage;
  protected int currentAmmo;
  protected int maxAmmo;
  protected int maxRange;
  protected int rateOfFire;
  protected int shotsLeft;
  
  public GenericWeapon(){
  }
  
  public abstract int fire(int distance) throws WeaponException;
  
  public abstract String toString();
  
  public int getNumAttachments() throws AttachmentException {
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
    shotsLeft = rateOfFire;
  }
}
