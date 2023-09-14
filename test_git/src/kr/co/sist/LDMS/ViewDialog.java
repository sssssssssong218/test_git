package kr.co.sist.LDMS;

import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class ViewDialog extends JDialog {
    private JLabel jlblLog;

    public ViewDialog(LDMS ldms, String msg) {
    	super(ldms,"분석정보 보기",true);
    	// component 객체 생성
        jlblLog = new JLabel("<html>"+msg.replace("\n", "<br><pre>")+"</html>");
        // 레이아웃 설정
        setLayout(null);
        jlblLog.setBounds(10, 10,750,750); 
        // 폰트 설정
        Font LogFont = new Font("돋움", Font.PLAIN, 16);
        jlblLog.setVerticalAlignment(SwingConstants.TOP); 
        jlblLog.setFont(LogFont);
        // 라벨 색 설정
        jlblLog.setForeground(new Color(36,36,36));
        // 배경 색 설정
        getContentPane().setBackground(new Color(255, 231, 231));
        // component 배치
        add(jlblLog);
        // 윈도우 설정
        setBounds(660,200,600, 600);
        setVisible(true);
        setResizable(false);
    }//ViewDialog
}//ViewDialog
