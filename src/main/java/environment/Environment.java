package environment;

import lifeform.LifeForm;
/**
 * an environment that holds everything
 * @author lh2565
 *
 */

public class Environment {
  Cell[][] cells;

  /**
   * constuctor
   * @param rows of the 2d array
   * @param cols of the 2d array
   */
  public Environment(int rows, int cols) {
    cells = new Cell[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        cells[i][j] = new Cell();
      }
    }
  }

  public boolean addLifeForm(LifeForm entity, int rows, int cols) {
    return cells[rows][cols].addLifeForm(entity);
  }

  public LifeForm getLifeForm(int rows, int cols) {
    return cells[rows][cols].getLifeForm();
  }

  public void removeLifeForm(int rows, int cols) {
    cells[rows][cols].removeLifeForm();
  }
}
