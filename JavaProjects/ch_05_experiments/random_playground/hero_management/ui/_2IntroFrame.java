package ch_05_experiments.random_playground.Hero_management.ui;

import javax.swing.*;
import java.awt.*;

public class _2IntroFrame extends JFrame {
    public _2IntroFrame() {
        setTitle("히어로 매니지먼트 - 인트로");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("히어로 회원관리 시스템", SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        add(label);
        setVisible(true);

        Timer timer = new Timer(2000, e -> {
            dispose();
            new _3MainFrame();
        });
        timer.setRepeats(false); // ★ 한 번만 실행되도록 설정
        timer.start();
    }
}

// --- 클래스 다이어그램 ---
// _2IntroFrame : JFrame
// --- 시퀀스 ---
// Main → IntroFrame → MainFrame
// --- 액티비티 ---
// 인트로, 타이머, 화면전환