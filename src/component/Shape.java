package component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import component.newComponent.Drawable;

public abstract class Shape extends JComponent {
	
	
	public Point getPoint1() {
		return point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public Color getColor() {
		return color;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 2304365597987251527L;
	protected Point point1;
	protected Point point2;
	protected Color color;
	protected String userName;
	public String getUserName() {
		return userName;
	}
	protected Graphics graphic;
	protected Drawable drawShape = new Drawable();
	public Shape(Color color, Point point1, Point point2, Graphics g, String userName) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.color = color;
		this.userName = userName;
		this.graphic = g;
		drawShape(g);
	}
	public Graphics getGraphic() {
		return graphic;
	}
	public abstract void drawShape(Graphics g);
	
	


}
