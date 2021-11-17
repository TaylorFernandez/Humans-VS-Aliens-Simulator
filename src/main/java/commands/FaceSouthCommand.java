package commands;

import environment.Environment;
import gameUI.GameUI;

public class FaceSouthCommand implements Commands {
  private Environment environment;

  public FaceSouthCommand(Environment e) {
    environment = e;
  }

  /*
   * excecutes the face south command
   */
  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    GameUI ui = environment.getGameUi();

    if (environment.getLifeForm(row, col) != null) {
      environment.getLifeForm(row, col).setDirection(2);
      if (ui != null) {
        ui.drawCell(row, col);
      }
    }
  }
}
