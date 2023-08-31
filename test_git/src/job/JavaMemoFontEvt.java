package job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JavaMemoFontEvt extends WindowAdapter implements ActionListener, ListSelectionListener {
	private JavaMemoFont jmf;
	private JavaMemo jm;

	public JavaMemoFontEvt(JavaMemoFont jmf,JavaMemo jm) {
		this.jm=jm;
		this.jmf=jmf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}
}
