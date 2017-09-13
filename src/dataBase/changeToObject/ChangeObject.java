package dataBase.changeToObject;

import java.awt.Color;


import component.Point;
import component.Shape;

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

	public ChangeObject(Shape shape,int order) {
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

}
