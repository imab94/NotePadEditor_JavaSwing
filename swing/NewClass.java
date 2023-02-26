package swing;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class NewClass extends JFrame{
	
	public NewClass() {
		JLabel label = new JLabel();
		label.setText("");
		setSize(800,600);
		setLocation(200,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Documentation");
		setResizable(false);
	}
	public void paint(Graphics g) {
		int fontsize=18;
		g.setColor(Color.red);
	//	g.setFont(g.getFont().deriveFont(18f));
		g.setFont(new Font("TimesRoman",Font.BOLD,fontsize));
		g.drawString("Editing is brutal", 30, 40);

	}

}
