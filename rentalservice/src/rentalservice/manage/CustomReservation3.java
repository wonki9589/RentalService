package rentalservice.manage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;

import rentalservice.shoes.shoes;
import rentalservice.user.MainLayout;

@SuppressWarnings("serial")
public class CustomReservation3 extends JPanel implements ActionListener{
	Font fnt = new Font("굴림체",Font.BOLD,14);
	Font titleFnt = new Font("굴림체",Font.BOLD,24);
	JPanel main = new JPanel();
	JPanel wrapPane = new JPanel();
	JPanel lblPane= new JPanel();
	JLabel titleLbl = new JLabel("수령자 정보입력");

	JPanel hanPane = new JPanel();
	JLabel hanLbl = new JLabel("수령자 성명(한) ");
	JTextField hanField = new JTextField(30);

	JPanel engPane = new JPanel();
	JLabel engLbl = new JLabel("수령자 성명(영어) ex) Hong GilDong");
	JTextField engField = new JTextField(30);

	JPanel zipcodePane = new JPanel();
	JLabel zipcodeLbl = new JLabel("우편번호 ex) 12345");
	JTextField zipcodeField = new JTextField(30);

	JPanel addressPane = new JPanel();
	JLabel addressLbl = new JLabel("주소 ex) 충청남도 천안시 동남구 대흥로 215");
	JTextField addressField = new JTextField(30);

	JPanel birthPane = new JPanel();
	JLabel birthLbl = new JLabel("생년월일 ex) 19950807");
	JTextField birthField = new JTextField(30);

	JPanel genderPane = new JPanel();
	JLabel genderLbl = new JLabel("성별");
	String gender[] = {"F","M"};

	DefaultComboBoxModel<String> genderModel = new DefaultComboBoxModel<String>(gender);
	JComboBox<String> genderCombo = new JComboBox<String>(genderModel);
	JPanel telPane = new JPanel();
	JLabel telLbl = new JLabel("연락처 ex) 010-1234-5678");
	JTextField telField = new JTextField(30);

	JPanel emailPane = new JPanel();
	JLabel emailLbl = new JLabel("이메일 ex) hong123@naver.com");
	JTextField emailField = new JTextField(30);

	JPanel checkPane = new JPanel();
	JCheckBox checkBox = new JCheckBox();
	JLabel checkStr = new JLabel("해당 정보를 맞게 입력하셨나요? 위 내용은 예약 완료 후 변경이 불가합니다");
	JLabel checkStr2 = new JLabel("정보 변경을 희망할 경우 예약취소를 하시고 다시 시도해주시기 바랍니다");
	int c = 0;
	JPanel buttonPane = new JPanel();
	JButton nextBtn = new JButton("저  장");
	JButton cancelBtn = new JButton("취  소");
	JPanel[] pane = {hanPane,engPane,zipcodePane,addressPane,birthPane,telPane,emailPane};
	JLabel[] lbl = {hanLbl,engLbl,zipcodeLbl,addressLbl,birthLbl,telLbl,emailLbl};
	JTextField[] tf = {hanField,engField,zipcodeField,addressField,birthField,telField,emailField};

	static List<CustomReservation3VO> lst = new ArrayList<CustomReservation3VO>();

	public static shoes productList = new shoes();
	public static shoppingBasket reservation = new shoppingBasket();

