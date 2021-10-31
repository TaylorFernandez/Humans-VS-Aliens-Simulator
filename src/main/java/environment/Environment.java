package environment;

import exceptions.EnvironmentException;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * an environment that holds everything
 *
 * @author lh2565
 *
 */

public class Environment {
  Cell[][] cells;
  private static Environment env;
  int numRow;
  int numCol;

  /**
   * constuctor
   *
   * @param rows of the 2d array
   * @param cols of the 2d array
   */
  private Environment(int rows, int cols) {
    numRow = rows;
    numCol = cols;
    cells = new Cell[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        cells[i][j] = new Cell();
      }
    }
  }
  public Cell getCell(int row, int col) {
    return cells[row][col];
  }
  /**
   * gets the weapons from a specific cell
   *
   * @return list of weapons
   */

  public Weapon[] getWeapons(int row, int col) {
    Weapon[] w = new Weapon[2];
    if (w.length == 1) {
      w[0] = cells[row][col].getWeapon1();
    }

    if (w.length == 2) {
      w[0] = cells[row][col].getWeapon1();
      w[1] = cells[row][col].getWeapon2();
    }

    return w;
  }

  public int getNumRows() {
    return numRow;
  }

  public int getNumCols() {
    return numCol;
  }

  /**
   *
   * clears board of cells.
   *
   */
  public void clearBoard() {
    for (int i = 0; i < numRow; i++) {
      for (int j = 0; j < numCol; j++) {
        cells[i][j] = new Cell();
      }
    }
  }

  /**
   * adds a weapon to a specific place on the environment
   */
  public boolean addWeapon(Weapon w, int row, int col) {
    return cells[row][col].addWeapon(w);
  }

  public Weapon removeWeapon(Weapon weapon, int row, int col) {
    return cells[row][col].removeWeapon(weapon);
  }

  /**
   * gets the distance between two points
   *
   * @param row1
   * @param col1
   * @param row2
   * @param col2
   * @return
   */

  public double getDistance(int row1, int col1, int row2, int col2) throws EnvironmentException {
    if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) {
      throw new EnvironmentException("Rows and columns cannot be less than zero");
    }
    if (row1 >= numRow || col1 >= numCol || row2 >= numRow || col2 >= numCol) {
      throw new EnvironmentException("Rows and columns are out of bounds!");
    }

    int distanceX = Math.abs(col2 - col1);
    if (row1 == row2) {
      return distanceX * 5;
    }
    int distanceY = Math.abs(row2 - row1);
    if (col1 == col2) {
      return distanceY * 5;
    }
    if (row1 != row2 && col1 != col2) {
      double distance = Math.sqrt((Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
      return distance * 5;
    }
    return 0;
  }

  /**
   * Singleton Method
   *
   * @return env
   */

  public double getDistance(LifeForm l1, LifeForm l2) throws EnvironmentException {
    return this.getDistance(l1.getRow(), l1.getCol(), l2.getRow(), l2.getCol());
  }

  /**
   *
   *
   * @param rows - rows in the Environment
   * @param cols - columns in the Environment
   * @return environment
   */

  public static Environment getEnvironment(int rows, int cols) {
    if (env == null) {
      env = new Environment(rows, cols);
    }
    return env;
  }

  /**
   * Adds lifeform to the Environment
   *
   * @param entity - Entity being added
   * @param rows   - Row where the LifeForm is being added
   * @param cols   - Column where the LifeForm is being added
   * @return
   */
  public boolean addLifeForm(LifeForm entity, int rows, int cols) {
    if (entity != null) {
      if (cells[rows][cols].getLifeForm() == null) {
        cells[rows][cols].addLifeForm(entity);
        entity.setLocation(rows, cols);
        return true;
      }
    }
    return false;
  }

  /**
   * gets the LifeForm from a current Cell
   *
   * @param rows - row where the LifeForm is being gotten
   * @param cols - column where the LifeForm is being gotten
   * @return
   */
  public LifeForm getLifeForm(int rows, int cols) {
    return cells[rows][cols].getLifeForm();
  }

  /**
   * Removes the LifeForm from the Environment
   *
   * @param rows - Row where the LifeForm is being removed
   * @param cols - Column where the LifeForm is being removed
   */
  public void removeLifeForm(int rows, int cols) {
    cells[rows][cols].removeLifeForm();
  }
}
