/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaperLand;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
/**
 *
 * @author anjal
 */
public class Sales extends javax.swing.JFrame implements ActionListener{
    int n,kk;
int X=0;
int z=0;
int a = 0;
int b = 0;
int tt=0;
int SalesID;
JTextArea  cbta;
JButton   cbb1;
JButton  cbb2;
int ss;
int   sxss ;
int s;
 JFrame  cb;
    /**
     * Creates new form Sales
     */
    public Sales() {
    
     initComponents();
         DateFormat dateFormat=new SimpleDateFormat("mm/dd/yyyy");
     Date date=new Date();
     jTextField7.setText("17/12/2017");
    //jTextField7.setText(dateFormat.format(date));
        //System.out.println(dateFormat.format(date));
    }
    
    
    
    
      public void close()
{

  WindowEvent winClosingEvent=new  WindowEvent(this, WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
    
    
     public void insert()
{
    try
    {
        Statement stmt;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "")) {
            stmt = conn.createStatement();
            String s1=jTextField1.getText();
            //String s2=jTextField2.getText();
            String s3=jTextField3.getText();
            String s4=jTextField5.getText();
            String s5=jTextField6.getText();
            String s6=jTextField7.getText();
            stmt.executeUpdate("insert into salest values('"+s6+"','"+s1+"','"+s3+"','"+s4+"','"+s5+"')");
        }
  stmt.close();
    }
         
   catch(SQLException e)
   {
   String ErrorMessage=e.getMessage();
   System.out.println(ErrorMessage);
   }
}
     
    public void updateP1()
{
    try{
     
         Statement sts;
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "") ;
         sts = conn.createStatement();
        String x = "select Quantity from product where P_Id='"+jTextField3.getText()+"'";
        String y = "select quantity from salest where SalesID ='"+jTextField1.getText()+"'";
        ResultSet results1 = sts.executeQuery(x);
        while(results1.next())
        {
            a = results1.getInt("Quantity");
        }
        ResultSet results2 = sts.executeQuery(y);
        while(results2.next())
        {
            b = results2.getInt("quantity");
        }
        int e  = a - b;
        String sqlU="update product set Quantity= '"+e+"' where P_Id='"+jTextField3.getText()+"'";
        sts.executeUpdate(sqlU);
        System.out.println("update executed");
        //sta3.append("\n\n   Product Successfully Updated!\n\n   Product ID: "+st1.getText()+"\n\n   Product quantity: "+e+"\n\n");
    }
    catch(SQLException e2)
    {
        //sta3.setText("\n\n   Error Occured");
        System.out.println(e2);
    }
} 
     
     
      
        public void generate()
{ 
    try{
        Statement sts;
       
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "") ;
        sts = conn.createStatement();
        String sql00="select MAX(SalesID) from SalesT";
        System.out.print(sql00);
        ResultSet results0 = sts.executeQuery(sql00);
        while(results0.next())
        {
           X = results0.getInt(1);
           System.out.print(X);
        }
        int ca = X+1;
          jTextField1.setText(Integer.toString(ca));
          System.out.print(ca);
        
    }
    catch(SQLException e)
    {
     
      System.out.println(e);
    }
}
   
        public void bill()
        {
        
        JPanel cb1=new JPanel ();
        cb=new JFrame("invoice"); 
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cb.setSize(300,370);
        cb.setBackground(Color.white);
        cb.setVisible(true);

        
        cb1.setLayout(null);
        cb1.setSize(300,370);
        cb1.setLocation(0,0);
        cb1.setBackground(Color.white);
        cb.add(cb1);

        cbta= new JTextArea();
        cbta.setLocation(5,5);
        cbta.setSize(275,250);
        cbta.setForeground(Color.BLACK);
        cbta.setBackground(Color.white);
        cbta.setFont(new Font("Arial",Font.PLAIN,17));
        cbta.setLineWrap(true);
        cbta.setWrapStyleWord(true);
        cb1.add(cbta);
        
        
        cbb1=new JButton("SAVE");
        cbb1.setLocation(10,280);
        cbb1.setSize(110,30);
        cbb1.setForeground(Color.BLACK);
        cbb1.setBackground(Color.gray);
        cb1.add(cbb1);

        cbb2=new JButton("BACK");
        cbb2.setLocation(160,280);
        cbb2.setSize(110,30);
        cbb2.setForeground(Color.BLACK);
        cbb2.setBackground(Color.gray);
        cb1.add(cbb2);

        cbb1.addActionListener((ActionListener)this);
        cbb2.addActionListener((ActionListener)this);

        
        
        }
        
