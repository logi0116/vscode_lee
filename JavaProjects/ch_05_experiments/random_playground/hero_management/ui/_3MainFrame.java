package hero_management.ui;

import javax.swing.*;
import java.awt.*;

public class _3MainFrame extends JFrame {
    public _3MainFrame() {
        setTitle("히어로 매니지먼트 - 메인");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton btn = new JButton("회원관리로 이동");
        btn.addActionListener(e -> {
            dispose();
            new _4SignupFrame();
        });
        add(btn, BorderLayout.CENTER);
        setVisible(true);
    }
}

// --- 클래스 다이어그램 ---
// _3MainFrame : JFrame
// --- 시퀀스 ---
// IntroFrame → MainFrame → SignupFrame
// --- 액티비티 ---
// 메뉴, 화면전환