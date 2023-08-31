package job;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class JavaMemo extends JFrame{
	private JTextArea jta;
	private JScrollPane jspText;
	private JMenuItem jmiNew;
	private JMenuItem jmiOpen;
	private JMenuItem jmiSave;
	private JMenuItem jmiNewSave;
	private JMenuItem jmiClose;
	private JMenuItem jmiFont;
	private JMenuItem jmiHelp;
	
	public JavaMemo() {
		super("메모장");
		JMenu jmFile=new JMenu("파일");
		
		jmiNew=new JMenuItem("새글");
		jmiOpen=new JMenuItem("열기");
		jmiSave=new JMenuItem("저장");
		jmiNewSave=new JMenuItem("다른 이름으로 저장");
		jmiClose=new JMenuItem("닫기");
		
		jmFile.add(jmiNew);
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.add(jmiNewSave);
		jmFile.add(jmiClose);
		
		JMenu jmForm =new JMenu("서식");
		
		jmiFont=new JMenuItem("글꼴");
		jmForm.add(jmiFont);
		
		JMenu jmHelp=new JMenu("도움말");
		
		jmiHelp=new JMenuItem("메모장 정보");
		jmHelp.add(jmiHelp);
		
		JMenuBar jmbText=new JMenuBar();
		jmbText.add(jmFile);
		jmbText.add(jmForm);
		jmbText.add(jmHelp);
		
		jta=new JTextArea();
		jspText=new JScrollPane(jta);
		
		setJMenuBar(jmbText);
		
		JavaMemoEvt jme=new JavaMemoEvt(this);
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiNewSave.addActionListener(jme);
		jmiClose.addActionListener(jme);
		jmiFont.addActionListener(jme);
		jmiHelp.addActionListener(jme);
		
		addWindowListener(jme);
		
		setJMenuBar(jmbText);
		add("Center",jspText);
		setVisible(true);
		setBounds(300,100,1000,800);
		
	}

	public JTextArea getJta() {
		return jta;
	}

	public void setJta(JTextArea jta) {
		this.jta = jta;
	}

	public JScrollPane getJspText() {
		return jspText;
	}

	public void setJspText(JScrollPane jspText) {
		this.jspText = jspText;
	}

	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public void setJmiNew(JMenuItem jmiNew) {
		this.jmiNew = jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public void setJmiOpen(JMenuItem jmiOpen) {
		this.jmiOpen = jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public void setJmiSave(JMenuItem jmiSave) {
		this.jmiSave = jmiSave;
	}

	public JMenuItem getJmiNewSave() {
		return jmiNewSave;
	}

	public void setJmiNewSave(JMenuItem jmiNewSave) {
		this.jmiNewSave = jmiNewSave;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}

	public void setJmiClose(JMenuItem jmiClose) {
		this.jmiClose = jmiClose;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public void setJmiFont(JMenuItem jmiFont) {
		this.jmiFont = jmiFont;
	}

	public JMenuItem getJmiHelp() {
		return jmiHelp;
	}

	public void setJmiHelp(JMenuItem jmiHelp) {
		this.jmiHelp = jmiHelp;
	}
	
}
