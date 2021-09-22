package environment;

import lifeform.LifeForm;

/**
 * A Cell that can hold a LifeForm
 * 
 * @author lh2565
 *
 */
public class Cell {
  LifeForm being;
  boolean bool;

  /**
   * @return the LifeForm in this Cell.
   */
  public LifeForm getLifeForm() {
    return being;
  }

  /**
   * Treis to add the LifeForm to the Cell. Will not add if a LifeFrom is already
   * present.
   * 
   * @param entity
   * @return true if the LifeForm was added to the Cell, false otherwise
   */
  public boolean addLifeForm(LifeForm entity) {
    if (being == null) {
      being = entity;
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }

  public void removeLifeForm() {
    being = null;
    bool = false;
  }
}
