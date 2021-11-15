package commands;

import environment.Environment;
import gameUI.GameUI;

public class FaceNorthCommand implements Commands {
  private Environment environment;
  private GameUI ui;

  public FaceNorthCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    ui = environment.getGameUI();
    
    if (environment.getLifeForm(row, col) != null) {
      environment.getLifeForm(row, col).setDirection(0);
      ui.highlightPrediction();
    }
  }
}
