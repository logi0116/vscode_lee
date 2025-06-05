package ch4;

public class Car {
    // 멤버 변수
    String model; // 차종, 세단, SUV 등
    String price; // 가격
    String company; // 제조사
    // 메소드

    public void showInfo() {
        // this : 현재 객체를 가리키는 키워드
        System.out.println("모델명 : " + this.model);
        System.out.println("가격 : " + this.price);
        System.out.println("제조사 : " + this.company);
    }
}
