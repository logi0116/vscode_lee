package ch2;

public class Exs_Main {
    public static void main(String[] args) {

        // EX2-9, 삼항 연산자 예시
        String result_ex2_9 = Exs_doc.getTernaryExam(75);
        System.out.println("EX2-9, 삼항 연산자 예시: " + result_ex2_9);
        System.out.println("----------------------------");
        // EX2-7, a++, ++a 예시,
        Exs_doc.getIncDecExam();

        System.out.println("----------------------------");
        // 강제 형변환 예시
        Exs_doc.getTypeExam();
        System.out.println("----------------------------");
        // EX2-3
        System.out.println("파이널 상수 이용한, 원면적 구하기 예제");
        // 반지름 5.0인 원의 면적 구하기
        String result = Exs.getCircleArea(5.0);
        System.out.println(result);
    }
}
