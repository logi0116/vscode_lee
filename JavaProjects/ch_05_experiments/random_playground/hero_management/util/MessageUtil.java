package ch_05_experiments.random_playground.hero_management.util;

import javax.swing.*;

public class MessageUtil {
    public static void showInfo(String msg) {
        JOptionPane.showMessageDialog(null, msg, "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "오류", JOptionPane.ERROR_MESSAGE);
    }
}