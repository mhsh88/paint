package component;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rectangle(Color color, Point point1, Point point2, Graphics g,String userName) {
		super(color, point1, point2, g, userName);

	}

	@Override
	public void drawShape(Graphics g) {

		g.setColor(color);
		g.drawRect(point1.getX(), point1.getY(), point2.getX(), point2.getY());
	}

}
