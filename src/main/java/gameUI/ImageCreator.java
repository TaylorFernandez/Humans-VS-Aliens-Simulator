package gameUI;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

import environment.Environment;
import lifeform.Alien;
import lifeform.Human;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class ImageCreator {

  public void drawElements(JButton[][] buttons, Environment environ) {
    JButton[][] buttonArray = buttons;
    for (int i = 0; i < buttonArray.length; i++) {
      for (int j = 0; j < buttonArray[i].length; j++) {
        drawCell(i, j, environ, buttons[i][j]);
      }
    }
  }
  
  public void drawCell(int i, int j, Environment environ, JButton button) {
    if(environ.getCell(i, j).getLifeForm() == null && environ.getCell(i, j).getWeaponsCount() == 0) {
      button.setIcon(new ImageIcon("assets/Environment/Environment.png"));
    }
    if (environ.getCell(i, j).getLifeForm() != null) {

      if (environ.getCell(i, j).getLifeForm().getClass() == Human.class) {
        if (environ.getCell(i, j).getWeaponsCount() == 0) {
          button.setIcon(new ImageIcon("assets/Human/Human.png"));
        }

        if (environ.getCell(i, j).getWeaponsCount() == 1) {
          if (environ.getCell(i, j).getWeapon1().getClass() == Pistol.class) {
            button.setIcon(new ImageIcon("assets/Human/HumanWithPistol.png"));
          } else if (environ.getCell(i, j).getWeapon1().getClass() == PlasmaCannon.class) {
            button.setIcon(new ImageIcon("assets/Human/HumanWithPlasma.png"));
          } else {
            button.setIcon(new ImageIcon("assets/Human/HumanWithChain.png"));
          }
        } else if(environ.getCell(i, j).getWeaponsCount() == 2){
          if (environ.getCell(i, j).getWeapon1().getClass() == Pistol.class
              && environ.getCell(i,j).getWeapon2().getClass() == ChainGun.class) {
            button.setIcon(new ImageIcon("assets/Human/HumanWithPistolAndChain.png"));
          } else if (environ.getCell(i, j).getWeapon1().getClass() == PlasmaCannon.class
              && environ.getCell(i, i).getWeapon2().getClass() == ChainGun.class) {
            button.setIcon(new ImageIcon("assets/Human/HumanWithPlasmaAndChain.png"));
          } else {
            button.setIcon(new ImageIcon("assets/Human/HumanWithPistolAndPlasma.png"));
          }
        }
      } else if (environ.getCell(i, j).getLifeForm().getClass() == Alien.class) {
        if (environ.getCell(i, j).getWeaponsCount() == 0) {
          button.setIcon(new ImageIcon("assets/Alien/Alien.png"));
        }

        if (environ.getCell(i, j).getWeaponsCount() == 1) {
          if (environ.getCell(i, j).getWeapon1().getClass() == Pistol.class) {
            button.setIcon(new ImageIcon("assets/Alien/AlienWithPistol.png"));
          } else if (environ.getCell(i, j).getWeapon1().getClass() == ChainGun.class) {
            button.setIcon(new ImageIcon("assets/Alien/AlienWithChain.png"));
          } else {
            button.setIcon(new ImageIcon("assets/Alien/AlienWithPlasma.png"));
          }
        } else {
          if (environ.getCell(i, j).getWeaponsCount() == 2) {
            if (environ.getCell(i, j).getWeapon1().getClass() == Pistol.class
                && environ.getCell(i,j).getWeapon2().getClass() == ChainGun.class) {
              button.setIcon(new ImageIcon("assets/Alien/AlienWithPistolAndChain.png"));
            } else if (environ.getCell(i, j).getWeapon1().getClass() == PlasmaCannon.class
                && environ.getCell(i, i).getWeapon2().getClass() == ChainGun.class) {
              button.setIcon(new ImageIcon("assets/Alien/AlienWithPlasmaAndChain.png"));
            } else {
              button.setIcon(new ImageIcon("assets/Alien/AlienWithPistolAndPlasma.png"));
            }
          }
        }
      }
    } else {
      if (environ.getCell(i, j).getWeaponsCount() == 1) {
        if (environ.getCell(i, j).getWeapon1().getClass() == Pistol.class) {
          button.setIcon(new ImageIcon("assets/Environment/Pistol.png"));
        } else if (environ.getCell(i, j).getWeapon1().getClass() == ChainGun.class) {
          button.setIcon(new ImageIcon("assets/Environment/ChainGun.png"));
        } else {
          button.setIcon(new ImageIcon("assets/Environment/PlasmaCannon.png"));
        }
      } else {
        if (environ.getCell(i, j).getWeaponsCount() == 2) {
          if (environ.getCell(i, j).getWeapon1().getClass() == Pistol.class
              && environ.getCell(i,j).getWeapon2().getClass() == ChainGun.class) {
            button.setIcon(new ImageIcon("assets/Environment/PistolAndChain.png"));
          } else if (environ.getCell(i, j).getWeapon1().getClass() == PlasmaCannon.class
              && environ.getCell(i, i).getWeapon2().getClass() == ChainGun.class) {
            button.setIcon(new ImageIcon("assets/Environment/PlasmaAndChain.png"));
          } else {
            button.setIcon(new ImageIcon("assets/Environment/PistolAndPlasma.png"));
          }

        }
      }
    }
  }
  
  public ImageIcon createHighlighted() {
    BufferedImage image = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
    Graphics drawer = image.getGraphics();
    
    drawer.setColor(new Color(255,255,0));
    drawer.fillRect(0,0,50,50);
    
    return new ImageIcon(image);
    
    
  }
}