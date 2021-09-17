package rentalservice.user;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.List;

import rentalservice.manage.Deposit;
import rentalservice.manage.Recipient;
import rentalservice.manage.shoppingBasket;
import rentalservice.manage.userinfoRevise;
import rentalservice.shoes.shoes;
import rentalservice.shoes.shoes1st;
import rentalservice.shoes.shoes2nd;
import rentalservice.shoes.shoes3rd;
import rentalservice.shoes.shoes4th;
import rentalservice.shoes.shoes5th;
import rentalservice.shoes.shoes6th;

@SuppressWarnings("serial")
public class MainLayout extends JFrame implements ActionListener, MouseListener  {
	//상단패널
	JPanel northPane = new JPanel();
		JPanel northNPane = new JPanel();
		JPanel northCPane = new JPanel();
		JPanel northSPane = new JPanel();
		static JLabel hiLbl = new JLabel("______님 어서오세요");
		JLabel resLbl = new JLabel("상 품 보 기");
		JLabel searchLbl = new JLabel("장 바 구 니");
		JLabel mypageLbl = new JLabel("마 이 페 이 지");
		JLabel logoutLbl = new JLabel("로 그 아 웃");
		JPopupMenu myPop = new JPopupMenu();
			JMenuItem my_page = new JMenuItem("마이페이지");
			JMenuItem deposit = new JMenuItem("보증금");
			JMenuItem memberInformationItem = new JMenuItem("회원정보 수정");
	String title[] = {"_______님 어서오세요","상품보기","장바구니","마이페이지","로그아웃"};
	Font fnt = new Font("굴림체",Font.BOLD,15);

	//중앙 패널
	public static JPanel centerPane = new JPanel();
		public static shoes productList = new shoes(); //상품리스트
			public static shoes1st productList1 = new shoes1st();
			public static shoes2nd productList2 = new shoes2nd();
			public static shoes3rd productList3 = new shoes3rd();
			public static shoes4th productList4 = new shoes4th();
			public static shoes5th productList5 = new shoes5th();
			public static shoes6th productList6 = new shoes6th();
				public static Recipient recipient = new Recipient();	//예약자
		public static shoppingBasket reservation = new shoppingBasket(); // 장바구니

													// 마이페이지 - 마이페이지 아직 구현안함
		static Deposit userDeposit = new Deposit(); // 마이페이지 - 보증금											
		static userinfoRevise revise = new userinfoRevise(); // 마이페이지 - 회원정보 수정
	static JPanel visiblePane[] = {productList,userDeposit,revise};


	//하단 패널
	JPanel southPane = new JPanel();

	public MainLayout() {
		// 기본화면 레이아웃 =================================================
		setLayout(new BorderLayout());
		northPane.setLayout(new BorderLayout());
		northPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		northPane.add("North", northNPane);
		northNPane.setBackground(Color.white);
		northCPane.setLayout(new GridLayout(1, 5));
		northPane.add("Center", northCPane);

		// 북쪽 프레임 ======================================================
		northCPane.add(hiLbl);
			hiLbl.setOpaque(true);
			hiLbl.setBackground(Color.white);
			hiLbl.setFont(fnt);
			hiLbl.setHorizontalAlignment(JLabel.CENTER);
			hiLbl.setForeground(new Color(0, 128, 255));
			customNameChange(); // 이름 세팅하는 메소드
		northCPane.add(resLbl);
			resLbl.setOpaque(true);
			resLbl.setFont(fnt);
			resLbl.setBackground(Color.white);
			resLbl.setHorizontalAlignment(JLabel.CENTER);
			resLbl.setForeground(new Color(0, 128, 255));
		northCPane.add(searchLbl);
			searchLbl.setOpaque(true);
			searchLbl.setFont(fnt);
			searchLbl.setBackground(Color.white);
			searchLbl.setHorizontalAlignment(JLabel.CENTER);
			searchLbl.setForeground(new Color(0, 128, 255));
		northCPane.add(mypageLbl);
			mypageLbl.setOpaque(true);
			mypageLbl.setFont(fnt);
			mypageLbl.setBackground(Color.white);
			mypageLbl.setHorizontalAlignment(JLabel.CENTER);
			mypageLbl.setForeground(new Color(0, 128, 255));
		northCPane.add(logoutLbl);
			logoutLbl.setOpaque(true);
			logoutLbl.setFont(fnt);
			logoutLbl.setBackground(Color.white);
			logoutLbl.setHorizontalAlignment(JLabel.CENTER);
			logoutLbl.setForeground(new Color(0, 0, 0));
		northPane.add("South", northSPane);
		northSPane.setBackground(Color.white);

		// 마이페이지 팝업메뉴 추가
		myPop.add(my_page);
		myPop.add(deposit);
		myPop.add(memberInformationItem);
		add("North", northPane);

		// 중앙 프레임 ======================================================
		add("Center", centerPane);
		centerPane.setBackground(Color.white);
		centerPane.setLayout(new BorderLayout());
		centerPane.add(productList);

		// 남쪽 프레임 ======================================================
		southPane.setLayout(new GridLayout(0,2));
		southPane.setBorder(new LineBorder(Color.lightGray, 1));
		add("South",southPane);

		// 프레임 기본 설정 ==================================================
		setTitle("SHOEREN");
		setResizable(false);
		setIconImage(Main.im);
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트 등록
		resLbl.addMouseListener(this);
		searchLbl.addMouseListener(this);
		mypageLbl.addMouseListener(this);
		logoutLbl.addMouseListener(this);

		deposit.addActionListener(this);
		memberInformationItem.addActionListener(this);
		my_page.addActionListener(this);

	}

