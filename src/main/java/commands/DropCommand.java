package commands;

import environment.Environment;
import gameUI.GameUI;
import gameUI.gameCell;
import lifeform.LifeForm;

public class DropCommand implements Commands {
  protected Environment environment;
  protected GameUI ui;

  public DropCommand(Environment env) {
    environment = env;
    ui = env.getGameUi();
  }
  
  /*
   * excecutes the drop command
   */
  public void execute() {
    if (ui.getHighlighted() != null) {
      gameCell cell = ui.getHighlighted();
      LifeForm form = environment.getCell(cell.getRow(), 
    		  cell.getCol()).getLifeForm();
      if (form.hasWeapon() == true && 
    		  environment.getCell(cell.getRow(), cell.getCol()).getWeaponsCount() < 2) {
        environment.dropWeapon(form, ui);
        if (ui != null) {
          ui.drawCell(form.getRow(), form.getCol());
          ui.drawUIText(form);
          ui.printStats(cell);
        }
      }
    }
  }
}
