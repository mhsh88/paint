package dataBase.changeToObject;

import java.awt.Color;
import java.awt.Graphics;

import component.Circle;
import component.Ellipse;
import component.Line;
import component.Point;
import component.Rectangle;
import component.Shape;
import component.Square;
import main.MainFrame;

public class ChangeObject {

	private Point point1;
	private Point point2;
	private Color color;
	private String type;
	private String[] shapeString = new String[9];
	private boolean fill;
	private Shape shape;
	private int order;
	private String userName;

	public String[] getShapeString() {
		return this.shapeString;
	}

	public ChangeObject() {

	}

	public ChangeObject(Shape shape, int order) {
		this.order = order;
		getShapeParameter(shape);
		setString();

	}

	private void getShapeParameter(Shape shape) {

		this.point1 = shape.getPoint1();
		this.point2 = shape.getPoint2();
		this.color = shape.getColor();
		this.fill = shape.isFill();
		this.type = shape.getClass().getSimpleName().toString();
		this.userName = shape.getUserName();

	}

	public void setShape(String[] shapeString) {

		switch (shapeString[0]) {
		case "Circle":

			break;
		case "Line":
			break;
		case "Ellipse":
			break;
		case "Rectangle":
			break;
		case "Square":
			break;

		default:
			break;
		}
	}

	public Shape getShape() {
		if (shape != null)
			return this.shape;
		return null;
	}

	public void setString() {
		this.shapeString[0] = this.type;
		this.shapeString[1] = Integer.toString(this.color.getRGB());
		this.shapeString[2] = Boolean.toString(this.fill);
		this.shapeString[3] = Integer.toString(this.point1.getX());
		this.shapeString[4] = Integer.toString(this.point1.getY());
		this.shapeString[5] = Integer.toString(this.point2.getX());
		this.shapeString[6] = Integer.toString(this.point2.getY());
		this.shapeString[7] = Integer.toString(this.order);
		this.shapeString[8] = this.userName;
	}

	public Shape setObject(String[] shapeString, Graphics graphics)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.shapeString = shapeString;
		Shape paintingShape = null;
		Color color = new Color(Integer.parseInt(shapeString[1]));
		boolean fill = Boolean.parseBoolean(shapeString[3]);
		Point point1 = new Point(Integer.parseInt(shapeString[4]), Integer.parseInt(shapeString[5]));
		Point point2 = new Point(Integer.parseInt(shapeString[6]), Integer.parseInt(shapeString[7]));
		String userName = shapeString[8];

		// this.shape.color = new Color(this.shapeString[1]);
		graphics.setColor(color);
		switch (shapeString[0]) {
		case "Circle":
			paintingShape = new Circle(color, point1, point2, fill,graphics, userName);
			break;
		case "Rectangle":
			paintingShape = new Rectangle(color, point1, point2, fill,graphics, userName);
			break;
		case "Ellipse":
			paintingShape = new Ellipse(color, point1, point2, fill,graphics, userName);
			break;
		case "Square":
			paintingShape = new Square(color, point1, point2, fill,graphics, userName);
			break;
		case "Line":
			paintingShape = new Line(color, point1, point2, fill,graphics, userName);
			// g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(),
			// endPoint.getY());
			break;

		default:
			break;
		}
		return paintingShape;
	}

}
