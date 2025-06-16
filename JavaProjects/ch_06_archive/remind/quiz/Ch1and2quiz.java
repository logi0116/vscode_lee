package remind.quiz;

import java.util.Scanner;

public class Ch1and2quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 변수 선언과 초기화 실습
        System.out.println("\n[문제1] 마법사의 이름을 저장하는 변수를 선언하고, '루나'로 초기화하는 코드를 작성해보세요.");
        System.out.print("직접 입력: String 변수명 = ");
        String wizardName = sc.nextLine();
        System.out.println("입력한 코드: String " + wizardName + " = \"루나\";");

        // 2. if문 조건 예측
        System.out.println("\n[문제2] 아래 코드에서 age가 15일 때 출력 결과를 예측해보세요.");
        System.out.println("int age = 15;");
        System.out.println("if (age >= 18) {\n    System.out.println(\"성인 마법사\");\n} else {\n    System.out.println(\"학생 마법사\");\n}");
        System.out.print("예측 결과를 입력하세요: ");
        String answer2 = sc.nextLine();
        System.out.println("당신의 예측: " + answer2);
        System.out.println("정답: 학생 마법사");

        // 3. for문 동작 분석
        System.out.println("\n[문제3] 아래 코드가 출력하는 결과를 예측해보세요.");
        System.out.println("for (int i = 1; i <= 3; i++) {\n    System.out.println(\"마법 주문! \" + i);\n}");
        System.out.print("몇 줄이 출력될까요? ");
        int lines = sc.nextInt();
        sc.nextLine();
        System.out.print("마지막 줄의 내용을 입력하세요: ");
        String lastLine = sc.nextLine();
        System.out.println("정답: 3줄, 마지막 줄은 '마법 주문! 3'");

        // 4. switch문 분기 설계
        System.out.println("\n[문제4] 마법 속성에 따라 효과를 출력하는 switch문을 설계해보세요.");
        System.out.println("속성: 불, 물, 바람, 땅");
        System.out.print("속성을 입력하세요: ");
        String element = sc.nextLine();
        switch (element) {
            case "불": System.out.println("뜨겁게 불태운다!"); break;
            case "물": System.out.println("시원하게 적신다!"); break;
            case "바람": System.out.println("빠르게 휘몰아친다!"); break;
            case "땅": System.out.println("단단하게 막아낸다!"); break;
            default: System.out.println("알 수 없는 속성입니다.");
        }

        // 5. 함수(메서드) 설계
        System.out.println("\n[문제5] 두 마법의 힘을 더해주는 sum 메서드를 선언해보세요.");
        System.out.print("sum 메서드의 리턴값을 입력하세요 (예: return a + b;): ");
        String sumBody = sc.nextLine();
        System.out.println("public static int sum(int a, int b) { " + sumBody + " }");
        System.out.println("정답 예시: public static int sum(int a, int b) { return a + b; }");

        // 6. 코드 수정(오류 찾기)
        System.out.println("\n[문제6] 아래 코드에서 오류가 나는 부분을 찾고, 어떻게 고칠지 설명해보세요.");
        System.out.println("int level;\nSystem.out.println(level);");
        System.out.print("오류 원인과 수정 방법을 입력하세요: ");
        String answer6 = sc.nextLine();
        System.out.println("정답: 지역변수 level은 초기화하지 않으면 사용할 수 없습니다. → int level = 0; 등으로 초기화 필요");

        // 7. 조건문 논리 설계
        System.out.println("\n[문제7] 마법사의 경험치(exp)가 100 이상이면 '레벨업', 아니면 '경험치 부족'을 출력하는 if문을 작성해보세요.");
        System.out.print("exp 값을 입력하세요: ");
        int exp = sc.nextInt();
        sc.nextLine();
        if (exp >= 100) {
            System.out.println("레벨업");
        } else {
            System.out.println("경험치 부족");
        }

        // 8. 반복문 예측
        System.out.println("\n[문제8] 아래 코드가 출력하는 결과를 예측해보세요.");
        System.out.println("for (int i = 5; i >= 1; i--) {\n    System.out.println(i);\n}");
        System.out.print("첫 줄에 출력되는 숫자: ");
        int first = sc.nextInt();
        System.out.print("마지막 줄에 출력되는 숫자: ");
        int last = sc.nextInt();
        sc.nextLine();
        System.out.println("정답: 첫 줄 5, 마지막 줄 1");

        // 9. 코드 리팩토링
        System.out.println("\n[문제9] 아래 코드를 더 간단하게 바꿔보세요.");
        System.out.println("if (flag == true) {\n    System.out.println(\"마법 발동!\");\n}");
        System.out.print("더 간단한 조건문을 입력하세요: ");
        String refactor = sc.nextLine();
        System.out.println("정답 예시: if (flag) { System.out.println(\"마법 발동!\"); }");

        // 10. 변수/타입 예측
        System.out.println("\n[문제10] 아래 코드에서 result 변수의 타입을 예측해보세요.");
        System.out.println("var result = 10 + 3.5;");
        System.out.print("result의 타입은 무엇일까요? ");
        String type = sc.nextLine();
        System.out.println("정답: double");

        sc.close();
        System.out.println("\n=== 마법 판타지 코딩 사고력 퀴즈 끝! 각 문제를 직접 입력하며 연습해보세요! ===");
    }
}