package kr.co.sist.LDMS;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.Map;
import java.io.File;

@SuppressWarnings("serial")
public class LDMS extends JFrame {
	private Map<Integer, LogVO> logVOMap;
	private JScrollPane jsp;
	private JTextField jtfStartRange;
	private JTextField jtfEndRange;   
	private JTextArea jtaLog;
	private JButton jbtnSelect;
	private JButton jbtnReport;
	private JButton jbtnView; 
	private JLabel jlblStartRange;
	private JLabel jlblEndRange;  
	private JLabel imgageIcon;
	private String id; 
	private File file;

	public LDMS() {
		super("LDMS");
		// component 객체 생성
		jlblStartRange = new JLabel("시작 라인 범위  :");
		jtfStartRange = new JTextField(100);
		jlblEndRange = new JLabel("마지막 라인 범위  :");
		jtfEndRange = new JTextField();
		jtaLog = new JTextArea();
		jtaLog.setLineWrap(true);
		jsp = new JScrollPane(jtaLog);
		// 이미지 설정
		ImageIcon reportbuttonimage = new ImageIcon("c:/dev/workspace/jiha/src/kr/co/sist/LDMS/report.png");
		ImageIcon selectbuttonimage = new ImageIcon("c:/dev/workspace/jiha/src/kr/co/sist/LDMS/select.png");
		ImageIcon viewbuttonimage = new ImageIcon("c:/dev/workspace/jiha/src/kr/co/sist/LDMS/view.png");
		ImageIcon image = new ImageIcon("c:/dev/workspace/jiha/src/kr/co/sist/LDMS/img.png");
		jbtnReport = new JButton("Report", reportbuttonimage);
		jbtnSelect = new JButton("Select", selectbuttonimage);
		jbtnView = new JButton("View", viewbuttonimage);
		imgageIcon = new JLabel(image);
		// 폰트 설정
		Font jlblFont = new Font("함초롬돋움", Font.BOLD, 17);
		Font jbtnFont = new Font("맑은 고딕", Font.BOLD, 23);
		Font jtffont = new Font("맑은 고딕", Font.BOLD, 17);
		jlblStartRange.setFont(jlblFont);
		jtfStartRange.setFont(jtffont);
		jlblEndRange.setFont(jlblFont);
		jtfEndRange.setFont(jtffont);
		jbtnReport.setFont(jbtnFont);
		jbtnSelect.setFont(jbtnFont);
		jbtnView.setFont(jbtnFont);
		// 색 설정
		getContentPane().setBackground(new Color(231, 231, 231));
		jlblStartRange.setForeground(new Color(0, 0, 147));
		jtfStartRange.setForeground(new Color(201, 0, 73));
		jlblEndRange.setForeground(new Color(0, 0, 147));
		jtfEndRange.setForeground(new Color(201, 0, 73));
		jbtnSelect.setBackground(new Color(0xFFF8E2));
		jbtnReport.setBackground(new Color(0xD5E8D4));
		// 버튼 글씨 정렬
		jbtnSelect.setHorizontalTextPosition(JButton.CENTER);
		jbtnReport.setVerticalTextPosition(JButton.CENTER);
		jbtnSelect.setVerticalTextPosition(JButton.CENTER);
		jbtnReport.setHorizontalTextPosition(JButton.CENTER);
		jbtnView.setHorizontalTextPosition(JButton.CENTER);
		jbtnView.setVerticalTextPosition(JButton.CENTER);
		// 레이아웃 설정
		jsp.setBorder(new TitledBorder("불러온 Log Data"));
		setLayout(null);

		jlblStartRange.setBounds(75, 62, 140, 30);
		jtfStartRange.setBounds(209, 65, 150, 30);
		jlblEndRange.setBounds(400, 62, 150, 30);
		jtfEndRange.setBounds(551, 65, 150, 30);
		jbtnReport.setBounds(550, 690, 180, 50);
		jbtnSelect.setBounds(300, 690, 180, 50);
		imgageIcon.setBounds(0, 0, 800, 800);
		jbtnView.setBounds(50, 690, 180, 50);
		jsp.setBounds(50, 120, 680, 550);
		// component 배치
		add(jlblStartRange);
		add(jtfStartRange);
		add(jlblEndRange);
		add(jtfEndRange);
		add(jbtnReport);
		add(jbtnSelect);
		add(jbtnView);
		add(jsp);
		add(imgageIcon);
		// 이벤트 등록
		LDMSEvent ldmse = new LDMSEvent(this);
		jbtnReport.addActionListener(ldmse);
		jbtnSelect.addActionListener(ldmse);
		jbtnView.addActionListener(ldmse);
		addWindowListener(ldmse);
		// 윈도우 설정
		setResizable(false);
		setVisible(true);
		setBounds(560, 100, 800, 800);
		// login 호출
		id = new LogIn(this).getId();
		ldmse.fileLoad();
	}// constructor

	// getter / setter
	public void setJtfStartRange(JTextField jtfRangeStart) {
		this.jtfStartRange = jtfRangeStart;
	}
	public void setLogVOMap(Map<Integer, LogVO> logVOMap) {
		this.logVOMap = logVOMap;
	}
	public void setJtfEndRange(JTextField jtfRangeEnd) {
		this.jtfEndRange = jtfRangeEnd;
	}
	public Map<Integer, LogVO> getLogVOMap() {
		return logVOMap;
	}
	public void setJtaLog(JTextArea jtaLog) {
		this.jtaLog = jtaLog;
	}
	public JTextField getJtfstartRange() {
		return jtfStartRange;
	}
	public JTextField getJtfStartRange() {
		return jtfStartRange;
	}
	public JTextField getJtfendRange() {
		return jtfEndRange;
	}
	public JTextField getJtfEndRange() {
		return jtfEndRange;
	}
	public void setFile(String path) {
		file = new File(path);
	}
	public JButton getJbtnSelect() {
		return jbtnSelect;
	}
	public JButton getJbtnReport() {
		return jbtnReport;
	}
	public JButton getJbtnView() {
		return jbtnView;
	}
	public JTextArea getJtaLog() {
		return jtaLog;
	}
	public String getId() {
		return id;
	}
	public File getFile() {
		return file;
	}
}// class
