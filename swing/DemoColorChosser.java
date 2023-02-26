package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DemoColorChosser {
	
	
	public DemoColorChosser()
	{
		Runnable r=new Runnable()
		{
			
			@Override
			public void run() {
				final JColorChooser selectorColor =new JColorChooser();
				final JLabel lb=new JLabel("TEXT",JLabel.CENTER);
			selectorColor.setBorder(BorderFactory.createTitledBorder("Selection of color"));
			final JLabel vista=new JLabel("Notepad",JLabel.CENTER);
			vista.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,48));
			vista.setSize(vista.getPreferredSize());
			vista.setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
			selectorColor.setPreviewPanel(vista);
				
			}
		};
		
		EventQueue.invokeLater(r);

	}

}
