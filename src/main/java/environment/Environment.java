package environment;

import lifeform.LifeForm;
/**
 * an environment that holds everything
 * @author lh2565
 *
 */

public class Environment {
  Cell[][] cells;
  private static Environment env;

  /**
   * constuctor
   * @param rows of the 2d array
   * @param cols of the 2d array
   */
  private Environment(int rows, int cols) {
    cells = new Cell[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        cells[i][j] = new Cell();
      }
    }
  }
  
  /**
   * Singleton Method
   * @param rows - rows in the Environment
   * @param cols - columns in the Environment
   * @return env 
   */
  public static Environment getEnvironment(int rows, int cols) {
    if(env == null) {
      env = new Environment(rows, cols);
    }
      return env;
  }

  /**
   * Adds lifeform to the Environment
   * @param entity - Entity being added
   * @param rows - Row where the LifeForm is being added 
   * @param cols - Column where the LifeForm is being added
   * @return
   */
  public boolean addLifeForm(LifeForm entity, int rows, int cols) {
    return cells[rows][cols].addLifeForm(entity);
  }

  /**
   * gets the LifeForm from a current Cell
   * @param rows - row where the LifeForm is being gotten
   * @param cols - column where the LifeForm is being gotten
   * @return
   */
  public LifeForm getLifeForm(int rows, int cols) {
    return cells[rows][cols].getLifeForm();
  }

  /**
   * Removes the LifeForm from the Environment
   * @param rows - Row where the LifeForm is being removed
   * @param cols - Column where the LifeForm is being removed
   */
  public void removeLifeForm(int rows, int cols) {
    cells[rows][cols].removeLifeForm();
  }
}
