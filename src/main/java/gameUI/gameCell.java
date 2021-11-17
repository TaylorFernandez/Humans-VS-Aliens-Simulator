package gameUI;

import javax.swing.JButton;

public class gameCell extends JButton {

  private static final long serialVersionUID = 1L;
  public int row;
  public int col;
  public boolean isHighlighted = false;

  public gameCell(int r, int c) {
    super();
    row = r;
    col = c;
  }

  /**
   * gets the row a button is in
   * 
   * @return row - row of the button
   */
  public int getRow() {
    return row;
  }

  /**
   * gets the column a button is in
   * 
   * @return col - column of the button
   */
  public int getCol() {
    return col;
  }

  /**
   * sets the row of a button
   * 
   * @param r - row of the button
   */
  public void setRow(int r) {
    row = r;
  }

  /**
   * sets the column a button is in
   * 
   * @param c - column of the button
   */
  public void setcol(int c) {
    col = c;
  }

  public boolean isHighlighted() {
    return isHighlighted;
  }

  public void setHighlighted(boolean setBool) {
    isHighlighted = setBool;
  }
}