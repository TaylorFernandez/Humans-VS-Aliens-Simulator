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
import javax.swing.JOptionPane;

import commands.AttackCommand;
import commands.Commands;
import commands.DropCommand;
import commands.FaceEastCommand;
import commands.FaceNorthCommand;
import commands.FaceSouthCommand;
import commands.FaceWestCommand;
import commands.MoveCommand;
import commands.PickWeaponOneCommand;
import commands.PickWeaponTwoCommand;
import commands.ReloadCommand;
import environment.Environment;
import exceptions.EnvironmentException;
import exceptions.WeaponException;
import lifeform.LifeForm;

public class Invoker extends JFrame implements ActionListener {
	JButton north, south, east, west, move, reload, pickup, drop, attack;
	Commands c;
	Environment env;
	Commands moveCommand;
	Commands faceDirection;
	Commands dropCommand;
	Commands Weapon1;
	Commands Weapon2;
	Commands Attack;
	Commands Reload;
	GameUI ui;

	public Invoker(Environment e) {
		env = e;
		moveCommand = new MoveCommand(env);
		Weapon1 = new PickWeaponOneCommand(env);
		Weapon2 = new PickWeaponTwoCommand(env);
		Attack = new AttackCommand(env);
		Reload = new ReloadCommand(env);


		setTitle("DIE");
		setLayout(new BorderLayout());
		setLocation(500, 300);
		setSize(333, 195);
		JPanel centerPanel = new JPanel(new BorderLayout());
		JPanel rightPanel = new JPanel(new GridLayout(2, 2));
		add("West", centerPanel);
		add("East", rightPanel);
		
		north = new JButton("North");
		north.addActionListener(this);
		north.setSize(200, 100);
		centerPanel.add(north, BorderLayout.NORTH);

		south = new JButton("South");
		south.addActionListener(this);
		south.setSize(200, 100);
		centerPanel.add(south, BorderLayout.SOUTH);

		west = new JButton("West");
		west.addActionListener(this);
		west.setSize(500, 500);
		centerPanel.add(west, BorderLayout.WEST);

		east = new JButton("East");
		east.addActionListener(this);
		east.setSize(200, 100);
		centerPanel.add(east, BorderLayout.EAST);

		move = new JButton("Select a direction");
		move.addActionListener(this);
		move.setSize(200, 100);
		centerPanel.add(move, BorderLayout.CENTER);

		
		drop = new JButton("Drop");
		drop.addActionListener(this);
		drop.setSize(200, 100);
		rightPanel.add(drop);
		
		reload = new JButton("Reload");
		reload.addActionListener(this);
		reload.setSize(200, 100);
		rightPanel.add(reload);
		
		pickup = new JButton("Pick Up");
		pickup.addActionListener(this);
		pickup.setSize(200, 100);
		rightPanel.add(pickup);
		
		attack = new JButton("Attack");
		attack.addActionListener(this);
		attack.setSize(200, 100);
		rightPanel.add(attack);
		
		pack();
		setVisible(true);
	}

	public void setGameUI(GameUI ui) {
	  this.ui = ui;
	   dropCommand = new DropCommand(env);
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
		if(e.getSource() == drop) {
		  
		  try {
        dropCommand.execute();
      } catch (WeaponException | EnvironmentException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
		

	}
	if(e.getSource() == pickup) {
	   createDialogueBox(this);
	}
	
	if(e.getSource() == attack) {
	  try {
      Attack.execute();
    } catch (WeaponException | EnvironmentException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
	  
	}
	
	  if (e.getSource() == reload) {
		  try {
			Reload.execute();
		} catch (WeaponException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EnvironmentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }

}
	
	public void createDialogueBox(JFrame frame) {
	  JOptionPane choice = new JOptionPane("Choose Weapon..");
	  int row = env.getSelectedRow();
	  int col = env.getSelectedCol();
	  
	  Object[] options = new Object[3];
	  if(env.getCell(row, col).getWeapon1() != null) {
	    options[0] = env.getCell(row, col).getWeapon1().toString();
	  }else {
	    options[0] = "Empty";
	  }
	  
	  if(env.getCell(row, col).getWeapon2() != null) {
	    options[1] = env.getCell(row, col).getWeapon2().toString();
	  }else {
	    options[1] = "Empty";
	  }
	  
	  options[2] = "Cancel";
	  int optionPicked = choice.showOptionDialog(frame, "Which weapon do you want to pickup?", "Weapon Choice", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	  System.out.print(optionPicked);
	  
	  if(optionPicked == 1) {
	    try {
        Weapon1.execute();
      } catch (WeaponException | EnvironmentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
	  }else if(optionPicked == 0) {
	    try {
        Weapon2.execute();
      } catch (WeaponException | EnvironmentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
	  }
	}
}