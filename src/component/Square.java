package component;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7326361202686342574L;

	public Square(Color color, Point point1, Point point2, boolean fill, Graphics g, String userName) {
		super(color, point1, point2, fill, g, userName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawShape(Graphics g) {
		g.setColor(color);
		if (isFill())
			g.fillRect(point1.getX(), point1.getY(), point2.getX(), point2.getX());
		else
			g.drawRect(point1.getX(), point1.getY(), point2.getX(), point2.getX());
	}

}
