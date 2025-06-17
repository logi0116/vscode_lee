package ch_05_experiments.random_playground.hero_management.ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class _4SQLFileChooser {
    public static String chooseCSVFile(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("CSV 파일 선택");
        int result = chooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }
}

// --- 클래스 다이어그램 ---
// _4SQLFileChooser : 파일 선택
// --- 시퀀스 ---
// UI → SQLFileChooser → Service
// --- 액티비티 ---
// 파일 선택, 경로 반환