package commands;

import environment.Environment;
import gameUI.GameUI;

public class FaceEastCommand implements Commands {
  private Environment environment;

  public FaceEastCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    GameUI ui = environment.getGameUI();
    
    if (environment.getLifeForm(row, col) != null) {
      environment.getLifeForm(row, col).setDirection(1);
      if(ui != null) {
        ui.drawCell(row, col);
      }
    }
  }
}
