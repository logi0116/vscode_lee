package util.date;

import java.time.LocalDateTime; // LocalDateTime : 날짜와 시간을 다루는 클래스
import java.time.format.DateTimeFormatter; // DateTimeFormatter : 지정한 날짜 형식으로 변환하는 클래스

public class DateUtil_doc {
    // 정적 메서드 추가, 현재 날짜와 시간을
    // 형식 : 2025년 05월 30일 오후 4시 35분 , 이런 형식의 데이터로 변환
    // 문자열 형태로 반환하는 메소드 만들기.
    public static String getCurrentDateTime() {
        // 현재 날짜를 알려주는 클래스 : LocalDateTime 이용하기.
        // 방법1) 정적인 형태.
        // [클래스명] [변수명] = [클래스명].[정적 메서드]();
        LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간 가져오기

        // 사용자 정의한 포맷 모양으로 변환하기.
        // 형식 : 2025년 05월 30일 오후 4시 35분 , 이런 형식의 데이터로 변환
        // DateTimeFormatter : 특정의 날짜와 형식으로 변환 해주는 기능.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a h시 m분");
        // 반환하기.
        return now.format(formatter); // 포맷을 적용하여 문자열로 변환하여 반환
        // 방법2) 인스턴스 형태로, 객체를 생성해서, 메서드 호출하기.
        // [클래스명] [변수명] = new [클래스명]();

    }

}
