import java.util.Scanner;

public class DebuggingPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: "); // 📌 중단점 1️⃣ - 사용자 입력 확인
        int number = scanner.nextInt();

        int result = processNumber(number); // 📌 중단점 2️⃣ - 함수 호출 전 값 확인
        System.out.println("결과 값: " + result); // 📌 중단점 3️⃣ - 함수 실행 후 값 확인

        scanner.close();
    }

    public static int processNumber(int num) {
        int sum = 0;

        for (int i = 1; i <= num; i++) { // 📌 중단점 4️⃣ - 반복문 진행 추적
            sum += i;
            System.out.println("현재 합: " + sum); // 📌 중단점 5️⃣ - sum 값 변경 추적
        }

        if (sum % 2 == 0) { // 📌 중단점 6️⃣ - 짝수/홀수 조건 확인
            System.out.println("합이 짝수입니다.");
        } else {
            System.out.println("합이 홀수입니다.");
        }

        return sum; // 📌 중단점 7️⃣ - 최종 반환 값 확인
    }
}