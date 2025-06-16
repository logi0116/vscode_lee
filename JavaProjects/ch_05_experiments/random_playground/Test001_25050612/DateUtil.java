// DateUtil.java
// 이 파일은 날짜와 시간 관련 유틸리티 기능을 제공합니다.
package ch_05_experiments.random_playground.Test001_25050612;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil { // public으로 선언해야 다른 파일에서 접근 가능합니다.
    // 현재 날짜와 시간을 지정된 형식의 문자열로 반환하는 정적 메서드
    public static String getCurrentDateTime() {
        // "yyyy-MM-dd HH:mm" (년-월-일 시:분) 형식으로 현재 날짜와 시간 반환
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}