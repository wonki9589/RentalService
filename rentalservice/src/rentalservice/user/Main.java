package rentalservice.user;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import rentalservice.user.LoginDAO;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener{
	Font titleFnt = new Font("휴먼둥근헤드라인",Font.BOLD,32);
	Font fnt = new Font("굴림체",Font.BOLD,14);
	JPanel mainPane = new JPanel();
	JPanel loginPane = new JPanel();
	JPanel topPane = new JPanel();
	JLabel loginTitle = new JLabel("SHOEREN");
	JPanel centerPane = new JPanel();
	//이미지
	static ImageIcon icon = new ImageIcon("images/running.png");
	static Image im = icon.getImage();
	Image im2 = im.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
	ImageIcon icon2 = new ImageIcon(im2); JLabel lbl = new JLabel(icon2);
	JPanel southPane = new JPanel();
	JPanel southCenterPane = new JPanel();
	JPanel idPane = new JPanel();
	JLabel idLbl = new JLabel("USERNAME");
	public static JTextField idField = new JTextField(20);
	JPanel pwdPane = new JPanel();
	JLabel pwdLbl = new JLabel("PASSWORD");
	JPasswordField pwdField = new JPasswordField(20);
	JPanel btnPane = new JPanel();
	JButton joinBtn = new JButton("회원가입");
	JButton loginBtn = new JButton("로그인");
	JPanel mainSouthPane = new JPanel();
	ShoesMoving move = new ShoesMoving();


	public Main() {
		//////////////////////////레이아웃////////////////////////
		add(mainPane);
		// 메인 패널 레이아웃 그리드백레이아웃
		mainPane.setLayout(new GridBagLayout());
		//그리드백 제약사항을 정의
		GridBagConstraints gbc = new GridBagConstraints();
		// 전체를 그리드백레이웃으로 채운다
		gbc.fill = GridBagConstraints.BOTH;
		// moving
		gbc.weightx=1.0;
		gbc.weighty=1.5;
		gbc.gridx=0; gbc.gridy=0;
		mainPane.add(move,gbc);
		// grid top
		gbc.weightx=1.0;
		gbc.weighty=0.5;
		gbc.gridx=0;
		gbc.gridy=1;
		mainPane.add(loginPane,gbc);
		loginPane.setLayout(new BorderLayout());
		loginPane.add(loginTitle);
		// 제목 폰트 설정
		loginTitle.setFont(titleFnt);
		loginTitle.setHorizontalAlignment(JLabel.CENTER);
		// loginTitle.setVerticalAlignment(JLabel.BOTTOM);
		loginPane.setBackground(Color.white);
		// grid center
		gbc.weightx=1.0;
		gbc.weighty=3.0;
		gbc.gridx=0;
		gbc.gridy=2;
		mainPane.add(centerPane,gbc);
		centerPane.setLayout(new BorderLayout());
		centerPane.add(lbl);
		centerPane.setBackground(Color.white);
		//grid south
		gbc.weightx=1.0;
		gbc.weighty=2.0;
		gbc.gridx=0;
		gbc.gridy=3;
		mainPane.add(southPane,gbc);
		southCenterPane.setLayout(new GridLayout(3,1));
		// 아이디 패널
		southCenterPane.add(idPane);
		idPane.add(idLbl);
		idPane.add(idField);
		idPane.setFont(fnt);
		idPane.setBackground(Color.white);
		//패스워드 패널
		southCenterPane.add(pwdPane);
		pwdPane.add(pwdLbl);
		pwdPane.add(pwdField);
		pwdPane.setFont(fnt);
		pwdPane.setBackground(Color.white);
		// 회원가입 로그인 버튼 패널
		southCenterPane.add(btnPane);
		btnPane.add(joinBtn);
		joinBtn.setBackground(new Color(0,130,255));
		joinBtn.setForeground(Color.white);
		btnPane.add(loginBtn);
		loginBtn.setBackground(new Color(0,130,255));
		loginBtn.setForeground(Color.white);
		btnPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnPane.setBackground(Color.white);
		southPane.add(southCenterPane);
		southPane.setBackground(Color.white);
		southCenterPane.setBackground(Color.white);
		// 전체화면 풀릴경우 기본화면 크기
		setResizable(false);
		setSize(1000,800);
		// 화면 보이기 여부
		setVisible(true);
		// 자원해제, 끄기
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 타이틀
		setTitle("CLOUD AIR");
		setIconImage(im);
		// 이벤트
		joinBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		// 키 이벤트 (로그인)
		pwdField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER) {
					getLoginData();
					}
				}
			});
		//////////////무브 클래스 사이즈와 바탕 정의////////
		move.setBackground(Color.white);
		move.getFrameSize();
		Thread t1 = new Thread(move);
		t1.start();
		/////////////////////////////////
		}
	////////////////////////// 이벤트 등록//////////////////////
	public void actionPerformed(ActionEvent ae) {
		Object eventBtn = ae.getSource();
		if(eventBtn==joinBtn) {
			dispose();
			new SignUp();
			} else if(eventBtn==loginBtn) {
				getLoginData();
				}
		}
	////////////////////////// 로그인 db //////////////////////
	@SuppressWarnings("deprecation")
	public void getLoginData() {
		String user_id = idField.getText();
		String user_pwd = pwdField.getText();
		String admin[] = {"ghdrlfehd"}; //홍길동
		LoginDAO dao = new LoginDAO();
		int customLogin = 0;
		for(int i=0;i<admin.length;i++) {
			if(user_id.equals(admin[i])) {
				int loginCheck = dao.getLogin(user_id, user_pwd);
				if(loginCheck == 0)
					JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
				else if(loginCheck==1) {
					customLogin = 1; dispose();
//					Thread sta = new Thread(new EmpMainFrame());
//					sta.start(); break;
				}
			}
		}
		if(customLogin==0) {
			if(user_id.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다");
			} else if(user_pwd.equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하셔야 합니다.");
			} else {
				int loginCheck = dao.getLogin(user_id, user_pwd);
				if(loginCheck == 0) JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
				else if(loginCheck ==1 ) {
					dispose(); // main 종료
					Thread sta = new Thread((Runnable) new MainLayout());
					sta.start();// MainLayout 시작
					}
				}
			}
		}
	

	public static void main(String[]args) {
		new Main();
	}
}
