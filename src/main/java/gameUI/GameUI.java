package gameUI;

import javax.swing.*;


import environment.Environment;
import lifeform.Human;

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
  List<gameCell> highlightedButtons =  new ArrayList<gameCell>();
  JLabel lifeformType;
  JLabel lifeformWeapon1;
  JLabel lifeformWeapon2;
  JLabel lifeform;
  JButton test;
  
  int oldRow, oldCol, newRow, newCol;
 
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
    JPanel top = new JPanel(new GridBagLayout());
    top.setBackground(Color.GRAY);
    
    GridBagConstraints c = new GridBagConstraints();
    
    JLabel legend = new JLabel();
    legend.setIcon(new ImageIcon("assets/UI Elements/Legend.png"));
    leftPanel.setBackground(Color.GRAY);

    rightPanel.setBackground(new Color(65, 102, 0));
    rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    test = new JButton("testMove");
    test.addActionListener(this);
    
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
    
    buttonArray = new gameCell[row][col];


    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray.length; j++) {
        buttonArray[i][j] = new gameCell(i,j);
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
     highlightedButtons.add(buttonArray[i][j]);
     
     if(highlightedButtons.size() == 2) {
       drawCell(highlightedButtons.get(0).getRow(), highlightedButtons.get(0).getCol(), environ, highlightedButtons.get(0));
       highlightedButtons.remove(0);
     }
     if(environ.getCell(i, j).getLifeForm() != null) {
       lifeformType.setText(environ.getCell(i,j).getLifeForm().getType());
       if(environ.getCell(i, j).getLifeForm().getType().equals("Human")) {
         lifeform.setIcon(human);
       }else {
         lifeform.setIcon(new ImageIcon("assets/Alien/Alien.png"));
       }
       if(!environ.getCell(i, j).getLifeForm().getWeaponType().equals(" ")) {
         lifeformWeapon1.setText(environ.getCell(i, j).getLifeForm().getWeaponType());
       }
     }
   }else if(buttonArray[i][j].getIcon() == highlighted) {
       drawCell(i, j, environ, buttonArray[i][j]);
       lifeform.setIcon(new ImageIcon("assets/Environment/Environment.png"));
       lifeformType.setText(" ");
       lifeformWeapon1.setText(" ");
   }
  }
 
 //allows the gui to update when a lifeform is moves
 public void moveLifeForm(int row, int col) {
   for(int i = 0; i < buttonArray.length; i++) {
     for(int j = 0; j < buttonArray[i].length; j++) {
       if(buttonArray[i][j].getIcon() == highlighted) {
         drawCell(i,j, environ, buttonArray[i][j]);
       }
     }
   }
   drawCell(row, col, environ, buttonArray[row][col]);
 }
}

//Button that stores where it is on the gameboard
class gameCell extends JButton {
  public int row;
  public int col;
  public gameCell(int r, int c) {
    super();
    row = r;
    col = c;
  }
  /**
   * gets the row a button is in
   * @return row - row of the button
   */
  public int getRow() {
    return row;
  }
  
  /**
   * gets the column a button is in
   * @return col - column of the button
   */
  public int getCol() {
    return col;
  }
  
  /**
   * sets the row of a button
   * @param r - row of the button
   */
  public void setRow(int r) {
    row = r;
  }
  
  /**
   * sets the column a button is in
   * @param c - column of the button
   */
  public void setcol(int c) {
    col = c;
  }
}