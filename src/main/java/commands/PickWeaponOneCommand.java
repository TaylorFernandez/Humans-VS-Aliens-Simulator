package commands;

import environment.Environment;
import weapon.Weapon;

public class PickWeaponOneCommand {
  private Environment environment;

  public PickWeaponOneCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    if (environment.getLifeForm(row, col) != null) {
      Weapon[] weapons = environment.getWeapons(row, col);
      Weapon pickUp = weapons[0];
      if (pickUp != null) {
        Weapon old = environment.getLifeForm(row, col).dropWeapon();
        environment.getLifeForm(row, col).pickUpWeapon(pickUp);
        environment.removeWeapon(pickUp, row, col);
        environment.addWeapon(old, row, col);
      }
    }
  }
}
