package commands;

import environment.Environment;
import gameUI.GameUI;
import gameUI.gameCell;

public class MoveCommand implements Commands {
  private Environment environment;
  gameCell cell;

  public MoveCommand(Environment e) {
    environment = e;
  }

  @Override
  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    GameUI ui = environment.getGameUI();
    if (ui != null) {
      cell = environment.getGameCell(row, col);
    }

    if (environment.getLifeForm(row, col) != null) {
      if (ui != null) {
        environment.getGameUI().highlight(cell);
      }

      int x = environment.getCell(row, col).getLifeForm().getDirection();
      System.out.println("Move executed " + x);
      environment.move(row, col);

    }
  }

}
