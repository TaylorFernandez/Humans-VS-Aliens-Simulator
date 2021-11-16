package commands;

import environment.Environment;
import gameUI.gameCell;

public class MoveCommand implements Commands {
	private Environment environment;

	public MoveCommand(Environment e) {
		environment = e;
	}

	@Override
	public void execute() {
		int row = environment.getSelectedRow();
		int col = environment.getSelectedCol();
		gameCell cell = environment.getGameCell(row,  col);
		
		if (environment.getLifeForm(row, col) != null) {
		  environment.getGameUI().highlight(cell);
			int x = environment.getCell(row, col).getLifeForm().getDirection();
			System.out.println("Move executed " + x);
			environment.move(row, col);
			
		}
	}

}
