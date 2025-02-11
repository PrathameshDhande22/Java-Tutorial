package observer;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

// It is mostly used in Swing application 
class SwingApp {
	private JFrame jframe;

	public SwingApp() {
		jframe = new JFrame("Swing Example");
		jframe.setVisible(true);
		jframe.setBounds(new Rectangle(50, 50, 400, 400));

	}

	public void defineButton() {
		JButton button = new JButton("Click Me");
		button.setBounds(10, 10, 50, 30);
		jframe.add(button);

		// we are subscribing the observer when the button is clicked.
		button.addActionListener(new AngelListener());
	}

}

// These is the observer 
class AngelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

}

public class SwingApplication {

	public static void main(String[] args) {
		SwingApp app = new SwingApp();
		app.defineButton();
	}

}
