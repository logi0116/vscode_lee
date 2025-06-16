/**
 * Demonstrates various Java programming concepts through an interactive magic-themed example.
 * 
 * This main method showcases:
 * - Array manipulation (1D and 2D arrays)
 * - Loop structures (while, do-while)
 * - Exception handling
 * - Simple member management system
 * - Bonus exercises for finding max value and calculating sum
 * 
 * Provides step-by-step demonstrations of fundamental programming techniques
 * with interactive user input and playful wizard-themed commentary.
 * 
 * @param args Command-line arguments (not used in this example)
 */
package remind;


import java.util.Scanner;

/**
 * ch3 핵심 복습 예제
 * - 배열, 반복문, 예외처리, 간단 회원 관리
 * - 각 단계별 해설과 마법사 대사 주석 포함
 */
public class Ch3MagicReview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 배열 선언과 값 할당
        // 마법사: "여러 개의 마법봉을 한 번에 관리하려면 창고(배열)가 필요하지!"
        int[] wands = new int[5]; // 크기 5인 정수형 배열 선언
        // 마법사: "각 칸에 마법봉 번호를 넣어보자!"
        for (int i = 0; i < wands.length; i++) {
            wands[i] = i + 1; // 1~5까지 값 할당
        }
        // 마법사: "창고에 있는 마법봉 번호를 모두 확인해볼까?"
        for (int wand : wands) {
            System.out.print(wand + " ");
        }
        System.out.println();

        // 2. 2차원 배열(마법의 바둑판)
        // 마법사: "이번엔 마법의 바둑판(2차원 배열)에 숫자를 채워보자!"
        int[][] board = new int[3][3];
        int num = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = num++;
            }
        }
        // 마법사: "바둑판을 펼쳐서 확인해보자!"
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }

        // 3. 반복문(while, do-while)
        // 마법사: "반복 주문을 외워볼까? 1부터 5까지 while로 세어보자!"
        int count = 1;
        while (count <= 5) {
            System.out.println("while 주문 #" + count);
            count++;
        }
        // 마법사: "do-while은 최소 한 번은 주문이 실행되지!"
        int doCount = 1;
        do {
            System.out.println("do-while 주문 #" + doCount);
            doCount++;
        } while (doCount <= 3);

        // 4. 예외처리(마법의 보호막)
        // 마법사: "혹시 0으로 나누는 실수를 할 수도 있으니 보호막을 쳐야 해!"
        try {
            System.out.print("나눗셈의 분자를 입력하세요: ");
            int a = scanner.nextInt();
            System.out.print("나눗셈의 분모를 입력하세요: ");
            int b = scanner.nextInt();
            int result = a / b; // 0으로 나누면 예외 발생!
            System.out.println("나눗셈 결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("마법 실패! 0으로 나눌 수 없어요.");
        }

        // 5. 간단 회원 관리(회원 추가/조회)
        // 마법사: "이제 마법사 명부(회원 목록)를 만들어보자!"
        String[] memberNames = new String[10]; // 최대 10명 저장
        int memberCount = 0;

        while (true) {
            System.out.println("\n=== 마법사 명부 관리 ===");
            System.out.println("1. 회원 추가 | 2. 회원 조회 | 0. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // 개행 제거

            if (menu == 1) {
                // 마법사: "새로운 마법사 이름을 입력해보자!"
                if (memberCount >= memberNames.length) {
                    System.out.println("명부가 가득 찼어요!");
                    continue;
                }
                System.out.print("마법사 이름 입력: ");
                String newName = scanner.nextLine();
                memberNames[memberCount] = newName;
                memberCount++;
                System.out.println("마법사 등록 완료!");
            } else if (menu == 2) {
                // 마법사: "지금까지 등록된 마법사들을 확인해볼까?"
                if (memberCount == 0) {
                    System.out.println("아직 등록된 마법사가 없어요.");
                } else {
                    for (int i = 0; i < memberCount; i++) {
                        System.out.println((i + 1) + "번 마법사: " + memberNames[i]);
                    }
                }
            } else if (menu == 0) {
                System.out.println("마법사 명부 관리 종료!");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다. 다시 선택하세요.");
            }
        }

        // 6. (보너스) 배열에서 가장 큰 수 찾기
        // 마법사: "마법봉 창고에서 가장 강력한(큰 번호) 마법봉을 찾아볼까?"
        int max = wands[0];
        for (int i = 1; i < wands.length; i++) {
            if (wands[i] > max) {
                max = wands[i];
            }
        }
        System.out.println("가장 강력한 마법봉 번호는: " + max);

        // 7. (보너스) 1~n까지의 합 구하기
        // 마법사: "마법의 합산 주문! 원하는 숫자까지 모두 더해보자!"
        System.out.print("합을 구할 마지막 숫자(n)을 입력하세요: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("1부터 " + n + "까지의 합은: " + sum);

        scanner.close();
        System.out.println("=== ch3 복습 마법 끝! ===");
    }
}