package remind;

import java.util.Scanner; // Scanner를 사용하려면 반드시 import 필요!

/**
 * 자바 ch1~ch2 핵심 복습 예제
 * - 클래스/메인함수/변수/연산자/입력/함수/조건문/반복문
 * - 각 단계별 해설 주석 포함
 */
public class CH1and2JavaBasicReview {
    // 1. 함수(메서드) 연습: 두 수의 합, 곱, 차, 나눗셈
    public static int sum(int a, int b) {
        return a + b;
    }
    public static int mul(int a, int b) {
        return a * b;
    }
    public static int sub(int a, int b) {
        return a - b;
    }
    public static double div(int a, int b) {
        // 0으로 나누기 방지
        if (b == 0) {
            System.out.println("0으로 나눌 수 없습니다!");
            return 0;
        }
        return (double)a / b;
    }

    public static void main(String[] args) {
        // 2. 출력문 연습
        System.out.println("=== 자바 ch1~ch2 복습 ===");
        System.out.println("자바의 모든 마법은 class와 main에서 시작!");

        // 3. 변수와 데이터 타입
        String name = "해리포터"; // 문자열 변수
        int age = 17;            // 정수형 변수
        double height = 175.5;   // 실수형 변수
        boolean isWizard = true; // 논리형 변수

        System.out.println("이름: " + name + ", 나이: " + age + ", 키: " + height + ", 마법사? " + isWizard);

        // 4. 산술 연산자(+, -, *, /, %)
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b)); // 정수 나눗셈
        System.out.println("a % b = " + (a % b)); // 나머지

        // 5. 입력(Scanner)
        Scanner scanner = new Scanner(System.in);
        System.out.print("마법사의 이름을 입력하세요: ");
        String userName = scanner.nextLine();
        System.out.print("마법사의 나이를 입력하세요: ");
        int userAge = scanner.nextInt();
        scanner.nextLine(); // 개행 제거

        System.out.println("환영합니다, " + userName + " (" + userAge + "세) 마법사님!");

        // 6. 함수(메서드) 사용해보기
        int s = sum(100, 200);
        int m = mul(10, 20);
        int su = sub(50, 8);
        double d = div(10, 3);

        System.out.println("sum(100,200) = " + s);
        System.out.println("mul(10,20) = " + m);
        System.out.println("sub(50,8) = " + su);
        System.out.println("div(10,3) = " + d);

        // 7. 조건문(if, else)
        if (userAge >= 18) {
            System.out.println("성인 마법사입니다!");
        } else {
            System.out.println("학생 마법사입니다!");
        }

        // 8. 반복문(for)
        System.out.println("1~5까지 반복 주문!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("마법 주문 #" + i);
        }

        // 9. switch문
        System.out.print("마법의 숫자(1~3)를 입력하세요: ");
        int magicNum = scanner.nextInt();
        switch (magicNum) {
            case 1:
                System.out.println("파이어볼!");
                break;
            case 2:
                System.out.println("아이스스톰!");
                break;
            case 3:
                System.out.println("라이트닝!");
                break;
            default:
                System.out.println("알 수 없는 주문입니다.");
        }

        // 10. 마무리
        System.out.println("=== 복습 끝! 직접 숫자, 이름 바꿔가며 실행해보세요 ===");
        scanner.close();
    }
}