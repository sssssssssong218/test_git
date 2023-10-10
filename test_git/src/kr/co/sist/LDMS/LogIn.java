package kr.co.sist.LDMS;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class LogIn extends JDialog {
	private JPasswordField jpfPw;
	private JTextField jtfId;
	private ImageIcon loginBtnImage;
	private JButton jbtnLogIn;
	private JLabel jlblId; 
	private JLabel jlblPw;
	private JLabel jlbl;
	private String id;
	private LDMS ldms;
   
	public LogIn(LDMS ldms) { 
		super(ldms, "로그인", true);    
		setResizable(false);    
		this.ldms = ldms;
		// component 객체 생성
		loginBtnImage = new ImageIcon("c:/dev/workspace/jiha/src/kr/co/sist/LDMS/login btn_lil.png");
		jbtnLogIn = new JButton("로그인", loginBtnImage);
		jlblPw = new JLabel("비밀번호");
		jlblId = new JLabel("아이디");
		jpfPw = new JPasswordField();
		jtfId = new JTextField();
		jlbl = new JLabel(
				new ImageIcon("c:/dev/workspace/jiha/src/kr/co/sist/LDMS/login background testtesttest.png"));
		// 레이아웃 설정
		setLayout(null);
		jbtnLogIn.setBounds(120, 145, 102, 30);
		jlblId.setBounds(78, 65, 60, 30);
		jlblPw.setBounds(78, 105, 60, 30);
		jtfId.setBounds(155, 65, 100, 30);
		jpfPw.setBounds(155, 105, 100, 30);
		jlbl.setBounds(0, 0, 350, 250);
		// 폰트 설정
		Font jlblFont = new Font("함초롬돋움", Font.BOLD, 13);
		jbtnLogIn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jlblId.setFont(jlblFont);
		jlblPw.setFont(jlblFont);
		// 라벨 글씨 정렬
		jlblId.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		// 이벤트 등록
		LogInEvent lie = new LogInEvent(this);
		jbtnLogIn.addActionListener(lie);
		jpfPw.addActionListener(lie);
		addWindowListener(lie);
		// component 배치
		add(jbtnLogIn);
		add(jlblId);
		add(jlblPw);
		add(jtfId);
		add(jpfPw);
		add(jlbl);
		// 윈도우 설정
		setTitle("로그인");
		setBounds(785, 415, 350, 250);
		setVisible(true);
	}// LogIn

	public JButton getJbtnLogIn() {
		return jbtnLogIn;
	}// getJbtnLogIn
	public JTextField getJpfPw() {
		return jpfPw;
	}// getJtfPw
	public JTextField getJtfId() {
		return jtfId;
	}// getJtfId
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public LDMS getLdms() {
		return ldms;
	}
}// class