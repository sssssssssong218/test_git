package job;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectChange {
    public static void main(String[] args) {
        // GUI 컴포넌트들을 담을 JFrame 생성
        JFrame frame = new JFrame("리스트 선택 예제");

        // JList에 표시할 데이터를 저장하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // DefaultListModel를 사용하여 JList 객체 생성
        JList<String> list = new JList<>(listModel);

        // 몇 개의 항목을 JList에 추가
        listModel.addElement("아이템 1");
        listModel.addElement("아이템 2");
        listModel.addElement("아이템 3");

        // 아이템 선택 상태 변화를 처리할 ListSelectionListener 생성
        ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 선택 상태 변화가 완료된 경우에 대해서만 처리
                if (!e.getValueIsAdjusting()) {
                    // 이벤트의 소스인 JList를 가져옴
                    JList<String> source = (JList<String>) e.getSource();

                    // 선택된 아이템의 인덱스를 가져옴
                    int selectedIndex = source.getSelectedIndex();

                    // 선택된 아이템의 인덱스를 콘솔에 출력
                    System.out.println("선택된 인덱스: " + selectedIndex);
                }
            }
        };

        // ListSelectionListener를 JList에 추가하여 선택 상태 변화를 감지하도록 설정
        list.addListSelectionListener(selectionListener);

        // JList를 JScrollPane에 넣고, JScrollPane를 JFrame의 컨텐츠 패널에 추가
        frame.getContentPane().add(new JScrollPane(list));

        // 프레임을 닫을 때 프로그램 종료 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
