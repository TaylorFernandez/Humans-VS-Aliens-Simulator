package gameUI;

import javax.swing.*;

import environment.Environment;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameUI extends ImageCreator implements ActionListener {
  JFrame frame = new JFrame("Humans VS Aliens");
  gameCell[][] buttonArray;
  JButton move;
  JLabel legend;
  JLabel bottom;
  Environment environ;
  List<gameCell> highlightedButtons = new ArrayList<gameCell>();
  // List<gameCell> predictedCells = new ArrayList<gameCell>();
  JLabel lifeformType;
  JLabel lifeformWeapon1;
  JLabel lifeform;
  JButton test;
  JLabel health, ammo;

  int oldRow, oldCol, newRow, newCol;

  ImageIcon human = new ImageIcon("assets/Human/Human.png");

  /**
   * Main Constructor for the game UI
   * 
   * @param row - rows in the board
   * @param col - columns in the board
   * @param env - environment being used by the gameUI
   */
  public GameUI(int row, int col, Environment env) {
    environ = env;
    JPanel rightPanel = new JPanel(new GridLayout(row, col));
    JPanel leftPanel = new JPanel(new GridBagLayout());

    JPanel top = new JPanel(new GridBagLayout());

    top.setBackground(Color.GRAY);

    GridBagConstraints c = new GridBagConstraints();

    JLabel legend = new JLabel();
    legend.setIcon(new ImageIcon("assets/UI Elements/Legend.png"));
    leftPanel.setBackground(Color.GRAY);

    rightPanel.setBackground(new Color(65, 102, 0));
    rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    lifeform = new JLabel();
    lifeform.setIcon(new ImageIcon("assets/Environment/Environment.png"));
    c.gridx = 0;
    c.gridy = 0;
    top.add(lifeform, c);

    lifeformType = new JLabel(" ");
    c.gridx = 0;
    c.gridy = 1;
    top.add(lifeformType, c);

    lifeformWeapon1 = new JLabel(" ");
    c.gridx = 0;
    c.gridy = 2;
    top.add(lifeformWeapon1, c);

    health = new JLabel(" ");
    ammo = new JLabel(" ");

    c.gridx = 1;
    c.gridy = 1;
    top.add(health, c);

    c.gridx = 1;
    c.gridy = 2;
    top.add(ammo, c);

    buttonArray = new gameCell[row][col];

    // creates a grid of buttons
    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray.length; j++) {
        buttonArray[i][j] = new gameCell(i, j);
        buttonArray[i][j].addActionListener(this);
        buttonArray[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rightPanel.add(buttonArray[i][j]);
      }
    }

    drawElements(buttonArray, env);
    frame.add("East", rightPanel);

    leftPanel.add(legend);
    frame.add("West", leftPanel);
    frame.add("North", top);

    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * function for when LifeForm has to move
   */
  public void actionPerformed(ActionEvent event) {
    gameCell button = (gameCell) event.getSource();

    if (environ.getCell(button.getRow(), button.getCol()).getLifeForm() != null) {
      environ.changeSelectedCell(button.getRow(), button.getCol());
      highlight(button);
    }
  }

  public void drawUIText(LifeForm form) {
    lifeformType.setText(form.getType());
    if (form.hasWeapon() != false) {
      lifeformWeapon1.setText(form.getWeaponType());
    } else {
      lifeformWeapon1.setText(" ");
    }
  }

  /**
   * highlights the LifeForm currently selected
   * 
   * @param button - button being pressed
   * @param row    - row of button pressed
   * @param col    - column of button pressed
   */
  public void highlight(gameCell cell) {
    // highlights the cell if "cell" is not already highlighted
    if (cell.isHighlighted == false) {
      cell.setHighlighted(true);
      printStats(cell);
      environ.changeSelectedCell(cell.getRow(), cell.getCol());
      highlightedButtons.add(cell);
      // movePrediction(environ.getCell(cell.getRow(),
      // cell.getCol()).getLifeForm().getMaxSpeed(), environ.getCell(cell.getRow(),
      // cell.getCol()).getLifeForm().getDirection(), cell);
      cell.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
      lifeformType.setText(environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getType());
      lifeformWeapon1.setText(environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getWeaponType());

      if (environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getWeaponType().equals("")) {
        lifeformWeapon1.setText("LifeForm does not have a weapon!");
      }
      // unhighlights the cell if the cell is already highlighted
    } else if (cell.isHighlighted() == true && highlightedButtons.size() < 2) {
      cell.setHighlighted(false);
      lifeformType.setText("No cell selected!");
      lifeformWeapon1.setText("No cell selected!");
      lifeform.setIcon(new ImageIcon("assets/Environment/Environment.png"));

      health.setText(" ");
      ammo.setText(" ");

      highlightedButtons.remove(cell);
      cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // draws the lifeform sprite to the selected cell view
    if (environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getClass() == Alien.class) {
      lifeform.setIcon(new ImageIcon("assets/GameIcons/Alien.png"));
    } else if (environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getClass() == Human.class) {
      lifeform.setIcon(new ImageIcon("assets/Human/Human.png"));
    }

    checkMultipleHighlights();

    // unhighlights the predicted move if the button is unselected
//   if(highlightedButtons.size() == 0) {
//     predictedCells.get(0).setBorder(BorderFactory.createLineBorder(Color.BLACK));
//     predictedCells.remove(0);
//   }

  }

  public void printStats(gameCell cell) {

    if (cell.isHighlighted() == true) {
      health.setText("              Health: "
          + String.valueOf(environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getCurrentLifePoints()));
      if (environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().hasWeapon() == true) {
        ammo.setText("             Ammo: "
            + String.valueOf(environ.getCell(cell.getRow(), cell.getCol()).getLifeForm().getWeapon().getCurrentAmmo()));
      }
    }
  }

  public void checkMultipleHighlights() {
    // makes sure two cells cant be highlighted at once
    if (highlightedButtons.size() > 1) {
      buttonArray[highlightedButtons.get(0).getRow()][highlightedButtons.get(0).getCol()]
          .setBorder(BorderFactory.createLineBorder(Color.BLACK));
      highlightedButtons.get(0).setHighlighted(false);
      highlightedButtons.remove(0);
    }
  }

  public gameCell getCell(int row, int col) {
    return buttonArray[row][col];
  }

  public void drawCell(int row, int col) {
//   int formRow;
//   int formCol;
//   int predictedRow;
//   int predictedCol;
    gameCell cell = buttonArray[row][col];
    drawCell(row, col, environ, cell);
//   if(highlightedButtons.size() > 0 ) {
//     formRow = highlightedButtons.get(0).getRow();
//     formCol = highlightedButtons.get(0).getCol();

//     if(formRow == row && formCol == col) {
//       highlightedButtons.get(0).setHighlighted(false);
//       highlightedButtons.remove(0);

//       predictedRow = predictedCells.get(0).getRow();
//       predictedCol = predictedCells.get(0).getCol();
//       predictedCells.remove(0);
//       drawCell(predictedRow, predictedCol);
    // }
  }
// }

  // allows the gui to update when a lifeform is moves
// public void movePrediction(int distance, int dir, gameCell cell) {
//   
//   int newDist = distance;
//   int row = cell.getRow();
//   int col = cell.getCol();
//   
//   //north prediction
//   if(dir == 0) {
//     while(row - newDist < 0 || environ.getCell(row - newDist, col).getLifeForm() != null) {
//       newDist--;
//     }
//     predictedCells.add(buttonArray[row - newDist][col]);
//     buttonArray[row - newDist][col].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
//   }
//   //east prediction
//   if(dir == 1) {
//     while(col + newDist >= buttonArray[0].length || environ.getCell(row, col + newDist).getLifeForm() != null) {
//       newDist--;
//     }
//     predictedCells.add(buttonArray[row][col + newDist]);
//     buttonArray[row][col + newDist].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
//   }
//   //south prediction
//   if(dir == 2) {
//     while(row + newDist >= buttonArray.length || environ.getCell(row + newDist, col).getLifeForm() != null){
//       newDist--;
//     }
//     predictedCells.add(buttonArray[row + newDist][col]);
//     buttonArray[row + newDist][col].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
//   }
//   
//   //west prediction
//   if(dir == 3) {
//     while(col - newDist < 0 || environ.getCell(row, col - newDist).getLifeForm() != null) {
//       newDist--;
//     }
//     predictedCells.add(buttonArray[row][col - newDist]);
//     buttonArray[row][col - newDist].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
//   
//   //logic for changing highlights when a lifeform is rotated
//   if(predictedCells.size() == 2) {
//     predictedCells.get(0).setBorder(BorderFactory.createLineBorder(Color.BLACK));
//     predictedCells.remove(0);
//   }
//   }
// }

  public gameCell getHighlighted() {
    if (highlightedButtons.size() != 0) {
      return highlightedButtons.get(0);
    }
    return null;
  }

  // display ammo and health

  public void makeLegend(JPanel test) {
    GridBagConstraints c = new GridBagConstraints();

    test.setBackground(Color.GRAY);

    JLabel LegendText = new JLabel("Legend");
    c.gridx = 0;
    c.gridy = 0;
    test.add(LegendText, c);

    JLabel empty = new JLabel(createEnvironment());
    c.gridx = 0;
    c.gridy = 1;
    test.add(empty, c);

    JLabel human = new JLabel(createHuman());
    c.gridx = 0;
    c.gridy = 2;
    test.add(human, c);

    JLabel alien = new JLabel(createAlien());
    c.gridx = 0;
    c.gridy = 3;
    test.add(alien, c);

    JLabel chainGun = new JLabel(createChainGun());
    c.gridx = 0;
    c.gridy = 4;
    test.add(chainGun, c);

    JLabel plasmaCannon = new JLabel(createPlasmaCannon());
    c.gridx = 0;
    c.gridy = 5;
    test.add(plasmaCannon, c);

    JLabel pistol = new JLabel(createPistol());
    c.gridx = 0;
    c.gridy = 6;
    test.add(pistol, c);

  }
}
//Button that stores where it is on the gameboard
