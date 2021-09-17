package rentalservice.shoes;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import rentalservice.user.MainLayout;

@SuppressWarnings("serial")
public class shoes extends JPanel  implements ActionListener{
   JButton button1 = new JButton();
   JButton button2 = new JButton();
   JButton button3 = new JButton();
   JButton button4 = new JButton();
   JButton button5 = new JButton();
   JButton button6 = new JButton();

   ImageIcon img1 = new ImageIcon("./img/back_to_the_future.jpg");
   ImageIcon img2 = new ImageIcon("./img/dior.jpg");
   ImageIcon img3 = new ImageIcon("./img/maesyard.jpg");
   ImageIcon img4 = new ImageIcon("./img/paranoise.png");
   ImageIcon img5 = new ImageIcon("./img/strangelove.jpg");
   ImageIcon img6 = new ImageIcon("./img/travis-scott2.jpg");

   static shoes1st productList1 = new shoes1st();
   static shoes2nd productList2 = new shoes2nd();
   static shoes3rd productList3 = new shoes3rd();
   static shoes4th productList4 = new shoes4th();
   static shoes5th productList5 = new shoes5th();
   static shoes6th productList6 = new shoes6th();

   public shoes() {

      this.setSize(1000, 800);
      this.setLayout(new FlowLayout());
      setComponents();
      this.setVisible(true);

   }


   private void setComponents() {

      button1 = new JButton(img1);
      button1.setPreferredSize(new Dimension(300, 300));
      this.add(button1);
      button1.addActionListener(this);

      button2 = new JButton(img2);
      button2.setPreferredSize(new Dimension(300, 300));
      this.add(button2);
      button2.addActionListener(this);

      button3 = new JButton(img3);
      button3.setPreferredSize(new Dimension(300, 300));
      this.add(button3);
      button3.addActionListener(this);

      button4 = new JButton(img4);
      button4.setPreferredSize(new Dimension(300, 300));
      this.add(button4);
      button4.addActionListener(this);

      button5 = new JButton(img5);
      button5.setPreferredSize(new Dimension(300, 300));
      this.add(button5);
      button5.addActionListener(this);

      button6 = new JButton(img6);
      button6.setPreferredSize(new Dimension(300, 300));
      this.add(button6);
      button6.addActionListener(this);



   }
   @Override
   public void actionPerformed(ActionEvent me) {
      JButton btn = (JButton) me.getSource();
      if(btn==button1) {
    	  this.setVisible(false);
    	  MainLayout.productList1.setVisible(true);
		  MainLayout.centerPane.add(MainLayout.productList1);
      }
       if(btn==button2) {
    	   this.setVisible(false);
     	  MainLayout.productList2.setVisible(true);
 		  MainLayout.centerPane.add(MainLayout.productList2);
       }
       if(btn==button3) {
    	   this.setVisible(false);
     	  MainLayout.productList3.setVisible(true);
 		  MainLayout.centerPane.add(MainLayout.productList3);
       }
       if(btn==button4) {
    	   this.setVisible(false);
     	  MainLayout.productList4.setVisible(true);
 		  MainLayout.centerPane.add(MainLayout.productList4);
       }
       if(btn==button5) {
    	   this.setVisible(false);
     	  MainLayout.productList5.setVisible(true);
 		  MainLayout.centerPane.add(MainLayout.productList5);
       }
       if(btn==button6) {
    	   this.setVisible(false);
     	  MainLayout.productList6.setVisible(true);
 		  MainLayout.centerPane.add(MainLayout.productList6);
       }
   }



   public static void main(String[] args) {
      JFrame frame = new JFrame("JPanel상속");
      shoes jPanelFrameTest = new shoes();
      frame.getContentPane().add(jPanelFrameTest);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}