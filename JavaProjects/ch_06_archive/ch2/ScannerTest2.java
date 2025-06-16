package ch2;

import java.util.Scanner;
import util.user.UserService;

public class ScannerTest2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성, 표준 입력 스트림
        // 퀴즈1, 회원 가입 실행하기
        UserService.registerUser(scanner); // UserService 클래스의 registerUser 메소드 호출
        // 퀴즈2, 로그인 기능 실행하기
        UserService.loginUser(scanner); // UserService 클래스의 loginUser 메소드 호출
        // 공용 스캐너 닫기
        scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지

    }
}
