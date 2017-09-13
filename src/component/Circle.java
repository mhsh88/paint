package component;

import java.awt.Color;
import java.awt.Graphics;

import component.newComponent.Drawable;

public class Circle extends Shape {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6042716103951496377L;

	public Circle(Color color, Point point1, Point point2, Graphics g,String userName) {
		super(color, point1, point2, g, userName);
		System.out.println(userName);
		// paintComponent(g);

		// repaint();
	}

	@Override
	public void drawShape(Graphics g) {

		g.setColor(color);
		g.drawArc(point1.getX(), point1.getY(), point2.getX(), point2.getX(), 0, 360);
	}

}
