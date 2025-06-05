package ch1;

public class Hello4 {

    // ✅ 더하기 메서드
    public static int sum(int a, int b) {
        return a + b;
    }

    // ✅ 곱하기 메서드
    public static int multiply(int number, int factor) {
        return number * factor;
    }

    // ✅ 결과 출력 메서드
    public static void printResult(String message, int value) {
        System.out.println(message + value);
    }

    public static void main(String[] args) {
        int sumResult = sum(555, 222); // sum() 메서드 호출
        printResult("더하기 결과: ", sumResult);

        int multiplyResult = multiply(sumResult, 3); // multiply() 메서드 호출
        printResult("곱하기 결과 (777 * 3): ", multiplyResult);
    }
}