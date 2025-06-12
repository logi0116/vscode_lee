package ch2;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        System.out.println("ScannerTest 시작");
        // Scanner : 자바에서 사용자의 입력을 받는 방법.
        // 자주 사용하는 메서드 , next(), nextLine(), nextInt(), nextDouble() 등등
        // next(): 공백 전까지 문자열 입력, 예시) "홍 길 동" -> next로 가져온 문자열은 "홍"이 됨
        // nextLine(): 한 줄 전체를 문자열로 입력, 예시) "홍 길 동" -> nextLine으로 가져온 문자열은 "홍 길 동"이 됨
        // nextInt(): 정수 입력, 예시) "123" -> nextInt로 가져온 값은 123이 됨
        // nextBoolean(): 불리언 입력, 예시) "true" -> nextBoolean으로 가져온 값은 true가 됨
        // hasNext(): 다음에 입력할 값이 있는지 확인하는 메서드, 예시) 입력이 있다면 true, 없다면 false 반환


       
        

        //예제 코드
        




        // 기본 문법 형식
        // import : 다른 클래스를 가져오는 명령어
        // java.util.Scanner : java 폴더 -> util 폴더 -> Scanner 클래스
        // 순서1
        // import java.util.Scanner; // Scanner 클래스를 사용하기 위해 import 해야함.
        // 순서2, 클래스의 기본 사용방법(객체 생성= 인스턴스를 생성)
        // 기본 모양, [클래스명] [변수명] = new [클래스명]();
        // Scanner scanner = new Scanner(System.in); // System.in : 표준 입력 스트림, 키보드 입력을
        // 받기 위해 사용
        // 순서3, 입력받기
        // System.out.println("이름을 입력하세요: ");
        // String name = scanner.nextLine(); // nextLine() 메서드를 사용하여 한 줄 전체를 입력받음
        // 순서4,. 출력해보기.
        // System.out.println("입력한 이름: " + name); // 입력받은 이름을 출력
        // 순서5, scanner 닫기
        // scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지



           //예제 코드
           //기본 모양,
           // [클래스명] [변수명] = new [클래스명]();      
        Scanner scanner = new Scanner(System.in);
        // System.in : 표준 입력 스트림, 키보드 입력을 받기 위해 사용



        
        System.out.println("이름을 입력하세요: ");
        String name = scanner.nextLine(); // nextLine() 메서드를 사용하여 한 줄 전체를 입력받음
        System.out.println("입력한 이름: " + name); // 입력받은 이름을 출력
        


     

        /// 숫자 입력 
        /// 
        /// 
        
        System.out.println("본인의 좋아하는 숫자를 입력하세요: ");
        int number = scanner.nextInt(); // nextInt 메서드를 사용하여 숫자를 입력받음
        System.out.println("내가 입력한 숫자: " + number); // 입력받은 숫자를 출력
         




        /// 퀴즈2. 새로운 ScannerTest2 클래스 만들기.
        /// 회원 가입 해보기.
        /// 콘솔에 출력되는 내용은
    // 이상록 홈피 회원가입
    // 이름 입력해주세요
    // 이메일 입력해주세요
    // 비밀번호 입력해주세요
    //힌트는 모두 문자열 해도 좋습니다.
    // 출력결과는 
    // 이름 : {이름}
    // 이메일 : {이메일}
    // 비밀번호 : {비밀번호}
    // 회원가입 완료되었습니다.



   
        //실제 작업 순서 5.
        //위에서 입력받는 내용이 전부 전부 작업 후 , 맨 마지막에 실행
        
        scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지
           



    }
}
