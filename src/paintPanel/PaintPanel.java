package paintPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import component.Circle;
import component.Ellipse;
import component.Line;
import component.Point;
import component.Rectangle;
import component.Shape;
import component.Square;
import component.TestShape;
import createShape.ShapeCreator;
import dataBase.Sql;
import dataBase.changeToObject.ChangeObject;
import main.MainFrame;

public class PaintPanel extends JPanel {

	/**
	 * 
	 */
	private Graphics graphicsForDrawing;
	private static Point startPoint;
	private Color colorToDraw = MainFrame.getColor();
	private String userName;
	

	public String getUserName() {
		return userName;
	}
	

	private ArrayList<Shape> graphics = new ArrayList<>();

	public void clearShapeList() {
		graphics.clear();
	}

	public static void setStartPoint(Point startPoint) {
		PaintPanel.startPoint = startPoint;
	}

	public static void setEndPoint(Point endPoint) {
		PaintPanel.endPoint = endPoint;
	}

	public static Point getStartPoint() {
		return startPoint;
	}

	static Point endPoint;

	public static Point getEndPoint() {
		return endPoint;
	}

	public Color getColorToDraw() {
		return colorToDraw;
	}

	public void setColorToDraw(Color colorToDraw) {
		this.colorToDraw = colorToDraw;
	}

	private static final long serialVersionUID = -7779958891210294697L;
	
	public PaintPanel(String userName) {
		this();
		this.userName = userName;
	}
	public PaintPanel() {
		super.setBackground(Color.white);
		setStartPoint(new Point(0, 0));
		setEndPoint(new Point(0, 0));

		initialize();

	}

	private void initialize() {
		super.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (e.getX() >= 0 || e.getY() >= 0 || e.getX() <= getWidth() || e.getY() <= getHeight()) {
					setEndPoint(new Point(e.getX(), e.getY()));
				} else {
					return;
				}

//				update(getGraphics());
//				repaint();

				// paintComponent(graphicsForDrawing);
				//
				// drawDraggedShape();
				graphicsForDrawing.dispose();
//				graphicsForDrawing = null;

				// graphicsForDrawing = null;
				// graphicsForDrawing.dispose();
				// graphicsForDrawing = null;

				// repaint();

			}
		});
		super.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				setStartPoint(new Point(e.getX(), e.getY()));
				setColorToDraw(MainFrame.getColor());
				// setEndPoint(new Point(e.getX(), e.getY()));
				graphicsForDrawing = getGraphics();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getX() >= 0 || e.getY() >= 0 || e.getX() <= getWidth() || e.getY() <= getHeight()) {
					setEndPoint(new Point(e.getX(), e.getY()));
				} else {
					return;
				}

				graphics.add(drawShape());
				
				
				graphics.get(graphics.size() - 1);
				
					new Sql(new ChangeObject(graphics.get(graphics.size() - 1),graphics.size()).getShapeString());
				
				graphicsForDrawing.dispose();
				graphicsForDrawing = null;

				// repaint();
				// getGraphics() = null;

				// addingShape(new ShapeCreator(startPoint, endPoint, MainFrame.getColor(),
				// MainFrame.getShapeToDraw()));
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				setEndPoint(new Point(e.getX(), e.getY()));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// g.setColor(MainFrame.getColor());

		// drawShape();
		// if(!graphics.contains(g)) {
		// graphics.add(g);}
		// System.out.println(graphics.size());

		// g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(),
		// endPoint.getY());
		// g.drawRect(startPoint.getX(), startPoint.getY(), endPoint.getX(),
		// endPoint.getY());
		// g.drawArc(startPoint.getX(), startPoint.getY(), endPoint.getX(),
		// endPoint.getY(), 0, 360);
//		 repaint();

	}
	@Override
	public void update( Graphics g )
	{
	  paint( g );
	}

	private Shape drawShape() {
		Shape paintingShape = null;
		graphicsForDrawing = getGraphics();
		String shape = MainFrame.getShapeToDraw();
		setColorToDraw(MainFrame.getColor());
		graphicsForDrawing.setColor(getColorToDraw());
		if (shape == null)
			shape = "Line";
		switch (shape) {
		case "Circle":
			paintingShape = new Circle(getColorToDraw(), getStartPoint(), getEndPoint(), graphicsForDrawing,getUserName());
			break;
		case "Rectangle":
			paintingShape = new Rectangle(getColorToDraw(), getStartPoint(), getEndPoint(), graphicsForDrawing,getUserName());
			break;
		case "Ellipse":
			paintingShape = new Ellipse(getColorToDraw(), getStartPoint(), getEndPoint(), graphicsForDrawing,getUserName());
			break;
		case "Square":
			paintingShape = new Square(getColorToDraw(), getStartPoint(), getEndPoint(), graphicsForDrawing,getUserName());
			break;
		case "Line":
			paintingShape = new Line(getColorToDraw(), getStartPoint(), getEndPoint(), graphicsForDrawing,getUserName());
			// g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(),
			// endPoint.getY());
			break;

		default:
			break;
		}
		return paintingShape;
	}


}