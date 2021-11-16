package commands;

import environment.Environment;
import gameUI.GameUI;
import lifeform.LifeForm;
import weapon.Weapon;

public class PickWeaponOneCommand implements Commands {
  private Environment environment;

  public PickWeaponOneCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    LifeForm form = environment.getLifeForm(row, col);
    GameUI ui = environment.getGameUI();
    
    System.out.print("Weapon1");
    if (environment.getLifeForm(row, col) != null && environment.getWeapons(row, col).length == 1) {
      Weapon[] weapons = environment.getWeapons(row, col);
      Weapon pickUp = weapons[0];
      if (pickUp != null) {
        Weapon old = environment.getLifeForm(row, col).dropWeapon();
        environment.getLifeForm(row, col).pickUpWeapon(pickUp);
        environment.removeWeapon(pickUp, row, col);
        environment.addWeapon(old, row, col);
        ui.drawCell(form.getRow(), form.getCol());
        ui.drawUIText(form);
      }
    }
  }
}
