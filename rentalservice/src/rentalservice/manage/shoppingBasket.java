package rentalservice.manage;






import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import rentalservice.user.MainLayout;
import rentalservice.shoes.shoes2nd;
import rentalservice.user.DBConn;

@SuppressWarnings("serial")
public class shoppingBasket extends JPanel implements MouseListener, ItemListener {
   Font fnt = new Font("굴림체", Font.BOLD, 14);
   Font titleFnt = new Font("굴림체", Font.BOLD, 32);
   JLabel titleLbl1 = new JLabel("장바구니 확인");
   String flightStr[] = { "상품", "상품명", "금액", "사이즈", "수량",  "취소"};

   JTable table1;
   JScrollPane sp1;
   DefaultTableModel model1;
   JCheckBox check1 = new JCheckBox("", false);
   JLabel lbl1 = new JLabel("상기 내용을 확인하고 예약을 진행합니다.");
   JLabel titleLbl2 = new JLabel("수령인 정보");
   String passengerStr[] = { "성명(한)", "성명(영)", "우편번호", "주소", "생년월일", "연락처", "이메일"};
   JTable table2;
   JScrollPane sp2;
   DefaultTableModel model2;
   JCheckBox check2 = new JCheckBox("", false);
   JLabel lbl2 = new JLabel("해당 정보를 확인하세요. 위 내용은 예약 완료 후 변경이 불가합니다.");
   JLabel titleLbl3 = new JLabel("결제 내역");
   String paymentStr[] = { "결제예정금액" };
   JTable table3;
   JScrollPane sp3;
   DefaultTableModel model3;
   JCheckBox check3 = new JCheckBox("", false);
   JLabel lbl3 = new JLabel("상기 내용을 확인하고 결제를 진행합니다.");
   JCheckBox check4 = new JCheckBox("", false);
   JLabel bookingConfirmLbl = new JLabel("예약 변경 및 취소 규정을 확인해주세요.");
   JButton payBtn = new JButton("결제하기");
   JButton cancelBtn = new JButton("취  소");

   //이벤트용 변수
   int allSelected = 0;
   int paymentWindowState = 0;
   int paymentState = 0;

   // 결제창에 넘길 값
   int result = 0;

