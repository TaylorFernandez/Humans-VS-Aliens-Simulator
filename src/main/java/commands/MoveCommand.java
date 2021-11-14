package commands;

import environment.Environment;

public class MoveCommand {
  private Environment environment;

  public MoveCommand(Environment e) {
    environment = e;
  }
  
  public void execute() {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    if (environment.getLifeForm(row, col) != null) {
      environment.move(row, col);
    }
  } 
}
