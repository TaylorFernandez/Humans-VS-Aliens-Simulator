package commands;

import environment.Environment;
import gameUI.GameUI;

public class FaceWestCommand implements Commands {
  private Environment environment;

  public FaceWestCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    GameUI ui = environment.getGameUI();
    
    if (environment.getLifeForm(row, col) != null) {
      environment.getLifeForm(row, col).setDirection(3);
      if(ui != null) {
        ui.drawCell(row, col);
      }
    }
  }
}
