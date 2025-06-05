package ch2;

public class 퀴즈 {
    
}
package ch2;
// 퀴즈2

import java.util.Scanner;

import util.UserService;

// 새로운 ScannerTest2 클래스 만들기.
// 회원 가입 해보기.
// 콘솔에 출력되는 내용
// 이상용 홈피 회원가입

// 힌트는 모두 문자열 해도 좋습니다.
// 이름 입력해주세요 >
// 이메일 입력해주세요 >
// 패스워드 입력해주세요 >

// 출력 결과는
// 이름 : {이름}
// 이메일 : {이메일}
// 패스워드 : {패스워드}
// 회원 가입 완료되었습니다.ㅇ
public class ScannerTest2 {
    public static void main(String[] args) {

        // 공용으로 사용을 할 스캐너를 정의.
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성, 표준 입력 스트림
        // Scanner 객체를 매개변수로 받기,
        // 여기에 있던 회원 가입 내용을
        // 다른 클래스로 이동 후,
        // 단순, 클래스의 메소드만 호출하는 형태로 변경함.
        // 클래스명.메소드명() 형태로 호출

        // 해결책2, 기존에 메서드는 매개변수 없는 모양이었고,
        // 변경은, 매개변수에 스캐너를 첨부를 하는 모양으로 변경.
        UserService.registerUser(scanner); // UserService 클래스의 registerUser 메소드 호출

        // 퀴즈,
        // 회원가입 기능 만들었고, 로그인 기능을 만들기.
        // 현재 디비가 없음. 그래서, 로그인 기능은

        // 콘솔로 이메일 입력받고, 패스워드 입력 받기.

        // 검증 없이, 단순 로그인 정보만 출력하기.

        // 힌트는 모두 문자열 해도 좋습니다.
        // 로그인 이메일 입력해주세요 >
        // 로그인 패스워드 입력해주세요 >

        // 출력 결과는
        // 로그인 이메일 정보 : {이메일}
        // 로그인 패스워드 정보 : {패스워드}
        // 로그인 완료되었습니다. 현재 임시로 단순 출력용입니다. 조금 있다. 검증도 추가 해보기.
        //
        // 메서드를, UserService 클래스에 , 정적 메소드로 추가해보기.

        // 해결책2, 기존에 메서드는 매개변수 없는 모양이었고,
        // 변경은, 매개변수에 스캐너를 첨부를 하는 모양으로 변경.

        UserService.loginUser(scanner); // UserService 클래스의 loginUser 메소드 호출
        // 각 메서드에 각각 스캐너 이용시, 이슈 발생함. 확인.

        // 실행시 , 예외가 발생하면,
        // 보는 방법
        // 1) 우리가 사용하는 클래스 라인을 찾기.
        // 2) 예1) / at util.UserService.loginUser(UserService.java:53)
        // 실제 파일에 접근해서, 53번째 줄을 확인.
        // String email = scanner.nextLine(); // 이메일 입력 받기

        // 예2) at ch2.ScannerTest2.main(ScannerTest2.java:49)
        // 실제 파일에 접근해서, 49번째 줄을 확인.
        // UserService.loginUser(); // UserService 클래스의 loginUser 메소드 호출

        // 결론, scanner 부분에서, java.util.NoSuchElementException 예외가 발생함.

        // System.in 은, 표준 입력 스트림으로,, 공용 이기 때문에,
        // 첫번째, public static void registerUser() { 메서드 안에서,
        // scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지
        // 완전 종료가 되어서,

        // 두번째 public static void registerUser() {
        // System.in , 완전히 닫혀서, 이용을 못하는 문제.
        // Scanner scanner = new Scanner(System.in); // 이슈 , 발생 ,
        // 현상황, 위의 회원가입 메서드에서, 스캐너를 종료시, 같이 System.in 이 닫혀서, 문제가 발생.

        // 해결책.
        // 메인에서 -> 스캐너를 생성하고, -> 해당 객체를 각 메서드에 공유하기.

        // Exception in thread "main" java.util.NoSuchElementException: No line found
        // at java.base/java.util.Scanner.nextLine(Scanner.java:1651)
        // at util.UserService.loginUser(UserService.java:53)
        // at ch2.ScannerTest2.main(ScannerTest2.java:49)

        // 마지막에, 다 사용후, 닫기.ㅇ
        scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지

    }
}
