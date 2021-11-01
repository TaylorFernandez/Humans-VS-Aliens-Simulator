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
  JLabel lifeformType;
  JLabel lifeformWeapons;
  JLabel lifeform;
 
  ImageIcon highlighted = createHighlighted();
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
    JPanel leftPanel = new JPanel();
    JPanel top = new JPanel();
    wasLifeForm = new boolean[row][col];
    
    JLabel legend = new JLabel();
    legend.setIcon(new ImageIcon("assets/UI Elements/Legend.png"));
    leftPanel.setBackground(Color.GRAY);

    rightPanel.setBackground(new Color(65, 102, 0));
    rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    lifeformType = new JLabel("testForm");
    lifeformWeapons = new JLabel("testGun");
    lifeform = new JLabel();
    lifeform.setIcon(human);
    top.add("North", lifeform);
    top.add("Center", lifeformType);
    top.add("East",lifeformWeapons);

    top.setLayout(new GridLayout(3,2));
    
    buttonArray = new JButton[row][col];


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
   
    leftPanel.add(legend);
    frame.add("West", leftPanel);
    frame.add("North",top);
    
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
          highlight( i, j);
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
  
 public void highlight(int i, int j) {
   if(buttonArray[i][j].getIcon() != highlighted) {
     buttonArray[i][j].setIcon(highlighted);
   }else if(buttonArray[i][j].getIcon() == highlighted) {
     drawCell(i, j, environ, buttonArray[i][j]);
   }
 }


}
