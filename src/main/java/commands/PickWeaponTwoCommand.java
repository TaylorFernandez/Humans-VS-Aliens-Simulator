package commands;

import environment.Environment;
import gameUI.GameUI;
import lifeform.LifeForm;
import weapon.Weapon;

public class PickWeaponTwoCommand implements Commands {
  private Environment environment;
  
  public PickWeaponTwoCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    LifeForm form = environment.getCell(row, col).getLifeForm();
    GameUI ui = environment.getGameUI();
    
    System.out.print("Weapon 2");
    if (environment.getLifeForm(row, col) != null && environment.getWeapons(row, col).length == 2) {
      Weapon[] weapons = environment.getWeapons(row, col);
      Weapon pickUp = weapons[1];
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