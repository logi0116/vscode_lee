package d250609.ch4;

// this 키워드 연습 예제
public class ThisPractice {
    private String value;

    // 1. 생성자에서 this 사용하기
    public ThisPractice(String value) {
        // 매개변수 value와 멤버 변수 value가 이름이 같을 때,
        // this.value는 멤버 변수, value는 매개변수를 의미함
        this.value = value;
    }

    // 2. 메서드에서 this 사용하기
    public void printValue() {
        // this.value와 value는 동일하게 멤버 변수를 가리킴
        System.out.println("멤버 변수 value: " + this.value);
    }

    // 3. this를 이용해 다른 생성자 호출하기 (생성자 오버로딩)
    public ThisPractice() {
        // 아래 생성자를 호출하여 value를 "기본값"으로 초기화
        this("기본값");
    }

    // 4. this를 반환하여 메서드 체이닝 구현
    public ThisPractice setValue(String value) {
        this.value = value;
        return this; // 자기 자신 객체를 반환
    }

    // 5. this를 사용하지 않을 때와의 차이
    public void setValueWithoutThis(String value) {
        // this를 생략해도 멤버 변수와 매개변수 이름이 다르면 멤버 변수가 할당됨
        value = value; // 이 코드는 멤버 변수가 아니라 매개변수에 자기 자신을 할당함 (의미 없음)
    }

    public static void main(String[] args) {
        // 1. 생성자에서 this 사용
        ThisPractice a = new ThisPractice("Hello");
        a.printValue(); // "멤버 변수 value: Hello"

        // 2. 기본 생성자에서 this()로 다른 생성자 호출
        ThisPractice b = new ThisPractice();
        b.printValue(); // "멤버 변수 value: 기본값"

        // 3. 메서드 체이닝
        a.setValue("World").printValue(); // "멤버 변수 value: World"

        // 4. this를 사용하지 않은 경우
        a.setValueWithoutThis("Test");
        a.printValue(); // 여전히 "멤버 변수 value: World" (값이 바뀌지 않음)
    }
}