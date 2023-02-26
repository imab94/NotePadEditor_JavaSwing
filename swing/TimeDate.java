package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TimeDate extends JFrame {
    int day, month,year;
    public TimeDate() {
        initComponents();
       setResizable(false);
        showtime();
        setTitle("Time AND Date");
    }
    void showtime(){
     
        new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   	   
                Date d  = new Date();
                GregorianCalendar cd  =new GregorianCalendar();
                day = cd.get(Calendar.DAY_OF_MONTH);
                month = cd.get(Calendar.MONTH);
                year = cd.get(Calendar.YEAR);
                SimpleDateFormat s =new SimpleDateFormat("hh:mm:s a");
                time.setText(s.format(d)+"  " +"\n"+day+"/"+(month+1)+"/"+year+"");
           }
        }).start();
        
    }
          
    private void initComponents() {

        time = new javax.swing.JLabel();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        time.setFont(new java.awt.Font("Noto Sans", 3, 28)); // NOI18N
      
        time.setForeground(new java.awt.Color(25, 46, 225));
    	time. setBackground(new java.awt.Color(255,0,0));
        time.setText("                          ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimeDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JLabel time;
    // End of variables declaration                   
}
