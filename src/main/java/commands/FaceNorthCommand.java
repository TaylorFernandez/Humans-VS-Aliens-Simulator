package commands;

import environment.Environment;

public class FaceNorthCommand implements Commands {
  private Environment environment;

  public FaceNorthCommand(Environment e) {
    environment = e;
  }

  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    if (environment.getLifeForm(row, col) != null) {
      environment.getLifeForm(row, col).setDirection(0);
    }
  }
}
