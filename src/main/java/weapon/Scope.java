package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.TimerObserver;

/*
 * @Author Evan Paules
 * Scope is an extension of Attachment and uses Weapon and TimerObserver Interfaces.
 * This Modifies a weapons damage and distance
 */
public class Scope extends Attachment implements Weapon, TimerObserver {

	public Scope(Weapon base) throws AttachmentException {
	  if (base.getNumAttachments() == 2) {
      throw new AttachmentException("Attachments cannot exceed 2");
    }
		this.base = base;
	}

	@Override
	public int getMaxRange() {
		return base.getMaxRange() + 10;
	}
	
	/*
	 * This method adds damage based on the distance of the target
	 */
	@Override
	public int fire(int distance) throws WeaponException {
	  if (distance < 0) {
      throw new WeaponException("Cannot be less than 0");
    }

    if (getShotsLeft() == 0) {
      return 0; 
    }
    
		if (base.getMaxRange() < distance && distance <= this.getMaxRange()) {
			return base.fire(base.getMaxRange()) + 5;
		} 
		
		if (base.getMaxRange() < distance) {
			return 0;
		}
		double ampedRange = getMaxRange() - distance;
		ampedRange = 1 + (ampedRange / getMaxRange()); 
		return Double.valueOf(Math.floor(ampedRange * base.fire(distance))).intValue();

	}

	@Override
	public String toString() {
		return base.toString() + " +Scope";

	}

}
