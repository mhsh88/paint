package component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class TestShape extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.drawLine(50, 59, 40, 60);
	}

}
