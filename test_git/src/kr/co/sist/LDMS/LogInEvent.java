package kr.co.sist.LDMS;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class LogInEvent extends WindowAdapter implements ActionListener {

	public Map<String, String> adminInfo;
	private LogIn li;

	public LogInEvent() {
	}// constructor

	public LogInEvent(LogIn li) {
		this.li = li;
		adminInfo = new HashMap<String, String>();
		adminInfo.put("administrator", "12345");
		adminInfo.put("admin", "1234");
		adminInfo.put("root", "1111");
	}// constructor
	
	// 윈도우 닫기
	public void windowClosing(WindowEvent we) {
		li.dispose();
		li.getLdms().dispose();
	}// windowClosing

	// 액션 리스너
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 로그인 버튼
		if (ae.getSource() == li.getJbtnLogIn()) {
			signIn();
		} // if
		// 패스워드 엔터
		if (ae.getSource() == li.getJpfPw()) {
			signIn();
		} // if
	}// actionPerformed

	// 로그인 확인
	public void signIn() {
		// id 확인
		if (adminInfo.containsKey(li.getJtfId().getText())) {
			// pw 확인
			if (adminInfo.get(li.getJtfId().getText()).equals(li.getJpfPw().getText())) {
				li.setId(li.getJtfId().getText());
				li.dispose();
				return;
			} // if
		} else {
			// id 다름
			li.getJtfId().setText("");
			li.getJtfId().requestFocus();
		} // else
		li.getJpfPw().setText("");
		JOptionPane.showMessageDialog(li, "인증에 실패하였습니다.");
	}// signIn
}// class
