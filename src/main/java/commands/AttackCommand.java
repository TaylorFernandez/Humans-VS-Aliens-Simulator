package commands;

import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.WeaponException;

public class AttackCommand implements Commands {
  private Environment environment;

  public AttackCommand(Environment e) {
    environment = e;
  }

  @Override
  public void execute() throws WeaponException, EnvironmentException {
    int row = environment.getSelectedRow();
    int col = environment.getSelectedCol();
    int dir = environment.getLifeForm(row, col).getDirection();
    if (environment.getLifeForm(row, col) != null) {
      if (dir == 0) {
        if (environment.getLifeForm(row - 1, col) != null) {

          environment.getLifeForm(row, col).attack(environment.getLifeForm(row - 1, col));
          System.out.println("attack performed");
        } else {
          System.out.println("Nothing there to attack");
        }
      }
      if (dir == 1) {
        if (environment.getLifeForm(row, col + 1) != null) {

          environment.getLifeForm(row, col).attack(environment.getLifeForm(row + 1, col));
          System.out.println("attack performed");
        }

        else {
          System.out.println("Nothing there to attack");
        }
      }
      if (dir == 2) {
        if (environment.getLifeForm(row + 1, col) != null) {

          environment.getLifeForm(row, col).attack(environment.getLifeForm(row + 1, col));
          System.out.println("attack performed");
        } else {
          System.out.println("Nothing there to attack");
        }
      }
      if (dir == 3) {
        if (environment.getLifeForm(row, col - 1) != null) {

          environment.getLifeForm(row, col).attack(environment.getLifeForm(row, col - 1));
          System.out.println("attack performed");
        } else {
          System.out.println("Nothing there to attack");
        }
      }
    }

  }

}
