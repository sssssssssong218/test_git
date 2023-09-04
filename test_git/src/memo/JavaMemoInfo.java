package memo;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JavaMemoInfo extends JDialog{
	public JavaMemoInfo() {
		String info="이 메모장은 자바언어로 만들어진\n메모장으로 License는 \nPL(Public License로"
				+ " 자유롭게 \n배포하고 사용하실 수 있습니다.\n작성자 송지하";
		JOptionPane.showMessageDialog(this, info,"메모장 정보",JOptionPane.CANCEL_OPTION);
	}
}
