package job;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Id extends JFrame implements ActionListener{

	private JTextField jtfid;
	private JPasswordField jpfpass;
	private JLabel jlblid;
	private JLabel jlblpass;
	private JLabel jlblresult;
	
	public Id() {
		super("아이디 출력");
		jtfid=new JTextField(20);
		jtfid.addActionListener(this);
		
		jpfpass=new JPasswordField(20);
		jpfpass.addActionListener(this);
		
		jlblid=new JLabel("아이디");
		jlblpass=new JLabel("비밀번호");
		jlblresult=new JLabel();
		
		setLayout(new FlowLayout());//왼쪽부터 차례대로 나오게 레이아웃 지정
		add(jlblid);
		add(jtfid);
		add(jlblpass);
		add(jpfpass);
		add(jlblresult);
		
		jlblresult.setBounds(100, 100, 50, 50);
		setSize(330,330);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jtfid) {
			String id=jtfid.getText().trim();
			if(id.equals("admin")||id.equals("kang")||id.equals("kim")||id.equals("lee")) {
				jpfpass.requestFocus();//아이디필드에서 엔터를 눌렀을 때 비밀번호필드로 포커스가 이동
			}
			else {
				jlblresult.setText("존재하지 않는 아이디입니다.");
			}
		}
		else if(e.getSource()==jpfpass) {
			String password=new String(jpfpass.getPassword());
			String id=jtfid.getText().trim();//trim으로 양끝에 있는 앞뒤 공백 제거
			if(id.equals("admin")&&password.equals("1234")||
					id.equals("kang")&&password.equals("lest1234")||
					id.equals("kim")&&password.equals("4321")||
					id.equals("lee")&&password.equals("9876")) {
				Date date=new Date();//date로 날짜표현해주고 simpledateformat에 넣어서 지정된 날짜 형식으로 표현해준다.
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String value=sdf.format(date);
				String printMessage=id+"님"+value+"초에 로그인 하셨습니다.";
				jlblresult.setText(printMessage);
				System.out.println(printMessage);
			}
		}
		else {
			jlblresult.setText("존재하지 않는 정보입니다.");
		}
	}
	public static void main(String[] args) {
		new Id();
	}


}