@Override
        public void actionPerformed(ActionEvent aee)
        {
         if (aee.getSource()==cbb2)
        {
         cb.setVisible(false);
          }
         
          if (aee.getSource()==cbb1)
        {
         Save();
          }
         
        
        }
        
        
        
     public void genBillS()
    {
        try{
         
         
          Statement sts;
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "");
         sts = conn.createStatement();
         
            String t = "select MAX(SalesID) from salest";
            System.out.print(t);
            ResultSet resultt = sts.executeQuery(t);
            while(resultt.next())
            {
                tt = resultt.getInt(1);
            }
            String r = "select * from salest where SalesID='"+tt+"'";
            System.out.print(r);
            ResultSet resultx = sts.executeQuery(r);
            while(resultx.next())
            {
            cbta.append("\t CUSTOMER INVOICE\n");
            cbta.append("---------------------------------\n");
            SalesID = resultx.getInt(2);
             cbta.append("  Date: "+resultx.getString(1)+"\n" );
            cbta.append("   Sales ID : "+SalesID+"\n" );
           // cbta.append("   Customer ID: "+resultx.getString(3)+"\n" );
            cbta.append("   Product ID: "+resultx.getString(3)+"\n" );
            s = resultx.getInt(4);
            cbta.append("   Product Quantity: "+s+"\n" );
            ss = resultx.getInt(5);
            cbta.append("   Product Price: "+ss+"\n" );
            cbta.append("---------------------------------\n" );
            sxss = s*ss;
            cbta.append("   Total: "+sxss+"\n" );
            cbta.append("---------------------------------");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
     
        public void Save()
    {
        try{
                 
         
            boolean complete = cbta.print();
            if(complete)
            {
                JOptionPane.showMessageDialog(null, "Done Printing","Information",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Cancelled Printing!","Printer",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null,e);
        }
    } 
        
        
         public void searchP()
{
    try
    {   
         Statement sts;
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "") ;
         sts = conn.createStatement();
        String sql= "select * from product where P_Id='"+jTextField3.getText()+"'";
        System.out.print(sql);
        ResultSet results = sts.executeQuery(sql);
        while(results.next())
        {
            //sta3.append("\n"+"  Product ID:             "+results.getString(1)+"\n");
            //sta3.append("\n"+"  Product Name:           "+results.getString(2)+"\n");
            //sta3.append("\n"+"  Product Price:            "+results.getString(4)+"\n");
            jTextField4.setText(""+results.getString(2)+"");
            //st3.setText("'"+results.getString(3)+"'");
             sta3.append("\n\n"+" Current  Product Quantity:"+results.getString(3)+"\n");
             jTextField6.setText(""+results.getString(4)+"");
        }
        
        
        String sqlC= "select Quantity from product where P_Id='"+jTextField3.getText()+"'";
        System.out.print(sqlC);
        ResultSet Cresults = sts.executeQuery(sqlC);
        while(Cresults.next())
        {
            n = Cresults.getInt("Quantity");
            if (n<100)
            {
            JOptionPane.showMessageDialog(null, "Low stock available, Please re-stock");
            }
        }
        String sqlCc= "select Quantity from product  where P_Id='"+jTextField3.getText()+"'";
        System.out.print(sqlCc);
        ResultSet Ccresults = sts.executeQuery(sqlCc);
        while(Ccresults.next())
        {
            kk = Ccresults.getInt("Quantity");
        }
        System.out.print(kk);
    }
    
    
    catch(SQLException es)
    {
        sta3.setText("\n\n   PID does not exist");
        System.out.print(es);
    }
}        
        
        
        
        
        /*public void CheckP1()
{
    try{
        if (m<100)
        {
        JOptionPane.showMessageDialog(null, "Low stock available, please re-stock");
        }
    }
    catch(HeadlessException e2)
    {
       JOptionPane.showMessageDialog(null, "error occur");
        System.out.println(e2);
    }
}*/
        
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sta3 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Sales ID");

        jLabel3.setText("Product ID");

        jLabel4.setText("Product Name");

        jLabel5.setText("Quantity");

        jLabel6.setText("Price");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sells");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");

        sta3.setColumns(20);
        sta3.setRows(5);
        jScrollPane1.setViewportView(sta3);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaperLand/aab.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton4))
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        insert();
        updateP1();
    jTextField1.setText("");
  // jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    bill();
   genBillS();
    //CheckP1();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
generate();       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
searchP();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        close();
        Transaction t1=new Transaction();
        t1.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    jTextField1.setText("");
 //   jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextArea sta3;
    // End of variables declaration//GEN-END:variables
}
