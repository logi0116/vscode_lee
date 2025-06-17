package ch_05_experiments.random_playground.Hero_management.util;

import javax.swing.*;

public class MessageUtil {
    public static void showInfo(String msg) {
        JOptionPane.showMessageDialog(null, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "오류", JOptionPane.ERROR_MESSAGE);
    }
}

// --- 클래스 다이어그램 ---
// MessageUtil : 메시지 유틸
// --- 시퀀스 ---
// UI/Service → MessageUtil
// --- 액티비티 ---
// 알림, 오류