	public CustomReservation3() {
		setLayout(new BorderLayout());
		add(main);
		main.setLayout(new BorderLayout(200,0));
		main.add("North",new JLabel());
		main.add("East",new JLabel());
		main.add("West",new JLabel());
		main.add("South",new JLabel());
		main.setBackground(Color.white);
		main.add(wrapPane);
		wrapPane.setLayout(new GridLayout(12,1));
		wrapPane.setBackground(Color.white);
		wrapPane.add(titleLbl);
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
		titleLbl.setOpaque(true);
		titleLbl.setBackground(Color.white);
		titleLbl.setFont(titleFnt);
		for(int i=0; i<pane.length;i++) {
			wrapPane.add(pane[i]);
			pane[i].setLayout(new BorderLayout(0,15));
			pane[i].setBackground(Color.white);
			pane[i].add("North",new JLabel());
			pane[i].add("South",new JLabel());
			pane[i].add("West", lbl[i]);
			pane[i].add("East", tf[i]);
			lbl[i].setOpaque(true);
			lbl[i].setFont(fnt);
			lbl[i].setBackground(Color.white);
			lbl[i].setHorizontalAlignment(JLabel.CENTER);
			tf[i].setFont(fnt);
		}

		wrapPane.add(genderPane);
		genderPane.setLayout(new BorderLayout(0,15));
		genderPane.setBackground(Color.white);
		genderPane.add("South",new JLabel());
		genderPane.add("West",genderLbl);
		genderLbl.setFont(fnt);
		genderPane.add("East",genderCombo);
		genderCombo.setFont(fnt);
		genderCombo.setBackground(Color.white);

		wrapPane.add(checkPane);
		checkPane.setBorder(new LineBorder(Color.lightGray,1));
		checkPane.setBackground(Color.white);
		checkPane.setLayout(new BorderLayout(5,0));
		checkPane.add("West",checkBox);
		checkBox.setBackground(Color.white);
		JPanel checkLblPane = new JPanel();
		checkPane.add("Center",checkLblPane);
		checkLblPane.setBackground(Color.white);
		checkLblPane.add(checkStr);
		checkStr.setHorizontalAlignment(JLabel.RIGHT);
		checkStr.setBackground(Color.white);
		checkStr.setFont(fnt);
		checkLblPane.add(checkStr2);
		checkStr2.setHorizontalAlignment(JLabel.RIGHT);
		checkStr2.setBackground(Color.white);
		checkStr2.setFont(fnt);

		wrapPane.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		buttonPane.setBackground(Color.white);
		buttonPane.add(cancelBtn);
		cancelBtn.setFont(fnt);
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBackground(new Color(0,130,255));
		buttonPane.add(nextBtn);
		nextBtn.setEnabled(false);
		nextBtn.setFont(fnt);
		nextBtn.setForeground(Color.white);
		nextBtn.setBackground(new Color(0,130,255));

		setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);

		checkBox.addActionListener(this);
		cancelBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	}

	// 이벤트 등록
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj instanceof JButton) {
			String btn = ae.getActionCommand();
			if(btn.equals("취  소")) {
				// 전부 초기화
				for(int i=0; i<tf.length; i++) {
					tf[i].setText("");
				}
				setTrue();
				lst.removeAll(lst);
				titleLbl.setText("예약자 정보입력");
				hanLbl.setText("예약자 이름(한글) ");
				engLbl.setText("예약자 이름(영어) ex) Hong GilDong");
				checkBox.setSelected(false);
				nextBtn.setEnabled(false);
				c=0;
				MainLayout.productList.setVisible(true);
			} else if(btn.equals("저  장")) {
				// 다음을 누르면 장바구니 reservation을 세팅한다
				this.setVisible(false);
				MainLayout.reservation.setVisible(true);
				MainLayout.centerPane.add(MainLayout.reservation);
			}
		}
		if(obj instanceof JCheckBox) {
			if(c==0) {
				nextBtn.setEnabled(true);
				c++;
			} else if(c==1) {
				nextBtn.setEnabled(false);
				c--;
			}
		}
	}



	// 모든 필드, 콤보를 트루로 다시 바꾼다
	public void setTrue() {
		for(int i=0; i<tf.length; i++) {
			tf[i].setEnabled(true);
		}
		genderCombo.setEnabled(true);
	}
	// 모든 필드, 콤보를 펄스로 다시 바꾼다
	public void setFalse() {
		for(int i=0; i<tf.length; i++) {
			tf[i].setEnabled(false);
		}
		genderCombo.setEnabled(false);
	}




}