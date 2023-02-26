package swing;
import java.awt.Color;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
public class Word_highlight2 extends javax.swing.JFrame {

    public Word_highlight2() {
      
    }
    
    class MyHighlighterPainter extends DefaultHighlighter.DefaultHighlightPainter{
        public MyHighlighterPainter(Color color){
            super(color);
        }
            
        }
       Highlighter.HighlightPainter myhighlighter = new MyHighlighterPainter(Color.red);
       public void removeHighlight(JTextComponent textcmp){
            Highlighter hg = textcmp.getHighlighter();
            Highlighter.Highlight [] highlites = hg.getHighlights();
            for(int i=0;i<highlites.length;i++){
                if(highlites[i].getPainter() instanceof MyHighlighterPainter){
                    hg.removeHighlight(highlites[i]);
                }
            }
       }
     public void highlight(JTextComponent textcmp, String pattern){
         removeHighlight(textcmp);
            try{
                Highlighter hg = textcmp.getHighlighter();
                Document doc = textcmp.getDocument();
                String text = doc.getText(0, doc.getLength());
                int pos = 0;
                while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(), pos))>=0){
                    hg.addHighlight(pos, pos+pattern.length(), myhighlighter);
                    pos+=pattern.length();
                    
                }
                
            }catch(Exception e){
           
            }
    }
}
