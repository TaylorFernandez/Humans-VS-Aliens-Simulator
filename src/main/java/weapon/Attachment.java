package weapon;

public abstract class Attachment implements Weapon {
		protected Weapon base;

		public Attachment() {
		}

		/**
		 * Atachment constructor
		 * 
		 * @param baseWeapon - weapon attachment is being added to
		 */
		public Attachment(Weapon baseWeapon) {
				base = baseWeapon;
		}

		/**
		 * Fires the weapon. Accounts for changes to damage done by attachments
		 * 
		 * @param distance - distance between weapon and target
		 */
		public abstract int fire(int distance);

		public int getBaseDamage() {
				return base.getBaseDamage();
		}

		/**
		 * gets the current ammo of the weapon
		 */
		public int getCurrentAmmo() {
				return base.getCurrentAmmo();
		}

		/**
		 * gets the maximum ammo the base weapon can hold
		 */
		public int getMaxAmmo() {
				return base.getMaxAmmo();
		}

		/**
		 * Gets the maximum range the base weapon can shoot
		 */
		public int getMaxRange() {
				return base.getMaxRange();
		}

		/**
		 * Gets the number of attachments the base weapon has
		 */
		public int getNumAttachments() {
				return base.getNumAttachments();
		}

		/**
		 * Gets the rate of fire of the base weapon
		 */
		public int getRateOfFire() {
				return base.getRateOfFire();
		}

		/**
		 * gets the shots the weapon can shoot in the current round
		 */
		public int getShotsLeft() {
				return base.getShotsLeft();
		}

		/**
		 * reloads the weapon
		 */
		public void reload() {
				base.reload();
		}

		/**
		 * notifies the weapon/attachments when a round has gone by
		 * 
		 * @param time - current round
		 */
		public void updateTime(int time) {
				base.reload();
		}
}
