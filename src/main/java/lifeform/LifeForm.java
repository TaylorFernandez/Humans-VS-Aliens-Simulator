package lifeform;

public abstract class LifeForm {
  String name;
  int points;
  int attack;

  /**
   * LifeForms
   * 
   * @param n name of life form
   * @param p points for life form constructor to create the lifeform with a name
   *          and amount of lifepoints.
   */
  public LifeForm(String n, int p) {
    name = n;
    points = p;
  }

  /**
   * constructor for lifeForm
   * 
   * @param n
   * @param p
   * @param attack
   */
  public LifeForm(String n, int p, int attack) {
    name = n;
    points = p;
    this.attack = attack;
  }

  /**
   * 
   * @return the name
   */
  public String getName() {
    /**
     * @return the name of the lifeform
     */
    return name;
  }

  /**
   * 
   * @return the points
   */
  public int getCurrentLifePoints() {
    /**
     * @return the number of life points
     */
    return points;
  }

  /**
   * hits an enity
   * 
   * @param damage
   */
  public void takeHit(int damage) {
    if (points - damage < 0) {
      points = 0;
    } else if (points - damage >= 0) {
      points -= damage;
    }
  }

  /**
   * 
   * @return attack strength
   */
  public int getAttackStrength() {
    return this.attack;
  }

  /**
   * attacks
   * 
   * @param opponent
   */
  public void attack(LifeForm opponent) {
    if (points <= 0) {
      attack = 0;
    } else {
      opponent.takeHit(this.attack);

    }
  }

}
