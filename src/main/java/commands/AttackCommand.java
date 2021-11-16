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
    if (environment.getLifeForm(row, col) != null && environment.getLifeForm(row, col).hasWeapon()) {
      if (dir == 0) {
        for (int i = row; i > 0; i--) {
          if (environment.getLifeForm(i - 1, col) != null) {
            double x = environment.getDistance(row, col, i, col);
            if (environment.getCell(row, col).getWeapon1().getMaxRange() >= x) {
              environment.getLifeForm(row, col).attack(environment.getLifeForm(i, col), (int) x);

            }
          }
        }
      }
      if (dir == 1) {
        for (int i = col; i < environment.getNumCols(); i++) {
          if (environment.getLifeForm(row, i + 1) != null) {
            double x = environment.getDistance(row, col, row, i);
            if (environment.getCell(row, col).getWeapon1().getMaxRange() >= x) {
              environment.getLifeForm(row, col).attack(environment.getLifeForm(row, i), (int) x);

            }
          }
        }
      }
      if (dir == 3) {
        for (int i = row; i < environment.getNumRows(); i++) {
          if (environment.getLifeForm(i + 1, col) != null) {
            double x = environment.getDistance(row, col, i, col);
            if (environment.getCell(row, col).getWeapon1().getMaxRange() >= x) {
              environment.getLifeForm(row, col).attack(environment.getLifeForm(i, col), (int) x);

            }
          }
        }
      }

      if (dir == 2) {
        for (int i = col; i > 0; i++) {
          if (environment.getLifeForm(row, i - 1) != null) {
            double x = environment.getDistance(row, col, row, i);
            if (environment.getCell(row, col).getWeapon1().getMaxRange() >= x) {
              environment.getLifeForm(row, col).attack(environment.getLifeForm(row, i), (int) x);

            }
          }
        }
      }

    }

  }

}
