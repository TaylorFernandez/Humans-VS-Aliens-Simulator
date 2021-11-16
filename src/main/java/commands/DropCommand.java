package commands;

import environment.Environment;
import gameUI.GameUI;
import gameUI.gameCell;
import lifeform.LifeForm;

public class DropCommand implements Commands{
  protected Environment environment;
  protected GameUI  ui;
    public DropCommand(Environment env, GameUI ui) {
      environment = env;
      this.ui = ui;
    }
        
    public void execute() {
      if(ui.getHighlighted() != null) {
        gameCell cell = ui.getHighlighted();
        LifeForm form = environment.getCell(cell.getRow(), cell.getCol()).getLifeForm();
        if(form.hasWeapon() == true) {
          environment.DropWeapon(form,  ui);
          ui.drawCell(form.getRow(), form.getCol());
          ui.drawUIText(form);
        }
      }
    }
}
