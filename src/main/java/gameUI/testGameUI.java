package gameUI;

import environment.Environment;
import lifeform.Human;

public class testGameUI {

  public static void main(String[] args) {
   Environment env = Environment.getEnvironment(10, 10);
   Human human = new Human("Bob", 100, 4);
   env.addLifeForm(human, 3, 4);
   GameUI ui = new GameUI(env.getNumRows(), env.getNumCols(), env);
       

  }

}
