package createShape;

import java.awt.Color;

import component.*;

public class ShapeCreator {
	private Shape shape = null;
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	public ShapeCreator(Point p1, Point p2,Color color, String shape) {
		if(shape == null)
			shape = "Line";
		switch (shape) {
		case "Circle":
			setShape(new Circle(color, p1, p2));
			
			break;
		case "Rectangle":
			setShape(new Rectangle(color, p1, p2));
			
			break;
		case "Ellipse":
			setShape(new Ellipse(color, p1, p2));
			
			break;
		case "Square":
			setShape(new Square(color, p1, p2));
			
			break;
		case "Line":
			setShape(new Line(color, p1, p2));
			
			break;

		default:
			break;
		}
	}
	

}
