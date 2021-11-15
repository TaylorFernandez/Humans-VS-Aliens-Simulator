package gameUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import commands.Commands;
import commands.FaceEastCommand;
import commands.FaceNorthCommand;
import commands.FaceSouthCommand;
import commands.FaceWestCommand;
import commands.MoveCommand;
import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.WeaponException;
import lifeform.LifeForm;

public class Invoker extends JFrame implements ActionListener {
	JButton north, south, east, west, move;
	Commands c;
	Environment env;
	Commands moveCommand;
	Commands faceDirection;

	public Invoker(Environment e) {
		env = e;
		moveCommand = new MoveCommand(env);

		setLayout(new BorderLayout());
		setLocation(500, 300);
		setSize(320, 195);
		JPanel centerPanel = new JPanel(new GridLayout(2, 3));
		add("Center", centerPanel);

		north = new JButton("North");
		north.addActionListener(this);
		north.setSize(200, 100);
		add(north, BorderLayout.NORTH);

		south = new JButton("South");
		south.addActionListener(this);
		south.setSize(200, 100);
		add(south, BorderLayout.SOUTH);

		west = new JButton("West");
		west.addActionListener(this);
		west.setSize(500, 500);
		add(west, BorderLayout.WEST);

		east = new JButton("East");
		east.addActionListener(this);
		east.setSize(200, 100);
		add(east, BorderLayout.EAST);

		move = new JButton("Select a direction");
		move.addActionListener(this);
		move.setSize(200, 100);
		add(move, BorderLayout.CENTER);

		// pack();
		setVisible(true);
	}

	public ImageIcon createImage() {
		BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = exampleImage.getGraphics();

		drawer.setColor(new Color(200, 200, 200));
		drawer.fillRect(0, 0, 50, 50);

		drawer.setColor(new Color(0, 255, 0));
		drawer.fillOval(20, 20, 10, 10);

		return new ImageIcon(exampleImage);

	}

	public void setCommand(Commands cmd) {
		c = cmd;
	}

	int next = 0;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == north) {
			faceDirection = new FaceNorthCommand(env);
			try {
				faceDirection.execute();
			} catch (WeaponException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EnvironmentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			move.setText("Move!");
		}
		if (e.getSource() == south) {
			faceDirection = new FaceSouthCommand(env);
			try {
				faceDirection.execute();
			} catch (WeaponException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EnvironmentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			move.setText("Move!");
		}
		if (e.getSource() == east) {
			faceDirection = new FaceEastCommand(env);
			try {
				faceDirection.execute();
			} catch (WeaponException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EnvironmentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			move.setText("Move!");
		}
		if (e.getSource() == west) {
			faceDirection = new FaceWestCommand(env);
			try {
				faceDirection.execute();
			} catch (WeaponException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EnvironmentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			move.setText("Move!");
		}
		if (e.getSource() == move) {
				try {
					moveCommand.execute();
				} catch (WeaponException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EnvironmentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (e.getSource() == null) {
			move.setText("Select a direction"); 
			}
		}

	}

}
