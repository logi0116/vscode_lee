package util.random;

public class RandomUtil_doc {
    // 설계 클래스
    // Math 클래스에 있는 random() 메소드를 사용하여
    // 0.0 이상 1.0 미만의 난수를 생성하는 메소드를 작성
    // 기본 기능 확인용, 정적 메서드 추가해보기.
    public static double generateRandom() {
        // 데이터 타입 : double, 변수명 : randomValue
        // Math 클래스의 정적 메소드 random()를 호출하여
        double randomValue = Math.random();
        return randomValue;
    }

    // 특정 범위의 난수를 생성하기. 실수 -> 정수 형태로 변경.
    // 1 이상 10 이하의 난수를 생성하는 메소드 작성
    public static int generateRandomInRange(int min, int max) {
        // Math.random()을 사용하여 0.0 이상 1.0 미만의 난수를 생성
        // 이를 이용하여 원하는 범위의 정수 난수를 생성

        // 설명 1. Math.random() : 0.0 이상 1.0 미만의 난수를 생성
        // 결과 모양 0.0 <= x < 1.0 ,

        // 예시) min = 1, max = 10
        // 설명 2. Math.random() * (max - min + 1)
        // 결과 모양 0.0 <= x < 10.0
        //
        // 형변환 연산자, 캐스팅 연산자라고 하고, 기호는 소괄호를 사용.
        // 예시 )
        // (변환하고 싶은 타입) 원래 데이터
        // 예시) (int) Math.random() * (max - min + 1)

        // 설명 3. (int) Math.random() * (max - min + 1) : double 타입을 int 타입으로 변환
        // 결과 모양 0 <= x < 10

        // 설명 4. (int) Math.random() * (max - min + 1) + min
        // 결과 모양 1 <= x < 11
        // -> 1 <= x <= 10
        int randomValue = (int) (Math.random() * (max - min + 1)) + min;
        return randomValue;
    }
}
