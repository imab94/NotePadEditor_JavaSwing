package swing;
import java.awt.Color;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
public class Word_highlight extends javax.swing.JFrame {

    public Word_highlight() {
    	Search_Button = new javax.swing.JButton();
        search_Text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextAreacmp = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Search_Button.setText("Search");
        Search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_ButtonActionPerformed(evt);
                
            }
        });

        JTextAreacmp.setColumns(20);
        JTextAreacmp.setRows(5);
        jScrollPane1.setViewportView(JTextAreacmp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
     
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

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
                           

    private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
      highlight(JTextAreacmp,search_Text.getText());
      
        
    }                                             

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
              
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea JTextAreacmp;
    private javax.swing.JButton Search_Button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search_Text;
    // End of variables declaration                   

}