   public shoppingBasket() {
      setLayout(null);
      this.setBackground(Color.white);

      //table1 장바구니 확인
      add(titleLbl1).setBounds(390, 60, 230, 50);
      titleLbl1.setFont(titleFnt);
      model1 = new DefaultTableModel(flightStr, 0);



      // 테이블1에 데이터 넣는부분


     Object [] newRow1 = shoppingBasketDAO.getData1();
     model1.addRow(newRow1);
      table1 = new JTable(model1);
      //



      sp1 = new JScrollPane(table1);
      sp1.getViewport().setBackground(Color.white);
      add(sp1).setBounds(100,110, 800,100);
      add(check1).setBounds(100, 217, 17, 17);
      check1.setBackground(Color.white);
      add(lbl1).setBounds(120, 215, 400, 25);
      lbl1.setFont(fnt);

       //table2 수령인 정보
      add(titleLbl2).setBounds(410, 230, 200, 50);
      titleLbl2.setFont(titleFnt);
      model2 = new DefaultTableModel(passengerStr, 0);
      table2 = new JTable(model2);
      sp2 = new JScrollPane(table2);
      add(sp2).setBounds(100,280, 800, 100);
      sp2.getViewport().setBackground(Color.white);
      add(check2).setBounds(100, 387, 17,17);
      check2.setBackground(Color.white);
      check2.setEnabled(false);
      add(lbl2).setBounds(120, 385, 470, 25);
      lbl2.setFont(fnt);

      // 테이블2에 데이터 넣는부분
      String[] data2 = shoppingBasketDAO.getData2();
       model2.addRow(data2);
       table2 = new JTable(model2);
       //

      //table3 결제정보
      add(titleLbl3).setBounds(425, 410, 200, 50);
      titleLbl3.setFont(titleFnt);
      model3 = new DefaultTableModel(paymentStr,0);
      table3 = new JTable(model3);
      sp3 = new JScrollPane(table3);
      add(sp3).setBounds(300,460, 400, 100);
      sp3.getViewport().setBackground(Color.white);
      add(check3).setBounds(300, 566, 17, 17); //283
      check3.setBackground(Color.white);
      check3.setEnabled(false);
      add(lbl3).setBounds(320, 565, 400, 25); //310
      lbl3.setFont(fnt);

    //   테이블3에 데이터 넣는부분
      Object [] newRow3 = shoppingBasketDAO.getData3();
      model3.addRow(newRow3);
       table3 = new JTable(model3);


      add(check4).setBounds(300,580, 17, 45);
      check4.setEnabled(false); //예약 변경/취소 규정을 눌러서 확인해야 활성화
      check4.setBackground(Color.white);
      add(bookingConfirmLbl).setBounds(320,590, 420,27);
      bookingConfirmLbl.setFont(fnt);

      //buttons
      add(payBtn).setBounds(370, 630, 100, 30);
      payBtn.setFont(fnt);
      payBtn.setBackground(new Color(0,130,255));
      payBtn.setForeground(Color.white);
      payBtn.setEnabled(false);
      add(cancelBtn).setBounds(530, 630, 100, 30);
      cancelBtn.setFont(fnt);
      cancelBtn.setBackground(new Color(0,130,255));
      cancelBtn.setForeground(Color.white);
      setSize(1000, 800);
      setVisible(true);

      //이벤트
      check1.addItemListener(this);
      check2.addItemListener(this);
      check3.addItemListener(this);
      check4.addItemListener(this);
      bookingConfirmLbl.addMouseListener(this);
      payBtn.addMouseListener(this);
      payBtn.setEnabled(false);
      cancelBtn.addMouseListener(this);

   }



//      // 출발지, 도착지, 출발일, 출발시간, 도착시간, 항공편명, 좌석, 운임
//      // "상품", "상품명", "사이즈", "단가", "수량", "금액", "취소"
//      String productImg = (String) vo2.productImg.getImage();  //상품이미지
//      String productName = (String) vo2.productName;  //상품명
//      String productSize =(String) vo2.productSizeCombo.getSelectedItem(); // 사이즈
//      int productPrice = vo2.productPrice; // 단가
//      int productCount = (int)vo2.productCountCombo.getSelectedItem(); // 수량
//      int productSumPrice = productPrice*productCount; // 금액=단가*수량
//      JButton productDeleteBtn = new JButton("삭제"); // 취소버튼
//
//      Object startflightlst[] = {productImg,productName,productSize,productPrice,productCount,productSumPrice,productDeleteBtn};
//      model1.setRowCount(0);
//      model1.addRow(startflightlst);
//
      ////////////////////////////////////// 예약정보/////////////////////////////////
      //성명(한), 성명(영), 우편번호, 주소, 생년월일, 연락처, 이메일
//      for(int i=0; i<userinfoRevise.lst.size();i++){
//         vo3 =userinfoRevise.lst.get(i);
//         Object Data1[] = {vo3.getUser_name(),vo3.getUser_ename(),vo3.getUser_passno(),vo3.getUser_exdate(),vo3.getUser_birth(),vo3.getUser_tel(),vo3.getUser_email()};
//         model2.setRowCount(0);
//         model2.addRow(Data1);
//      }
//
//   }

