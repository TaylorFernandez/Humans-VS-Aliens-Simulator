package environment;

import lifeform.LifeForm;
import weapon.Weapon;
/**
 * an environment that holds everything
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
  
  /**
   * gets the weapons from a specific cell
   * @return list of weapons
   */
  
  public Weapon[] getWeapons(int row, int col) {
    Weapon[] w = new Weapon[2];
    if(w.length == 1) {
      w[0] = cells[row][col].getWeapon1();
    }
    
    if(w.length == 2) {
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
  
  public void clearBoard() {
    for(int i = 0; i < numRow; i++) {
      for(int j = 0; j < numCol; j++) {
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
  /**
   * gets the distance between two points
   * @param row1
   * @param col1
   * @param row2
   * @param col2
   * @return
   */
  
  public double getDistance(int row1, int col1, int row2, int col2) {
    int xDistance = Math.abs(col1 - col2);
    int yDistance = Math.abs(row1 - row2);
    
    double distance = Math.sqrt((Math.pow(xDistance, 2) + Math.pow(yDistance, 2)));
    return distance * 5;
  }
  
  public double getDistance(LifeForm l1, LifeForm l2) {
    double distance = this.getDistance(l1.getRow(), l1.getCol(), l2.getRow(), l2.getCol());
        
    return distance;
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
