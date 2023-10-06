package job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Inputswing extends JFrame implements ActionListener {
	JTextField jtf;
	JTextArea jta;
	public Inputswing() {
		super("복습");
		JLabel jlbl=new JLabel("이름");
		jtf=new JTextField(10);
		jta=new JTextArea();
		JButton jbtn=new JButton("입력");
		
		JScrollPane jsp=new JScrollPane(jta);
		
		
		add(jlbl);
		add(jsp);
		add(jtf);
		add(jbtn);
		
		setLayout(null);
		
		jbtn.addActionListener(this);
		
		jlbl.setBounds(30, 50, 50, 40);
		jtf.setBounds(70, 50, 100, 40);
		jsp.setBounds(30,100,300,200);
		jbtn.setBounds(200, 50, 120, 40);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()instanceof JButton) {
			String name=jtf.getText();
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(this, "이름 입력하세요");
			}
			else { 
				jta.append(name+"님\n");
			} 
		}
	}
	
	public static void main(String[] args) {
		new Inputswing();
	}
	
}
