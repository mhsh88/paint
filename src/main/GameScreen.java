package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawRect(100, 10, 30, 40);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 200, 400);
	}

	public static void main(String[] args) {
		GameScreen gs = new GameScreen();
		gs.setBackground(Color.WHITE);
		JFrame f = new JFrame();
		f.setTitle("");
		f.setSize(400, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(gs);
	}
}