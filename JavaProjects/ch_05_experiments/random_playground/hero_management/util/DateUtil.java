package ch_05_experiments.random_playground.Hero_management.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}

// --- 클래스 다이어그램 ---
// DateUtil : 날짜/시간 유틸
// --- 시퀀스 ---
// UI/Service → DateUtil
// --- 액티비티 ---
// 날짜 포맷