   @Override
   public void itemStateChanged(ItemEvent ie) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
         if (ie.getItem() == check1) {
            check2.setEnabled(true);
         } else if (ie.getItem() == check2) {
            check3.setEnabled(true);
         } else if (ie.getItem() == check4) {
            payBtn.setEnabled(true);
            allSelected = 1;
         }
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      Object obj = e.getSource();
//      if (obj instanceof JButton) {
//         String btnStr = ((JButton) obj).getText();
//         if (btnStr.equals("삭제")) {
//            JOptionPane.showMessageDialog(this, "선택하신 상품을 삭제합니다");
//            model1.removeRow(startflightlst);
//         }
//      }
      if (obj instanceof JButton) {
         String btnStr = ((JButton) obj).getText();
         if (btnStr.equals("결제하기")) {
            if (allSelected == 0) {
               JOptionPane.showMessageDialog(this, "모든 내용을 확인해주세요");
            } else if (allSelected != 0) {
               if (paymentWindowState == 0) {
                  new CustomPayment();
                  paymentWindowState = 1;
               }
            }
         } else if (btnStr.equals("취  소")) {
            this.setVisible(false);
            MainLayout.productList.setVisible(true);
            MainLayout.centerPane.add(MainLayout.productList);
         }
      }
   }

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      Object obj = e.getSource();
      if (obj instanceof JLabel) {
         String lblName = ((JLabel) obj).getText();
         if (lblName.equals("예약 변경 및 취소 규정을 확인해주세요."))
            ;
         JOptionPane.showMessageDialog(this,"예약 변경/취소 규정을 확인했습니다. \n 체크박스를 선택해주세요.");
         check4.setEnabled(true);
      }
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
   }





   //////////////////////////////////////////////////////////////
   // 결제창 ////////////////////////////////////////////////////////////////

   class CustomPayment extends JFrame implements ActionListener,MouseListener,WindowListener {
      Font fnt = new Font("굴림체", Font.BOLD, 14);
      JLabel amountLbl1 = new JLabel("총 가격");
      JLabel amountLbl2 = new JLabel("570000");
      JLabel wonLbl = new JLabel("원");
      JLabel paymentLbl = new JLabel("결제수단");
      String paymentStr[] = {"카드결제", "계좌이체"};
      JComboBox<String> paymentBox;
      JLabel cardNumLbl = new JLabel("카드번호");
      JTextField cardNumTf = new JTextField(20);
      JLabel bankLbl = new JLabel("우리은행");
      JLabel numLbl = new JLabel("0001-010-05-0002");
//      JLabel mileageLbl1 = new JLabel("적립 마일리지");
//      JLabel mileageLbl2 = new JLabel("570");
//      JLabel mileageLbl3 = new JLabel("등급명");
//      JLabel mileageLbl4 = new JLabel("보유 마일리지");
//      JLabel mileageLbl5 = new JLabel("3800");
      JButton payBtn = new JButton("결제");
      JButton cancelBtn = new JButton("취소");

      public CustomPayment() {
         setLayout(null);
         this.setBackground(Color.white);
         //

// 배열 -> 문자열
         amountLbl2.setText(Arrays.toString(shoppingBasketDAO.getData3())+"");


//         Arrays.stream(shoppingBasketDAO.getData3()).mapToInt(Integer::parseInt).toArray()
//         mileageLbl2.setText((int) (result * 0.01) + "");
//         mileageLbl5.setText(CustomMyPage.mileage + "");

         add(amountLbl1).setBounds(60, 100, 80, 25);
         amountLbl1.setFont(fnt);
         add(amountLbl2).setBounds(200, 100, 100, 25);
         amountLbl2.setFont(fnt);
         add(wonLbl).setBounds(270, 100, 20, 25);
         wonLbl.setFont(fnt);

         add(paymentLbl).setBounds(60, 130, 80, 25);
         paymentLbl.setFont(fnt);
         paymentBox = new JComboBox<String>(paymentStr);
         add(paymentBox).setBounds(200, 130, 100, 25);
         paymentBox.setFont(fnt);
         paymentBox.setBackground(Color.white);

         add(cardNumLbl).setBounds(60, 160, 80, 25);
         cardNumLbl.setFont(fnt);
         add(cardNumTf).setBounds(200, 160, 160, 25);
         cardNumTf.setFont(fnt);
         cardNumTf.setBackground(Color.white);
         add(bankLbl).setBounds(60, 160, 80, 25);
         bankLbl.setFont(fnt);
         bankLbl.setVisible(false);
         add(numLbl).setBounds(200, 160, 160, 25);
         numLbl.setFont(fnt);
         numLbl.setVisible(false);

//         add(mileageLbl1).setBounds(60, 190, 100, 25);
//         mileageLbl1.setFont(fnt);
//         add(mileageLbl2).setBounds(200, 190, 60, 25);
//         mileageLbl2.setFont(fnt);
//         add(mileageLbl4).setBounds(60, 220, 100, 25);
//         mileageLbl4.setFont(fnt);
//         add(mileageLbl5).setBounds(200, 220, 80, 25);
//         mileageLbl5.setFont(fnt);

         add(payBtn).setBounds(75, 320, 100, 30);
         payBtn.setFont(fnt);
         payBtn.setBackground(new Color(0, 130, 255));
         payBtn.setForeground(Color.white);
         add(cancelBtn).setBounds(220, 320, 100, 30);
         cancelBtn.setFont(fnt);
         cancelBtn.setBackground(new Color(0, 130, 255));
         cancelBtn.setForeground(Color.white);

         setSize(400, 450);
         setVisible(true);
         setResizable(false);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

         // 이벤트
         paymentBox.addActionListener(this);
         payBtn.addMouseListener(this);
         cancelBtn.addMouseListener(this);
         addWindowListener(this);
      }

      @Override
      public void actionPerformed(ActionEvent ae) {
         Object obj = ae.getSource();
         if (obj instanceof JComboBox) {
            String comboItem = (String) paymentBox.getSelectedItem();
            System.out.println(comboItem);
            if (comboItem.equals("계좌이체")) {
               cardNumLbl.setVisible(false);
               bankLbl.setVisible(true);
               cardNumTf.setVisible(false);
               numLbl.setVisible(true);
            } else if (comboItem.equals("카드결제")) {
               bankLbl.setVisible(false);
               cardNumLbl.setVisible(true);
               numLbl.setVisible(false);
               cardNumTf.setVisible(true);
            }
         }
      }

      @Override
      public void mouseClicked(MouseEvent me) {
         Object obj = me.getSource();
         if(obj instanceof JButton) {
            String btnName = ((JButton) obj).getText();
            if(btnName.equals("결제")) {
//               if(CustomFrame.reservation6.setData()==0) {
//                  JOptionPane.showMessageDialog(this, "정보입력이 잘못되었습니다 \n 올바른 정보를 입력후 다시 결제 하시기 바랍니다");
//               } else {
                  JOptionPane.showMessageDialog(this, "결제가 완료되었습니다");
//                  this.setVisible(false);
//                  CustomFrame.reservation5.setVisible(false);
//                  CustomFrame.reservation6.setVisible(true);
//                  CustomFrame.reservation6.getData();
//                  setMileage();
//                  CustomFrame.centerPane.add(CustomFrame.reservation6);
//               }
            }else if(btnName.endsWith("취소")){
               JOptionPane.showMessageDialog(this, "결제를 취소했습니다");
               this.setVisible(false);
            }
         }
      }
      //// 멈춤

//      public void setMileage() {
//         CustomReservaion6DAO dao = new CustomReservaion6DAO();
//         dao.plusMileage(Integer.valueOf((int) (result * 0.01)),
//               AirlineMain.idField.getText());
//      }


      //


      @Override
      public void windowOpened(WindowEvent e) {
         paymentWindowState = 1;
      }

      @Override
      public void windowClosing(WindowEvent e) {
         paymentWindowState = 0;
      }

      @Override
      public void windowClosed(WindowEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void windowIconified(WindowEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void windowDeiconified(WindowEvent e) {
      // TODO Auto-generated method stub
      }

      @Override
      public void windowActivated(WindowEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void windowDeactivated(WindowEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub
      }
      @Override
      public void mouseReleased(MouseEvent e) {
         // TODO Auto-generated method stub
      }
      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub
      }
   }
}