	// _____님 어서오세요 라벨 변경
	public void customNameChange() {
		getUserNameDAO dao = new getUserNameDAO();
		String id = Main.idField.getText();
		List<getUserNameVO> name = dao.getName(id);
		for (int i = 0; i < name.size(); i++) {
			getUserNameVO vo = name.get(i);
			hiLbl.setText(vo.getUser_name() + "님 어서오세요");
		}
	}

	// 이벤트 ( 팝업메뉴아이템 )
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj instanceof JMenuItem) {
			// JMenuItem 일 경우
			String click = ae.getActionCommand();
			if (click.equals("마이페이지")) {
				visibleMethod();
				userDeposit.setVisible(true);
				centerPane.add(userDeposit);
			} else if (click.equals("보증금")) {
				visibleMethod();
				userDeposit.setVisible(true);
				centerPane.add(userDeposit);
			} else if (click.equals("회원정보 수정")) {
				visibleMethod();
				revise.setVisible(true);
				centerPane.add(revise);
			}
		}
	}

	// panel(들)을 visible(false)
	public static void visibleMethod() {
		for(int i=0;i<visiblePane.length;i++) {
			visiblePane[i].setVisible(false);
		}
	}

	// 마우스 이벤트(라벨)
	public void mouseClicked(MouseEvent me) {
		Object obj = me.getSource();
		 if((JLabel)obj instanceof JLabel) {
			 JLabel click =(JLabel)me.getSource();
			 String menuStr = click.getText();
			 if(click instanceof JLabel) {
				 if(menuStr.equals("상 품 보 기")) {
					 visibleMethod();
					 productList.setVisible(true);
					 centerPane.add(productList);
				 } else if(menuStr.equals("장 바 구 니")) {
					 visibleMethod();
					 reservation.setVisible(true);
					 centerPane.add(reservation);
				 } else if(menuStr.equals("마 이 페 이 지")) {
					 visibleMethod();
					 userDeposit.setVisible(true);
					 centerPane.add(userDeposit);
				 } else if(menuStr.equals("로 그 아 웃")) {
					 dispose();
					 new Main();
				 }
			 }
		 }
	}

	public void mouseReleased(MouseEvent me) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseEntered(MouseEvent me) {
		 Object obj = me.getSource();
		 if((JLabel)obj instanceof JLabel){
			 JLabel myLbl = (JLabel)me.getSource();
			 String mymenu= myLbl.getText();
			 if(mymenu.equals("마 이 페 이 지")) {
				 myPop.setVisible(true);
				 myPop.show(mypageLbl, me.getX(), me.getY());
			 } else {
				 myPop.setVisible(false);
			 }
		 }
	}
	public void	mouseExited(MouseEvent me) {}

	public static void main(String[] args) {
		Thread t1 = new Thread((Runnable) new MainLayout());
		t1.start();
	}


}
