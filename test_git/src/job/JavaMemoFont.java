package job;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JavaMemoFont extends JDialog {

	private JavaMemo jm;
	private DefaultListModel<String> dlmFont;
	private DefaultListModel<String> dlmStyle;
	private DefaultListModel<String> dlmSize;

	private JList<String> jlFont;
	private JList<String> jlStyle;
	private JList<String> jlSize;

	private JScrollPane jspFont;
	private JScrollPane jspStyle;
	private JScrollPane jspSize;

	private JLabel jlblFont;
	private JLabel jlblStyle;
	private JLabel jlblSize;
	private JLabel jlblPreview;

	private JTextField jtfFont;
	private JTextField jtfStyle;
	private JTextField jtfSize;

	private JButton jbtnOk;
	private JButton jbtnCancle;

	public JavaMemoFont(JavaMemo jm) {
		super(jm, "글꼴", true);
		this.jm = jm;

		dlmFont = new DefaultListModel<>();
		dlmStyle = new DefaultListModel<>();
		dlmSize = new DefaultListModel<>();

		jlFont = new JList<>(dlmFont);
		jlStyle = new JList<>(dlmStyle);
		jlSize = new JList<>(dlmSize);

		jspFont = new JScrollPane(jlFont);
		jspStyle = new JScrollPane(jlStyle);
		jspSize = new JScrollPane(jlSize);

		jlblFont = new JLabel("글꼴 :");
		jlblStyle = new JLabel("글꼴 스타일 :");
		jlblSize = new JLabel("글꼴 사이즈");
		jlblPreview = new JLabel("AaBbCcDd");

		jtfFont = new JTextField();
		jtfStyle = new JTextField();
		jtfSize = new JTextField();

		jbtnOk = new JButton("확인");
		jbtnCancle = new JButton("취소");

		jlblPreview.setBorder(new TitledBorder("보기"));
		jlblPreview.setHorizontalAlignment(SwingConstants.CENTER);

		add(jlblFont);
		add(jlblPreview);
		add(jlblSize);
		add(jlblStyle);

		add(jtfFont);
		add(jtfSize);
		add(jtfStyle);

		add(jspFont);
		add(jspSize);
		add(jspStyle);

		add(jbtnCancle);
		add(jbtnOk);

		// 라벨 위치,크기설정
		jlblFont.setBounds(10, 15, 170, 15);
		jlblStyle.setBounds(200, 15, 140, 15);
		jlblSize.setBounds(350, 15, 70, 15);
		jlblPreview.setBounds(200, 200, 220, 80);

		// 텍스트필드 위치, 크기설정
		jtfFont.setBounds(10, 30, 170, 20);
		jtfStyle.setBounds(200, 30, 140, 20);
		jtfSize.setBounds(350, 30, 70, 20);

		// JList 위치, 크기설정
		jspFont.setBounds(10, 50, 170, 120);
		jspStyle.setBounds(200, 50, 140, 120);
		jspSize.setBounds(350, 50, 70, 120);

		// JButton 위치, 크기설정
		jbtnOk.setBounds(200, 440, 100, 30);
		jbtnCancle.setBounds(310, 440, 100, 30);

		
		
	}

}
