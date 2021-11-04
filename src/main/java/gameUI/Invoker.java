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

public class Invoker extends JFrame implements ActionListener
{
	JButton north, south, east, west, move;

	public Invoker()
	{
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

	public ImageIcon createImage()
	{
		BufferedImage exampleImage = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = exampleImage.getGraphics();

		drawer.setColor(new Color(200, 200, 200));
		drawer.fillRect(0, 0, 50, 50);

		drawer.setColor(new Color(0, 255, 0));
		drawer.fillOval(20, 20, 10, 10);

		return new ImageIcon(exampleImage);

	}

	int next = 0;

	@Override
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == north)
		{
			next = 1;
			move.setText("Move!");
		}
		if (e.getSource() == south)
		{
			next = 2;
			move.setText("Move!");
		}
		if (e.getSource() == east)
		{
			next = 3;
			move.setText("Move!");
		}
		if (e.getSource() == west)
		{
			next = 4;
			move.setText("Move!");
		}
		if (e.getSource() == move)
		{
			if (next == 1)
			{
				System.out.println("North");
			}
			if (next == 2)
			{
				System.out.println("South");
			}
			if (next == 3)
			{
				System.out.println("East");
			}
			if (next == 4)
			{
				System.out.println("West");
			}
			next = 0;
			move.setText("Select a direction");
		}

	}

}
