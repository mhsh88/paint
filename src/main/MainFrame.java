package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import colorChooser.ColorChooser_01;
import paintPanel.PaintPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4946853945833366492L;
	private JPanel contentPane;
	static ColorChooser_01 setColor;
	static Color color = Color.black;
	static String shapeToDraw;
	private String userName;

	public String getUserName() {
		return this.userName;
	}
	private void setUserName(String userName) {
		this.userName = userName;
	}

	public static String getShapeToDraw() {
		return shapeToDraw;
	}

	public static void setShapeToDraw(String shapeToDraw) {
		MainFrame.shapeToDraw = shapeToDraw;
	}

	public static Color getColor() {
		return MainFrame.color;
	}

	public static void setColor(Color color) {
		MainFrame.color = color;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("admin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */


	public MainFrame(String userName) {
		setUserName(userName);
		setVisible(true);
		setColor = new ColorChooser_01();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		System.out.println("this is in main Frame " + getUserName());
		PaintPanel panel_1 = new PaintPanel(getUserName());

		contentPane.add(panel_1);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 5, 0, 0));

		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shapeToDraw = btnLine.getText();
			}
		});
		panel.add(btnLine);

		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shapeToDraw = btnCircle.getText();
				// System.out.println(shapeToDraw);
			}
		});
		panel.add(btnCircle);

		JButton btnEllipse = new JButton("Ellipse");
		btnEllipse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				shapeToDraw = btnEllipse.getText();
			}
		});
		panel.add(btnEllipse);

		JButton btnSquare = new JButton("Square");
		btnSquare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shapeToDraw = btnSquare.getText();
			}
		});
		panel.add(btnSquare);

		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shapeToDraw = btnRectangle.getText();
			}
		});
		panel.add(btnRectangle);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.repaint();
				panel_1.clearShapeList(getUserName());
				
			}
		});
		panel.add(btnClear);

		JButton btnColor = new JButton("Color");
		panel.add(btnColor);

		JButton btnFill = new JButton("Fill");
		panel.add(btnFill);
		btnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				setColor.setVisible(true);
				setColor(ColorChooser_01.getColor());

			}

		});
	}

}
