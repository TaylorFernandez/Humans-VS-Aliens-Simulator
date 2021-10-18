package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.TimerObserver;

public class Stabilizer extends Attachment implements Weapon, TimerObserver {

  public Stabilizer(Weapon base) throws AttachmentException {
    if (base.getNumAttachments() == 2) {
      throw new AttachmentException("Attachments cannot exceed 2");
    }
    this.base = base;
  }

  /*
   * This method reloads the weapon if the shots left are 0 This method also gives
   * the weapon bonus damage per shot taken
   */
  @Override
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw new WeaponException("Cannot be less than 0");
    }

    if (getShotsLeft() == 0) {
      return 0;
    }

    if (base.getCurrentAmmo() == 0) {
      base.reload();
    }

    return Double.valueOf(Math.floor(base.fire(distance) * 1.25)).intValue();
  }

  @Override
  public String toString() {
    return base.toString() + " +Stabilizer";
  }
}
