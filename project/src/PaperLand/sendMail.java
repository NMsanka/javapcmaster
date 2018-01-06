/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaperLand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Nalaka
 */
public class sendMail {
    public List<String> list = new ArrayList<String>();
    public String stockloww;
    
    private static String USER_NAME = "";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = ""; // GMail password
    private static String RECIPIENT = "";
 
      
    
    public void a(){

            System.out.println(stockloww);
                    
    }
       
    
    public void sendFromGMail() {
       
        try{
      Statement stmt;
      String a;
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "");
      stmt = conn.createStatement();
      String sql = "SELECT P_Id FROM product WHERE Quantity<100";
      ResultSet result=stmt.executeQuery(sql);
      
      while(result.next()){
      
          a = result.getString("P_Id");
          list.add(a);
          System.out.println(list);
          stockloww = String.join(" , ", list);
          //stocklow.toString();
          //String stocklow = list.stream().map(e -> e.toString()).reduce("", String::concat);
          System.out.println(stockloww);
                
      
      }
     
      
      }
      catch(Exception eel){
          System.out.println(eel);
      
      
      
      }
             
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Stock Remainder PC Master";
        //String body = String.format("These Items Has reached to the minimum Level please re stock Item : %d",info);
        String body = "These Items Has reached to the minimum Level please re stock. Here are the Item IDs  :  " + stockloww;
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    
}
