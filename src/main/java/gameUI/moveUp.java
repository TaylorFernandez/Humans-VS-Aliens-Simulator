package gameUI;

import environment.Environment;
import lifeform.LifeForm;

public class moveUp implements CommandInterface{
  LifeForm lifeform;
  Environment env;
  
  public moveUp(Environment env, LifeForm lifeform) {
    this.env = env;
    this.lifeform = lifeform;
  }

  @Override
  public void execute() {
    lifeform.setDirection(0);
    int x = lifeform.getCol();
    int y = lifeform.getRow();
    env.move(y, x);
    System.out.println("north executed");
  }

}
