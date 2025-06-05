package ch3;

import java.util.Scanner;

public class Exs_ch3 {
    // ex3--6-3, 이중 배열 예시
    public static void ex3_6_3() {
        // 기본 문법
        // 자료형[][] 배열이름 = new 자료형[행의 수][열의 수];

        // 이중 배열 선언 및 초기화
        int[][] matrix = {
                // 0열 1열2열
                { 1, 2, 3 }, // 첫 번째 행, 0행
                { 4, 5, 6 }, // 두 번째 행, 1행
                { 7, 8, 9 } // 세 번째 행, 2행

        };

        // 이중 배열 값 출력
        for (int i = 0; i < matrix.length; i++) { // 행 반복
            for (int j = 0; j < matrix[i].length; j++) { // 열 반복
                System.out.print("matrix[" + i + "] [" + j + "] :" + matrix[i][j] + "  "); // 각 요소 출력
            }
            System.out.println(); // 행이 끝나면 줄바꿈
        }
    }

    // ex3-6-2, 배열 직접 생성과 값 할당 예시
    public static void ex3_6_2() {
        // 배열 직접 생성과 값 할당 예시
        int[] numbers = { 1, 2, 3, 4, 5 }; // 배열 선언과 동시에 값 할당

        // 배열 값 출력
        // 향상된 for 문 기본 문법 형식,
        // for (자료형 변수 : 배열이름) { // 배열에서 각 요소를 하나씩 꺼내서 변수에 할당
        for (int number : numbers) {
            System.out.print(number + " "); // 1 2 3 4 5 출력
        }
        System.out.println(); // 줄바꿈
    }

    // ex3-6, 배열,
    // 선언하는 방법 크게 2가지
    // 자료형[] 배열이름 = new 자료형[크기]; // 기본 방식
    // 자료형 배열이름[] = new 자료형[크기]; // 오래된 방식 (C 스타일)

    // 예시 , 숫자 타입의 배열을 선언하기, 공간 5개 설정.
    public static void ex3_6() {
        int[] numbers = new int[5]; // 배열 선언, 크기 5개
        // int numbers[] = new int[5]; // C 스타일 배열 선언 (오래된 방식)

        // 배열에 값 할당
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // 1부터 5까지의 값 할당
        }

        // 배열 값 출력
        for (int number : numbers) {
            System.out.print(number + " "); // 1 2 3 4 5 출력
        }
        System.out.println(); // 줄바꿈
    }

    // ex3-5 , continue 확인 , 다음 반복으로 넘어가는 예시,
    // 숫자는 5개 입력을하고, 합을 구하는 예시, 음수 또는 0이 입력되면, 새로 입력 함.
    public static void ex3_5(Scanner scanner) {
        System.out.println("정수를 5개 입력하세요.");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            System.out.println("입력한 숫자: " + n + ", i의 값 확인 : " + i); // 입력한 숫자 확인용
            if (n <= 0)
                continue; // 0이나 음수인 경우 더하지 않고 다음 반복으로 진행
            else
                sum += n; // 양수인 경우 덧셈
        }
        System.out.println("양수의 합은 " + sum);

    }

    // 중첩 반복문 이용해서 구구단 출력해보기
    public static void ex3_4() {
        for (int i = 1; i < 10; i++) { // 단에 대한 반복. 1단에서 9단
            for (int j = 1; j < 10; j++) { // 각 단의 곱셈
                System.out.print(i + "*" + j + "=" + i * j); // 구구셈 출력
                System.out.print('\t'); // 하나씩 탭으로 띄기
            } // 두번째 for 문
            System.out.println(); // 한 단이 끝나면 다음 줄로 커서 이동
        } // 첫번째 for 문
    }

    public static void ex3_3() {
        char a = 'a';
        do {
            System.out.print(a);
            System.out.println(" , char 타입의 " + a + " -> int 변환시 , 값: " + (int) a + ", 유니코드 값 : " + (int) a);
            // char 타입의 a -> int 변환시 , 값: 97, 유니코드 값 : 97
            a = (char) (a + 1); // a+1 는 int 타입으로 계산되므로, char로 변환
        } while (a <= 'z');
    }

    // 퀴즈
    // 사용자로 부터 문자를 입력을 받아, q가 나올때 까지 문자의 개수를 세는 프로그램을 작성하세요.
    //
    public static int ex3_2_quiz(Scanner scanner) {
        String total = ""; // 입력된 총 문자열 수

        while (true) {
            System.out.println("문자를 입력하세요 (다음 문장에 q를 입력하면 종료): ");
            String input = scanner.nextLine(); // 한 줄 입력 받기
            total += input; // 입력된 문자열을 누적
            System.out.println("계속 입력하려면 아무키나 입력하고, 종료시에 q를 입력하세요.");
            String command = scanner.nextLine(); // 다음 명령어 입력 받기
            if (command.equals("q")) { // 대소문자 구분 없이 q 입력시 종료
                break; // while 문 종료
            }
        }
        int count = total.length(); // 입력된 문자열의 길이(문자 개수)
        return count;
    }

    // ex3-2 , while 문 이용해서, 예,
    // 0이 입력이 되면 while 문종료, 입력한 숫자들의 합을 구하기. '
    // 숫자의 합은 콘솔에 입력해서, 스캐너 이용해서 입력하기.
    public static void ex3_2(Scanner scanner) {
        // java.util.Scanner scanner = new java.util.Scanner(System.in);
        int sum = 0;
        int input;

        System.out.println("숫자를 입력하세요 (0을 입력하면 종료): ");
        while (true) {
            // scanner.nextInt(); -> 콘솔에 숫자 하나 입력후, 공백을 기준으로 다음 숫자를 읽기
            input = scanner.nextInt();
            if (input == 0) {
                break; // 0이 입력되면 while 문 종료
            }
            sum += input; // 입력한 숫자를 합산
        }
        System.out.println("입력한 숫자의 합은: " + sum);
        // scanner.close(); // 스캐너 자원 반납
    }

    // ex3-1
    // 기본 for 이용해서, 1~10까지 의 합을 구하는 내용인데.
    // 입력값에 원하는 숫자를 입력시, 1~n까지의 합을 구하는 메소드로 변경
    public static int getSum(int n) {
        int sum = 0;
        // 기본 for 문 , 문법을 확인.
        // 1) int i = 1; 초깃값 , 2) i <= 10; 조건식, 3) i++ 증감식
        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i); // i 값 확인용
            sum += i;
            System.out.println("sum = " + sum); // sum 값 확인용
        }
        return sum;
    }
}
