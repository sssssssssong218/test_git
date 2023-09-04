package memo;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class JavaMemoEvt extends WindowAdapter implements ActionListener{
	private JavaMemo jm;
	private boolean openBoolean;
	private StringBuffer sbTemp;
	private FileDialog fd;
	private String dir;
	private String name;
	private BufferedWriter bw;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm=jm;
	}

	public void fileNew() {
		//메모장에 내용이 없으면 타이틀바를 "메모장 - 새글"로 설정
		if(jm.getJta().getText().equals("")){
			jm.setTitle("메모장 -새글");
		}
		
		//열기를 하지 않은 상태에서 내용이 있다면 저장여부를 묻고 파일명 설정하여 저장후 jta초기화
		if(!jm.getJta().getText().equals("")) {
			int option=JOptionPane.showConfirmDialog(jm, "변경 내용을 제목 없음에 지정하시겠습니까?","메모장",JOptionPane.YES_NO_CANCEL_OPTION);
			switch (option) {
			case JOptionPane.OK_OPTION:
				fileSave();
				jm.getJta().setText("");
				break;
			default:
				jm.getJta().setText("");
				break;
			}//end switch
		}//end if
		
		//열기를 한 상태에서는 기존의 내용과 변경된 내용이 있는지 확인하고
		if(openBoolean) {
			//변경되지 않았다면 jta초기화
			if(jm.getJta().getText().equals(sbTemp.toString())) {
				jm.getJta().setText("");
				jm.setTitle("메모장 - 새글");
			}else if(!jm.getJta().getText().equals(sbTemp.toString())) {
				//변경되었다면 저장 여부를 확인하고 열었던 파일에 저장후 (덮어쓰기)JTA초기화
				int option=JOptionPane.showConfirmDialog(jm, "변경 내용을 덮어쓰시겠습니까?","메모장"
						,JOptionPane.YES_NO_CANCEL_OPTION);
				switch (option) {
				case JOptionPane.OK_OPTION:
					try {
						overwrite();
						jm.getJta().setText("");
						jm.setTitle("메모장 - 새글");
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				default:
					jm.getJta().setText("");
					break;
				}
				
			}
		}
	}
	
	public void overwrite() throws IOException {
		try {
			File file=new File(dir+" / "+name);
			bw=new BufferedWriter(new FileWriter(file));
			bw.write(jm.getJta().getText());
			bw.flush();
		}finally {
			if(bw!=null) {
				bw.close();
			}
		}
	}//overwrite
	
	public void fileOpen() {
		
	}
	
	public void fileNewSave() {
		
	}
	
	public void font() {
		
	}
	
	public void help() {
		
	}
	
	public void fileSave() {
		
	}
	
	public void memoClose() {
		jm.dispose();
	}
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		jm.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//새글
		if(ae.getSource()==jm.getJmiNew()) {
			fileNew();
		}
		
		//닫기
		if(ae.getSource()==jm.getJmiClose()) {
			memoClose();
		}
		
		//열기
		if(ae.getSource()==jm.getJmiOpen()) {
			fileOpen();
		}
		
		//저장
		if(ae.getSource()==jm.getJmiSave()) {
			fileSave();
		}
		
		//다른이름 저장
		if(ae.getSource()==jm.getJmiNewSave()) {
			fileNewSave();
		}
		
		if(ae.getSource()==jm.getJmiFont()) {
			font();
		}

		//도움말
		if(ae.getSource()==jm.getJmiHelp()) {
			help();
		}
		
	}
		

}
