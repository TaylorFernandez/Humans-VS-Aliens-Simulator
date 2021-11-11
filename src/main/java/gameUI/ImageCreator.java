package gameUI;

import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicGraphicsUtils;

import environment.Environment;
import lifeform.Alien;
import lifeform.Human;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class ImageCreator {
  BufferedImage image  = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
  Graphics drawer = image.getGraphics();

  public void drawElements(JButton[][] buttons, Environment environ) {
    JButton[][] buttonArray = buttons;
    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray[i].length; j++) {
        drawCell(i, j, environ, buttons[i][j]);
      }
    }
  }
  
  public void drawCell(int i, int j, Environment environ, JButton button) {
    BufferedImage image  = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
    Graphics drawer = image.getGraphics();
    
    drawer.setColor(new Color(65 ,102,0));
    drawer.fillRect(0,0,50,50);
    
    if(environ.getCell(i, j).getLifeForm() != null) {
      if(environ.getCell(i,j).getLifeForm().getClass() == Human.class) {
        drawer.setColor(new Color(0,255,0));
        drawer.fillOval(20,20,10,10);
      }else {
        drawer.setColor(new Color(200,240,100));
        drawer.fillOval(20,20,10,10);
      }
    }
    
    if(environ.getCell(i,j).getWeaponsCount() != 0) {
      if(environ.getCell(i, j).getWeapon1().getClass() == PlasmaCannon.class) {
        drawer.setColor(new Color(0,0,255));
        drawer.fillRect(40,40,10,10);
      }else if(environ.getCell(i, j).getWeapon1().getClass() == ChainGun.class) {
        drawer.setColor(new Color(255,255,0));
        drawer.fillRect(0,40,10,10);
      }else if(environ.getCell(i, j).getWeapon1().getClass() == Pistol.class) {
        //Pistol
        drawer.setColor(new Color(255,0,0));
        drawer.fillRect(40,0,10,10);
      }
    }
    
    if(environ.getCell(i, j).getWeapon2() != null) {
      if(environ.getCell(i, j).getWeapon2().getClass() == PlasmaCannon.class) {
        drawer.setColor(new Color(0,0,255));
        drawer.fillRect(40,40,10,10);
      }else if(environ.getCell(i, j).getWeapon2().getClass() == ChainGun.class) {
        drawer.setColor(new Color(255,255,0));
        drawer.fillRect(0,40,10,10);
      }else if(environ.getCell(i, j).getWeapon2().getClass() == Pistol.class){
        //Pistol
        drawer.setColor(new Color(255,0,0));
        drawer.fillRect(40,0,10,10);
      }
    }
    
    if(environ.getCell(i, j).getLifeForm() != null) {
      switch(environ.getCell(i, j).getLifeForm().getDirection()) {
      case 0 : drawer.setColor(new Color(255,0,0)); drawer.fillRect(20,10,10,1); break;
      case 1 : drawer.setColor(new Color(255,0,0)); drawer.fillRect(40,20,1,10); break;
      case 2 : drawer.setColor(new Color(255,0,0)); drawer.fillRect(20,40,10,1); break;
      case 3 : drawer.setColor(new Color(255,0,0)); drawer.fillRect(10,20,1,10);break;
      }
    }
    
    button.setIcon(new ImageIcon(image));
  }
  
  public void createGround() {
    drawer.setColor(new Color(65 ,102,0));
    drawer.fillRect(0,0,50,50);
  }
  
  public void createHuman() {
      drawer.setColor(new Color(0,255,0));
      drawer.fillOval(20,20,10,10);
  }
  
   public void createAlien() {
      drawer.setColor(new Color(0,0,255));
      drawer.fillOval(20,20,10,10);
  }
  public void createPistol() {
      drawer.setColor(new Color(0,255,0));
      drawer.fillRect(40,40,10,10);
  }
  
  public void createPlasmaCannon() {
      drawer.setColor(new Color(255,255,0));
      drawer.fillRect(0,40,10,10);
  }
  
  public void createChainGun() {
      drawer.setColor(new Color(0,255,255));
      drawer.fillRect(40,0,10,10);
  }
  
  public void createSouth() {
      drawer.setColor(new Color(255,0,0));
      drawer.fillRect(20,40,10,1);
  }
  
  public void createEast() {
      drawer.setColor(new Color(255,0,0));
      drawer.fillRect(40,20,1,10);
  }
  
  public void createNorth() {
      drawer.setColor(new Color(255,0,0));
      drawer.fillRect(20,10,10,1);
  }
  
  public void createWest() {
      drawer.setColor(new Color(255,0,0));
      drawer.fillRect(10,20,1,10);
  }
  
  public ImageIcon highlightPlayer() {
    BufferedImage newImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
    
    Graphics draw = newImage.getGraphics();
    draw.setColor(new Color(255,255,0));
    draw.fillRect(0,0,50,50);
    
    return new ImageIcon(newImage);
  }
  
  public ImageIcon highlightPrediction() {
    BufferedImage newImage  = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
    
    Graphics draw = newImage.getGraphics();
    
    draw.setColor(new Color(255,255,0));
    draw.fillRect(0,0,50,50);
    
    draw.setColor(new Color(255, 255, 0));
    draw.fillOval(20,20,10,10);
    
    return new ImageIcon(newImage);
  }
}
