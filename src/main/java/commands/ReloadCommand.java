package commands;

import environment.Environment;
import weapon.Weapon;

public class ReloadCommand implements Commands {
		private Environment environment;
		
		public ReloadCommand(Environment e) {
				environment = e;
				
		}
		
		public void execute() {
				int row = environment.getSelectedRow();
				int col = environment.getSelectedCol();
				if(environment.getLifeForm(row, col) != null && environment.getLifeForm(row, col).hasWeapon()) {
						Weapon weapon = environment.getLifeForm(row, col).dropWeapon();
						weapon.reload();
						environment.getLifeForm(row, col).pickUpWeapon(weapon);
						environment.updateBoard(row, col);
				}
		}
}
