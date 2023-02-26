package swing;
import javax.swing.*;
//import java.util.Date;
import java.awt.*;
//import java.awt.Graphics;
//import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;
//import javax.swing.text.Utilities;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import swing.Word_highlight.MyHighlighterPainter;
public class NotePad extends JFrame implements ActionListener {
	public  static JTextArea note_area = new JTextArea();
	public static JTextField status = new JTextField();

	public JScrollPane scroll;
JPanel	middlepane = new JPanel();
UndoManager editmanager = new UndoManager();


	public JMenuBar menubar;
	public JMenu file_menu, edit_menu ,prefer, help;
	public JMenuItem new_mi, open_mi,mi_save, exit_mi,undo,redo,cut,paste,save_as_mi,sett_mi, font_mi,theme_mi,color_mi
	,documt_mi, update,normal_theme,dark_theme,light_theme,classic_theme,copy,select_all;
	public JMenuItem red_col,green_col,blue_col,black_col,pink_col,orange_col,cyan_col,gray_col,yellow_col,time_mi,replaceAll,find;
	KeyStroke undoKeyStroke  = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK);
	KeyStroke redoKeyStroke  = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK);
	FontHelper font_help;
	public NotePad(Color red)
	{
		super();
	}
	public NotePad(String msg) throws BadLocationException {	
	super(msg);	
	add(note_area);
//	JTextPane textPane = new JTextPane();
//	JScrollPane scrollPane = new JScrollPane(textPane);
   	 scroll =new JScrollPane(note_area);
//   	TextLineNumber tln = new TextLineNumber(textPane);
//   	scrollPane.setRowHeaderView( tln );
	 scroll.setBounds(3, 3, 300, 200);
	 add(scroll);
	 font_help = new FontHelper();
	menubar = new JMenuBar();
	setJMenuBar(menubar);
	file_menu = new JMenu("File");
	edit_menu = new JMenu("Edit");
	prefer = new JMenu("Preferences");
	help = new JMenu("Help");
	new_mi = new JMenuItem("New...");
	open_mi = new JMenuItem("Open");
	mi_save  =new JMenuItem("Save   Ctrl+S");
	save_as_mi=new JMenuItem("Save As..");
	exit_mi = new JMenuItem("Exit..");
	undo = new JMenuItem("Undo");
	redo = new JMenuItem("Redo");
	cut = new JMenuItem("Cut");
	copy = new JMenuItem("Copy   Ctrl+C");
	paste = new JMenuItem("Paste    Ctrl+V");
	select_all = new JMenuItem("Select All   Ctrl+A");
	sett_mi = new JMenuItem("Setting");
	font_mi= new JMenuItem("Font");
	theme_mi= new JMenu("Theme...");
	normal_theme = new JMenuItem("Normal");
	dark_theme = new JMenuItem("Dark");
	light_theme = new JMenuItem("Light");
	classic_theme = new JMenuItem("Classic");
	color_mi = new JMenuItem("Font Color...");
	documt_mi = new JMenuItem("Documentation");
	update = new JMenuItem("Update");
	time_mi = new JMenuItem("Time..");
	replaceAll = new JMenuItem("Replace All");
	find = new JMenuItem("Find");

	file_menu.add(new_mi);
	file_menu.add(open_mi);
	file_menu.add(mi_save);
	file_menu.add(save_as_mi);
	file_menu.add(exit_mi);
	edit_menu.add(undo);
	edit_menu.add(redo);
	edit_menu.add(cut);
	edit_menu.add(copy);
	edit_menu.add(paste);
	edit_menu.add(select_all);
	menubar.add(file_menu);
	menubar.add(edit_menu);
	menubar.add(prefer);
	menubar.add(help);
	prefer.add(sett_mi);
	prefer.add(font_mi);
	prefer.add(theme_mi);
	prefer.add(color_mi);
	help.add(documt_mi);
	help.add(update);
	help.add(time_mi);
	help.add(find);
	help.add(replaceAll);
	theme_mi.add(normal_theme);
	theme_mi.add(light_theme);
	theme_mi.add(dark_theme);
	theme_mi.add(classic_theme);
	
	
	new_mi.addActionListener(this);
	open_mi.addActionListener(this);
	exit_mi.addActionListener(this);
	mi_save.addActionListener(this);
	save_as_mi.addActionListener(this);
	undo.addActionListener(this);
	documt_mi.addActionListener(this);
	theme_mi.addActionListener(this);
    dark_theme.addActionListener(this);
	light_theme.addActionListener(this);
	normal_theme.addActionListener(this);
	classic_theme.addActionListener(this);
	color_mi.addActionListener(this);
	copy.addActionListener(this);
	paste.addActionListener(this);
	cut.addActionListener(this);
	font_mi.addActionListener(this);
	select_all.addActionListener(this);
	time_mi.addActionListener(this);
	find.addActionListener(this);
	Font font = new Font("Arial",Font.PLAIN, 12);
	note_area.setFont(font);
	note_area.setForeground(Color.BLACK);
	font_mi.addActionListener( new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			font_help.setVisible(true);
		}
	});
	font_help.getOk().addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			note_area.setFont(font_help.font());
			font_help.setVisible(false);
			
		}
	});
	font_help.getCancel().addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			font_help.setVisible(false);
			
		}
	});
		
	}
	
	@SuppressWarnings("serial")
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String act =  ae.getActionCommand();
		if(act.equals(new_mi.getLabel())) {
			if(note_area.getText()!=null) {
				note_area.setText("");
				Font font = new Font("Arial",Font.PLAIN, 12);
				note_area.setFont(font);
				note_area.setForeground(Color.BLACK);
			
			}
			
		}
		else if(act.equals(open_mi.getLabel())) {
			
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			File file = jfc.getSelectedFile();
			try(FileInputStream fis = new FileInputStream(file.getAbsolutePath());){
				int i;
				while((i = fis.read())!=-1){
					note_area.append(""+(char)i);
			} 
			}
			catch (Exception e) {	
				}
		}
			else if(act.equals(exit_mi.getLabel())){
				int choice = JOptionPane.showConfirmDialog(this,"Are you Sure want to Exit.." );
				if(choice  ==0) {
					System.exit(0);
				
			}
			}
			else if(act.equals(documt_mi.getLabel())){
				NewClass nc = new NewClass();
				
			}
			else if(act.equals(time_mi.getLabel())) {
				  new TimeDate().setVisible(true);
			}
			else if(act.equals(find.getLabel())) {
				 Word_highlight th =  new Word_highlight();
				 th.setVisible(true);
				 
				  
//			//	String name = JOptionPane.showInputDialog(this,"Search Word..?");
////			Word_highlight gh = new Word_highlight();
////				//gh.setVisible(true);
//		JFrame j=new JFrame();
//				j.setLayout(new GridLayout(6, 10));
//				j.setSize(300,200);
//				j.setLocation(100, 100);
//				j.setResizable(false);
//				j.setVisible(true);
////				JButton b=new JButton("Search");
////				JTextField t=new JTextField(10);
////				j.add(t);
////				j.add(b);
//////				
////				b.setBounds(10	,10,30	,30);
////				t.setBounds(5, 5, 10,10);
//				JButton Search_Button = new javax.swing.JButton();
//			    JTextField    search_Text = new javax.swing.JTextField();
//			    
//			    j.add(search_Text);
//			    j.add(Search_Button);
//			        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//			        Search_Button.setText("Search");
//			      /*  Highlighter.HighlightPainter np = (HighlightPainter) new NotePad(Color.red);*/
//			        Search_Button.addActionListener(new java.awt.event.ActionListener() {
//			            public void actionPerformed(java.awt.event.ActionEvent evt) {
//			                try {
//							//	Search_ButtonActionPerformed(evt);
//			                	Word_highlight2 wh=new Word_highlight2();
//			                	wh.highlight(note_area, search_Text.getText());
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//			            }
//
//						private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) throws BadLocationException{
//							// TODO Auto-generated method stub
//							highlight(note_area, search_Text.getText());
//							
//							
//						}
//
//						public void highlight(JTextComponent textcmp, String pattern) {
//							// TODO Auto-generated method stub
//							 removeHighlight(textcmp);
//					            try{
//					                Highlighter hg = textcmp.getHighlighter();
//					                Document doc = textcmp.getDocument();
//					                String text = doc.getText(0, doc.getLength());
//					                int pos = 0;
//					                while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(), pos))>=0){
//					                    hg.addHighlight(pos, pos+pattern.length());
//					                    pos+=pattern.length();
//					                    
//					                }
//					                
//					            }catch(Exception e){
//					           
//					            }
//							
//						}
//
//						public void removeHighlight(JTextComponent textcmp) {
//							// TODO Auto-generated method stub
//							 Highlighter hg = textcmp.getHighlighter();
//					            Highlighter.Highlight [] highlites = hg.getHighlights();
//					            for(int i=0;i<highlites.length;i++){
//					                if(highlites[i].getPainter() instanceof MyHighlighterPainter){
//					                    hg.removeHighlight(highlites[i]);
//					                }
//					            }
//							
//						}
//			        });
			}
			else if(act.equals(normal_theme.getLabel())) {
					note_area.setBackground(Color.WHITE);
					Font font = new Font("Arial",Font.PLAIN, 12);
					note_area.setFont(font);
					
					note_area.setForeground(Color.BLACK);
				}
			else	if(act.equals(dark_theme.getLabel())) {
					note_area.setBackground(Color.BLACK);
					Font font = new Font("Arial",Font.PLAIN, 12);
					note_area.setFont(font);
					note_area.setForeground(Color.WHITE);
			}
			else	if(act.equals(light_theme.getLabel())) {
				note_area.setBackground(Color.LIGHT_GRAY);
				Font font = new Font("Arial",Font.PLAIN, 12);
				note_area.setFont(font);
				note_area.setForeground(Color.BLACK);
		}
			else if(act.equals(classic_theme.getLabel())) {
				note_area.setBackground(Color.MAGENTA);
				Font font = new Font("Arial",Font.PLAIN, 12);
				note_area.setFont(font);
				note_area.setForeground(Color.BLACK);
			}
			else if(act.equals(color_mi.getLabel()))
			{
				DemoColorChosser cc=new DemoColorChosser();
				Color newco=JColorChooser.showDialog(this, "selectorColor",Color.BLUE);
				if(newco !=null)
				{
					note_area.setForeground(newco);
				}
			}
	
			else  if(act.equals(copy.getLabel()))
			{
				note_area.copy();
			}
			else  if(act.equals(cut.getLabel()))
			{
				note_area.cut();
			}
			else  if(act.equals(paste.getLabel()))
			{
				note_area.paste();
			}
			else  if(act.equals(select_all.getLabel()))
			{
				note_area.selectAll();;
			}
				else if(act.equals(mi_save.getLabel())) {
					JFileChooser jfc = new JFileChooser();
					jfc.showSaveDialog(this);
					File save_file=jfc.getSelectedFile();
						String text_data = note_area.getText();
						 try (FileOutputStream dis = new FileOutputStream(save_file);)
						 {		
							  dis.write(text_data.getBytes());
							}
		catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
				else if(act.equals(save_as_mi.getLabel())) {
					JFileChooser jfc = new JFileChooser();
					jfc.showDialog(this,"Save_as");
					File save_file=jfc.getSelectedFile();
						String text_data = note_area.getText();
						 try (FileOutputStream dis = new FileOutputStream(save_file);)
						 {		
							  dis.write(text_data.getBytes());
							}
		catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				else  if(act.equals(undo.getLabel())) {
			Document document  = note_area.getDocument();
		document.addUndoableEditListener(new UndoableEditListener() {
					@Override
					public void undoableEditHappened(UndoableEditEvent arg0) {
							// TODO Auto-generated method stub
							
							editmanager.addEdit(arg0.getEdit());
						}
					});
					undo.addActionListener((ActionEvent e)  -> {
						try {
							editmanager.undo();
						}
						catch(CannotUndoException cue) {
							
						}
					});
				}
					note_area.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(undoKeyStroke,"undoKeyStroke" );
					note_area.getActionMap().put("undoKeyStroke", new AbstractAction() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							try {
								editmanager.undo();
							}catch (CannotUndoException cue) {
								
							}
						}
					});
				}
	}


	
	

