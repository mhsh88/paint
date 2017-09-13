package colorChooser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;

public class ColorChooser_01 extends JFrame {
	/**
	 * 
	 */
	static Color color = Color.black;
	private static final long serialVersionUID = 3806403457870231826L;
	private JLabel sampleText = new JLabel("Label");
	private JButton chooseButton = new JButton("Choose Color");

	public static void main(String[] args) {
		new ColorChooser_01();
	}

	public ColorChooser_01() {
		this.setSize(300, 100);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		sampleText.setBackground(null);
		panel1.add(sampleText);

		chooseButton.addActionListener(new ButtonListener());
		panel1.add(chooseButton);

		this.add(panel1);
//		this.setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = JColorChooser.showDialog(null, "Choose a Color", sampleText.getForeground());
			if (c != null) {
				sampleText.setForeground(c);
				ColorChooser_01.color = c;
				MainFrame.setColor(ColorChooser_01.getColor());
			}
		}
	}
	public static Color getColor() {
		return ColorChooser_01.color;
	}
}
