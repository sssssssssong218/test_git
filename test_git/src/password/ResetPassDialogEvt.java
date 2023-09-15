package password;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ResetPassDialogEvt extends MouseAdapter implements ActionListener {
	private ResetPassDialog rpd;

	public ResetPassDialogEvt(ResetPassDialog rpd) {
		this.rpd = rpd;
		rpd.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				rpd.dispose();
			}
			
		});
	}// constructor

	public void findPass() {
		if(rpd.getJtfEmpNo().getText().length()==0||rpd.getJtfEname().getText().length()==0||
				rpd.getJtfSsn().getText().length()==0) {
			JOptionPane.showMessageDialog(rpd, "값을 입력해주세요");
		}else {
			String InputEmpno=String.valueOf(rpd.getInputEmpno());
			String InputEname=String.valueOf(rpd.getInputEname());
			String InputSsn=String.valueOf(rpd.getInputSsn());
			
			if(rpd.getJtfEmpNo().getText().equals(InputEmpno)&&
				rpd.getJtfEname().getText().equals(InputEname)&&
				rpd.getJtfSsn().getText().equals(InputSsn)) {
				JOptionPane.showMessageDialog(rpd, "맞는 비밀번호다 비밀번호 초기화됨");
				rpd.getJtfEmpNo().setText("");
				rpd.getJtfEname().setText("");
				rpd.getJtfSsn().setText("");
			}else {
				JOptionPane.showMessageDialog(rpd, "올바른 정보를 입력하세요");
			}
			
		}
	}//findPass
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rpd.getJbtnCancel()) {
			rpd.dispose();
		}else if(e.getSource()==rpd.getJbtnResetPass()) {
			findPass();
		}
	}// actionPerformed

	

	
}// class