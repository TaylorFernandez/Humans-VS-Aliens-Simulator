package commands;

import environment.Environment;
import gameUI.GameUI;
import weapon.Weapon;

public class ReloadCommand implements Commands {
		private Environment environment;
		GameUI xd;
		
		public ReloadCommand(Environment e) {
				environment = e;	
				xd = e.getGameUI();
		}
		
		public void execute() {
				int row = environment.getSelectedRow();
				int col = environment.getSelectedCol();
				if(environment.getLifeForm(row, col) != null && environment.getLifeForm(row, col).hasWeapon()) {
						Weapon weapon = environment.getLifeForm(row, col).getWeapon();
						System.out.println("Before Reload: " + environment.getLifeForm(row, col).getWeapon().getCurrentAmmo());
						weapon.reload();
						xd.printStats(xd.getCell(row, col));
						System.out.println("Reloaded");
						System.out.println("After Reload: " + environment.getLifeForm(row, col).getWeapon().getCurrentAmmo());
				}
		}
} 
