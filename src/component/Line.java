package component;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	public Line(Color color, Point point1, Point point2,boolean fill, Graphics g,String userName) {
		super(color, point1, point2,fill, g, userName);
		
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		
		g.drawLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
	}

	
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//	}

}