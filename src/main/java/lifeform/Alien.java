package lifeform;

import exceptions.RecoveryRateException;
import recovery.RecoveryBehavior;

public class Alien extends LifeForm {
  int maxLifePoints;
  int recoveryRate;
  int currentLifePoints;
  RecoveryBehavior xd;

  public Alien(String name, int maxHp) {
    super(name, maxHp);
    maxLifePoints = maxHp;
  }

  public Alien(String name, int maxHp, RecoveryBehavior behavior) throws RecoveryRateException {
    this(name, maxHp);
    xd = behavior;
  }

  /**
   * constuctor for alien
   * 
   * @param name
   * @param maxHp
   * @param behavior
   * @param recoveryRate
   * @throws RecoveryRateException
   */
  public Alien(String name, int maxHp, RecoveryBehavior behavior, int recoveryRate) 
      throws RecoveryRateException {
    this(name, maxHp);
    maxLifePoints = maxHp;
    this.recoveryRate = recoveryRate;
    try {
      if (recoveryRate < 0) {
        throw new RecoveryRateException("Recovery Rate is zero");
      } else {
        this.recoveryRate = recoveryRate;
      }
    } catch (RecoveryRateException e) {
      throw e;
    }
  }

  public int getMaxLifePoints() {
    return this.maxLifePoints;
  }

  public int getRecoveryRate() {
    return this.recoveryRate;
  }

  protected void recover() {
    points = xd.calculateRecovery(points, maxLifePoints);
  }
}
