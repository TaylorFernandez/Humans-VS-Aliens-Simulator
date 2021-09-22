package lifeform;

public class Human extends LifeForm {
  int armor;
  int points;
  String name;

  /**
   * constructor for human
   * 
   * @param n
   * @param p
   * @param a
   */
  public Human(String n, int p, int a) {
    super(n, p);
    name = n;
    points = p;
    armor = a;
  }

  /**
   * sets the armor
   * 
   * @param extra
   */
  public void setArmorPoints(int extra) {
    if (extra < 0) {
      armor = 0;
    } else {
      armor = extra;
    }
  }

  /**
   * 
   * @return armor rating
   */
  public int getArmorPoints() {
    if (armor < 0) {
      return 0;
    }
    return armor;

  }
}
