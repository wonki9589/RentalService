package rentalservice.shoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import rentalservice.manage.Recipient;
import rentalservice.user.MainLayout;

@SuppressWarnings("serial")
public class shoes2nd extends JPanel implements ActionListener {
	 int j =1;
	int i = 1;
	 String shoesSize;
	 String shoesQuantity;
	 JLabel imgLbl;

	ImageIcon logo = new ImageIcon("./img/1.jpg");
	ImageIcon[] img = new ImageIcon[] { new ImageIcon("./img/dior.jpg"), new ImageIcon("./img/dior2.jpg"),
			new ImageIcon("./img/dior3.jpg"), new ImageIcon("./img/dior4.jpg") };
	// 이미지 배열 선언
	 String prodname =  "DIOR JODAN";
	 String prodprice = "300000";



	 String[] option = { "DIOR JODAN" };
	String[] size = { "220", "230", "240", "250", "260", "270", "280", "290" };
	String[] quantity = { "1","2","3","4","5","6","7","8","9","10"}; // 셀렉트 박스 선언2
	// 셀렉트 박스 선언

	public static shoes productList = new shoes();
	public static Recipient recipient = new Recipient();

	   shoes1stDAO dao = new shoes1stDAO();
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	   JComboBox strCombo2 = new JComboBox(size);   // 신발사이즈
	   @SuppressWarnings({ "rawtypes", "unchecked" })
	   JComboBox strCombo3 = new JComboBox(quantity);   // 수량


	public shoes2nd() {

		 this.setSize(1000, 800);
	       this.setVisible(false);
	      this.setLayout(new BorderLayout());




		// 패널 선언
		JPanel Panel0 = new JPanel();	//나이키로고
		JPanel Panel1 = new JPanel();
			JPanel Panel11 = new JPanel();	//이미지
			JPanel Panel12 = new JPanel();	//넘기기버튼
		JPanel Panel2 = new JPanel();
			JPanel Panel21 = new JPanel();	//상품설명
			JPanel Panel22 = new JPanel();	//상품명, 사이즈 선택박스
		JPanel Panel3 = new JPanel();	// 주문하기, 메인으로이동 버튼




		// 보더레이아웃으로 각 패널 위치 설정
		this.add(Panel0, BorderLayout.NORTH);
		this.add(Panel1, BorderLayout.WEST);
			Panel1.add(Panel11, BorderLayout.NORTH);
			Panel1.add(Panel12, BorderLayout.SOUTH);
		this.add(Panel2, BorderLayout.EAST);
			Panel2.add(Panel21, BorderLayout.NORTH);
			Panel2.add(Panel22, BorderLayout.SOUTH);
		this.add(Panel3, BorderLayout.SOUTH);




		// 패널 크기 설정
		Panel0.setPreferredSize(new Dimension(1000, 150));	//(로고패널) 가로 1000, 세로 150
		Panel1.setPreferredSize(new Dimension(400, 500));	//(좌패널) 가로 400, 세로 500
			Panel11.setPreferredSize(new Dimension(400, 350));
			Panel12.setPreferredSize(new Dimension(400, 150));
		Panel2.setPreferredSize(new Dimension(600, 500));	//(우패널)가로 600, 세로 500
			Panel21.setPreferredSize(new Dimension(600, 350));
			Panel22.setPreferredSize(new Dimension(600, 150));
		Panel3.setPreferredSize(new Dimension(1000, 150));	//(하단패널) 가로 1000, 세로 150




		// 내부공백(padding)
		Panel0.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 700));	// 위 왼쪽 아래 오른쪽
		Panel3.setBorder(BorderFactory.createEmptyBorder(0, 600, 0, 0));




		// 각 패널에 집어넣기

		// [Panel0] 로고
		JLabel imglogo = new JLabel(logo);
		Panel0.add(imglogo);

		// [Panel11] 상품이미지
		imgLbl = new JLabel(img[0]);
		Panel11.add(imgLbl);

		// [Panel12] 버튼 이벤트 = 이미지 변경
		Panel12.add(new changeimg());

		// [Panel21] 상품설명
		JLabel textLbl = new JLabel();
		textLbl.setText("<html><br><h1>DIOR JODAN<h1><html>" + "<html><h3>유명 명품 브랜드 크리스챤 디올과 나이키의 협업으로 탄생한 운동화이며"
				+ "<br>높은 인기로 출시 후에도 1000만원이라는 높은 가격에 거래되고 있는 신발입니다.<br><br></h3>" + "<br> <h2>렌탈을 희망하신다면 옵션을 선택해주세요</h2><html>");
		Panel21.add(textLbl);

		// [Panel22] 상품셀렉트 박스 선언
		JLabel textLbl1 = new JLabel();
		textLbl1.setText("상품명");
		Panel22.add(textLbl1);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox strCombo = new JComboBox(option);	// 상품명
		Panel22.add(strCombo);

		JLabel textLbl2 = new JLabel();
		textLbl1.setText("사이즈");
		Panel22.add(textLbl2);
		Panel22.add(textLbl2);
	    Panel22.add(strCombo2);   // 신발사이즈 체크박스


	    JLabel textLbl3 = new JLabel();
	      textLbl3.setText("수량");
	      Panel22.add(textLbl3);
	      Panel22.add(strCombo3);   // 신발수량 체크박스

		JButton shoppingbutton = new JButton("장바구니 담기");	// 장바구니담기
		Panel22.add(shoppingbutton);

		// [Panel3] 메인셀렉트 박스 선언
		JButton orderbutton = new JButton("주문하기");	// 주문하기
		Panel3.add(orderbutton);

		JButton homebutton = new JButton("메인으로 이동");	// 메인으로 이동
		Panel3.add(homebutton);




		//이벤트 등록
		orderbutton.addActionListener(this);
		homebutton.addActionListener(this);
		strCombo2.addActionListener(this);
	      strCombo3.addActionListener(this);


	}


	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();


		  shoesSize = strCombo2.getSelectedItem().toString();
	      System.out.println("신발사이즈 => " + shoesSize);

	      shoesQuantity = strCombo3.getSelectedItem().toString();
	      System.out.println("신발수량 => " + shoesQuantity);


		if (obj instanceof JButton) {

			String click = e.getActionCommand();
			if (click.equals("주문하기")) {


				this.setVisible(false);
				MainLayout.recipient.setVisible(true);
				MainLayout.centerPane.add(MainLayout.recipient);

				  shoes1stVO vo = new shoes1stVO(
                          Integer.toString(j),
                          prodname,
                          prodprice,
                          shoesQuantity.toString(),
                          shoesSize.toString()
        );

				  dao.ReservationInsert(vo);
				  System.out.println("데이터 잘들어갔네1111");
				  j++;




			} else if (click.equals("메인으로 이동")) {

				this.setVisible(false);
				MainLayout.productList.setVisible(true);
				MainLayout.centerPane.add(MainLayout.productList);

			}
		}
	}


	// 이미지 변경을 위한 클래스 선언
	class changeimg extends JPanel {
		public changeimg() {

			// 이미지 변경을 위한 버튼 선언
			JButton lastProduct = new JButton("◀");
			JButton nextProduct = new JButton("▶");
			this.add(lastProduct);
			this.add(nextProduct);


			lastProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (i == -1) {
						i = 3;
					}
					imgLbl.setIcon(img[i]);
					i--;

				}
			});

			nextProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (i == 4) {
						i = 0;
					}

					imgLbl.setIcon(img[i]);
					i++;
				}
			});
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


