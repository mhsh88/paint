package component;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rectangle(Color color, Point point1, Point point2, boolean fill, Graphics g, String userName) {
		super(color, point1, point2, fill, g, userName);

	}

	@Override
	public void drawShape(Graphics g) {

		g.setColor(color);
		if (isFill())
			g.fillRect(point1.getX(), point1.getY(), point2.getX(), point2.getY());
		else
			g.drawRect(point1.getX(), point1.getY(), point2.getX(), point2.getY());
	}

}
