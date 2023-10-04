package kr.co.sist.LDMS;

import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.awt.FileDialog;
import java.io.IOException;
import java.io.FileReader;
import java.util.Iterator;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Date;

public class LDMSEvent extends WindowAdapter implements ActionListener {
	private BufferedWriter bw;
	private BufferedReader br;
	private Organize organize;
	private LDMS ldms;

	public LDMSEvent(LDMS ldms2) {
		this.ldms = ldms2;
	}// constructor
 
	// 윈도우 닫기
	@Override
	public void windowClosing(WindowEvent e) {
		ldms.dispose();
	}// windowClosing
 
	@Override
	public void windowClosed(WindowEvent e) { 
		System.exit(JFrame.ABORT);
	}// windowClosed

	// 액션 리스너
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 파일이 존재함
		if (ldms.getFile().exists()) {
			// 뷰 버튼
			if (ae.getSource() == ldms.getJbtnView()) {
				dataView();
			} // if
				// 리포트 버튼
			if (ae.getSource() == ldms.getJbtnReport()) {
				try {
					dataReport();
				} catch (IOException e) {
					e.printStackTrace();
				} // catch
			} // if
				// 파일이 존재 하지 않음
		} else {
			JOptionPane.showMessageDialog(ldms, "로그 파일을 찾을 수 없습니다!\n다시 설정해 주세요!");
		} // else
			// 셀렉트 버튼
		if (ae.getSource() == ldms.getJbtnSelect()) {
			loadFile();
		} // if
	}// actionPerformed

	// 뷰 버튼 시 실행
	public void dataView() {
		if (dataOrganize()) {
			new ViewDialog(ldms, "요청하신 로그에 대한 분석은 아래와 같습니다.\n" + data());
		} // if
	}// dataView

	// 리포트 버튼시 작동
	private void dataReport() throws IOException {
		// root 사용자 접근 권한 제한
		System.out.println(ldms.getId().toString());
		if (ldms.getId().equals("root")) {
			JOptionPane.showMessageDialog(ldms, "문서를 생성할 수 있는 권한이 없음");
			return;
		} // if

		String path = null;
		try {
			if (!dataOrganize()) {return;}
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Select Folder");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			switch (jfc.showOpenDialog(ldms)) {
			case JFileChooser.APPROVE_OPTION:
				path = jfc.getSelectedFile().getAbsolutePath();
				String date = new SimpleDateFormat("yy-MM-dd HH;mm;ss").format(new Date());

				bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(path + "/report_" + date + ".dat")));
				bw.write("-----------------------------------------------------------------\n");
				bw.write("파일명(" + ldms.getFile().getName() + ") log ( 생성된 날짜 " + date + " )\n");
				bw.write("-----------------------------------------------------------------\n");
				bw.write(data());
				bw.flush();
				JOptionPane.showMessageDialog(ldms, "정상적으로 저장되었습니다!");
				break;
			default:
				JOptionPane.showMessageDialog(ldms, "정상적인 경로를 입력하지 않았습니다.");
			}// switch
		} finally {
			if (bw != null) {
				bw.close();
			} // if
		} // finally
	}// dataReport

	// 셀렉트 버튼 클릭시 실행
	private FileDialog loadFile() {
		FileDialog path = new FileDialog(ldms, "로그 파일 불러오기", FileDialog.LOAD);
		path.setVisible(true);
		if (path.getDirectory() != null) {
			ldms.setFile(path.getDirectory() + path.getFile());
			try {
				refreshLogVOMap();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // catch
		} // if
		return path;
	}// loadPath

	// 분석 내용 출력
	public String data() {
		StringBuilder dataSb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.00");

		// 1. 최다 사용 키
		String topKey = organize.topKey();
		dataSb.append("1. 최다 사용 키 : " + topKey + " | " + organize.getKeyCnt().get(topKey) + "회\n");

		// 2. 브라우저 접속 횟수
		Iterator<String> browserIter = organize.getBrowserCnt().keySet().iterator();
		dataSb.append("2. 브라우저별 접속 횟수\n");
		String temp = null;
		while (browserIter.hasNext()) {
			temp = browserIter.next();
			dataSb.append("\t" + temp + " : " + organize.getBrowserCnt().get(temp) + "회 접속 ("
					+ df.format(organize.browserRatio(temp)) + "%)\n");
		} // while

		// 3. 서비스 성공 및 실패 횟수
		dataSb.append("3. 성공 및 실패 횟수 " + "\n");
		dataSb.append(
				"\t성공 : " + organize.getTypeCnt().get("200") + "회\n\t실패 : " + organize.getTypeCnt().get("404") + "회\n");

		// 4. 요청이 가장 많은 시간
		dataSb.append("4. 접속 요청이 가장 많았던 시간대 : [" + organize.topTime() + "]\n");

		// 5. 비정상적 요청이 발생한 횟수
		if (organize.getTypeCnt().containsKey("403")) {
			dataSb.append("5. 비정상적 요청이 발생한 횟수 : " + organize.getTypeCnt().get("403") + "회 (전체 접속의 "
					+ df.format(organize.typeRatio("403")) + "%)\n");
		} else {
			dataSb.append("5. 비정상적 요청이 발생한 횟수 : 없음");
		} // else

		// 6. 요청에 대한 에러가 발생한 횟수
		if (organize.getTypeCnt().containsKey("500")) {
			dataSb.append("6. 요청에 대한 에러가 발생한 횟수 : " + organize.getTypeCnt().get("500") + "회 (전체 접속의 "
					+ df.format(organize.typeRatio("500")) + "%)\n");
		} else {
			dataSb.append("6. 요청에 대한 에러가 발생한 횟수 : 없음");
		} // else
		return dataSb.toString();
	}// data

	// LogVO 맵 설정
	private boolean dataOrganize() throws NumberFormatException {
		boolean flag = true;
		boolean isStartEmpty = ldms.getJtfStartRange().getText().equals("");
		boolean isEndEmpty = ldms.getJtfEndRange().getText().equals("");
		try {
			if (isStartEmpty && isEndEmpty) {
				organize = new Organize(ldms);
			} else if (isStartEmpty) {
				if (Integer.parseInt(ldms.getJtfEndRange().getText()) > ldms.getLogVOMap().size()) {
					JOptionPane.showMessageDialog(ldms,
							"최대 범위를 넘어서는 인덱스 입니다.\n" + "마지막 로그는" + ldms.getLogVOMap().size() + "번입니다.");
					flag = false;
				} else {
					organize = new Organize(ldms, Integer.parseInt(ldms.getJtfEndRange().getText()));
				}
			} else if (isEndEmpty) {
				organize = new Organize(ldms, Integer.parseInt(ldms.getJtfStartRange().getText()),
						ldms.getLogVOMap().size());
				if (Integer.parseInt(ldms.getJtfstartRange().getText()) > ldms.getLogVOMap().size()) {
					JOptionPane.showMessageDialog(ldms,
							"최대 범위를 넘어서는 인덱스 입니다.\n" + "마지막 로그는" + ldms.getLogVOMap().size() + "번입니다.");
					flag = false;
				} // if
			} else {
				if (Integer.parseInt(ldms.getJtfstartRange().getText()) > ldms.getLogVOMap().size()) {
					JOptionPane.showMessageDialog(ldms,
							"최대 범위를 넘어서는 인덱스 입니다.\n" + "마지막 로그는" + ldms.getLogVOMap().size() + "번입니다.");
					return false;
				}// if
				flag = setCntMap();
			} // else
				// 시작과 끝 인덱스 범위 초과

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldms, "숫자를 입력해주세요!");
			organize = new Organize(ldms);
			ldms.getJtfEndRange().setText("");
			ldms.getJtfStartRange().setText("");
			flag = false;
		} // catch
		return flag;
	}// dataOrganize

	// CntMap 세팅-dataOrganize 실행 시 실행
	public boolean setCntMap() throws NumberFormatException {
		boolean flag = false;
		if (Integer.parseInt(ldms.getJtfEndRange().getText()) < Integer.parseInt(ldms.getJtfstartRange().getText())) {
			JOptionPane.showMessageDialog(ldms, "시작 인덱스는 끝 인덱스보다 작을 수 없습니다");
			flag = true;
		} // if
		return flag;
	}// setCntMap

	// 최초 파일 로드시 실행
	public void fileLoad() {
		FileDialog fd = new FileDialog(ldms, "불러올 로그 파일을 선택해 주세요.", FileDialog.LOAD);
		fd.setVisible(true);
		while (true) {
			if (fd.getDirectory() == null) {
				switch (JOptionPane.showConfirmDialog(ldms, "파일을 선택해야만 프로그램을 이용할 수 있습니다.\n프로그램을 종료하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					ldms.dispose();
					return;
				default:
					fd = new FileDialog(ldms, "불러올 로그 파일을 선택해 주세요.", FileDialog.LOAD);
					fd.setVisible(true);
					continue;
				}// switch
			} // if
				//
			break;
		} // while
		ldms.setFile(fd.getDirectory() + fd.getFile());
		try {
			refreshLogVOMap();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // catch
	}// fileLoad

	// VOMap 설정
	public void refreshLogVOMap() throws FileNotFoundException, IOException {
		ldms.setLogVOMap(new HashMap<Integer, LogVO>());
		int i = 1;
		String data = "";
		br = new BufferedReader(new FileReader(ldms.getFile()));
		ldms.getJtaLog().setText("불러온 로그 파일명(" + ldms.getFile().getName() + ")\n\n");
		try {
			while (true) {
				data = br.readLine();
				if (data == null) {
					break;
				} // if
				ldms.getLogVOMap().put(i, new LogVO(data));
				ldms.getJtaLog().append(i + ". " + data + "\n");
				i++;
			} // while
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			ldms.getJtaLog().setText("");
			JOptionPane.showMessageDialog(ldms, "올바른 형식의 로고 파일이 아닙니다.");
			fileLoad();
		} // catch
	}// refreshLogVOMap

}// class