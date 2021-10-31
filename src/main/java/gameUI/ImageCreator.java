package gameUI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageCreator {
  public ImageIcon createEnvironment() {
    BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);

    Graphics drawer = exampleImage.getGraphics();

    drawer.setColor(new Color(65, 102, 0));
    drawer.fillRect(0, 0, 50, 50);

    return new ImageIcon(exampleImage);
  }

  public ImageIcon createHighlighted() {
    BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);

    Graphics drawer = exampleImage.getGraphics();

    drawer.setColor(new Color(255, 255, 0));
    drawer.fillRect(0, 0, 50, 50);

    return new ImageIcon(exampleImage);
  }

  public ImageIcon createImage() {
    BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);

    Graphics drawer = exampleImage.getGraphics();

    drawer.setColor(new Color(65, 102, 0));
    drawer.fillRect(0, 0, 50, 50);

    drawer.setColor(new Color(0, 255, 0));
    drawer.fillOval(20, 20, 10, 10);

    return new ImageIcon(exampleImage);
  }

  public ImageIcon createHuman() {
    BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);

    Graphics drawer = exampleImage.getGraphics();

    drawer.setColor(new Color(65, 102, 0));
    drawer.fillRect(0, 0, 50, 50);

    drawer.setColor(new Color(0, 255, 0));
    drawer.fillOval(20, 20, 10, 10);

    return new ImageIcon(exampleImage);
  }
  

}