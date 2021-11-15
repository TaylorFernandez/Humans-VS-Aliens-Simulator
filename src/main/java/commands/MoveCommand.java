package commands;

import environment.Environment;

public class MoveCommand implements Commands {
	private Environment environment;

	public MoveCommand(Environment e) {
		environment = e;
	}

	@Override
	public void execute() {
		int row = environment.getSelectedRow();
		int col = environment.getSelectedCol();
		if (environment.getLifeForm(row, col) != null) {
			int x = environment.getCell(row, col).getLifeForm().getDirection();
			System.out.println("Move executed " + x);
			environment.move(row, col);
			
		}
	}

}
