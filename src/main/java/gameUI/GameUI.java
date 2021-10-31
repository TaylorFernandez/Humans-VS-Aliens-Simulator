package gameUI;

import javax.swing.*;

import environment.Environment;
import lifeform.Human;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameUI extends ImageCreator implements ActionListener {
  JFrame frame = new JFrame("Humans VS Aliens");
  JButton[][] buttonArray;
  JButton move;
  JLabel legend;
  JLabel bottom;
  Environment environ;
  boolean[][] wasLifeForm;
  ImageIcon humanWithPistol = new ImageIcon("assets/HumanWithPistol.png");

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
    JPanel leftPanel = new JPanel(new GridLayout(row, col));
    wasLifeForm = new boolean[row][col];

    leftPanel.setBackground(Color.GRAY);

    rightPanel.setBackground(new Color(65, 102, 0));
    rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    buttonArray = new JButton[row][col];

    bottom = new JLabel("NotPressed");

    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray.length; j++) {
        buttonArray[i][j] = new JButton();
        buttonArray[i][j].addActionListener(this);
        buttonArray[i][j].setIcon(new ImageIcon("assets/Environment/Environment.png"));
        buttonArray[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rightPanel.add(buttonArray[i][j]);
      }
    }
    drawElements(buttonArray, env);
    frame.add("East", rightPanel);
   
    move = new JButton("move");
    move.addActionListener(this);
    leftPanel.add("North", move);
    frame.add("West", leftPanel);

    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * function for when LifeForm has to move
   */
  public void actionPerformed(ActionEvent event) {
    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray[i].length; j++) {
        if (event.getSource() == buttonArray[i][j]) {
          highlight(buttonArray[i][j], i, j);
        }
      }
    }
  }

  /**
   * highlights the LifeForm currently selected
   * 
   * @param button - button being pressed
   * @param row    - row of button pressed
   * @param col    - column of button pressed
   */
  
 public void highlight(JButton button, int row, int col) {
   
 }


}
