package ch4;

public class Car_doc {

    // 퀴즈1
    // 설계 클래스, Phone ,
    // 멤버 변수 : model, price, company
    // 메서드 : showInfo(), 해당 정보 출력하는 메서드 만들기.
    // 객체 3개 이상 생성후, 정보 출력하는 메소드 사용해보기

    // 설계하는 클래스
    // 객체 : 클래스로부터 만들어진 실체 (=인스턴스)
    // 생성자 : 객체를 생성시 자동으로 호출되는 특별한 메소드
    // 1) 기본생성자, 2) 매개변수 생성자
    // 클래스의 구성품
    // 1) 멤버 변수
    // 2) 생성자
    // 3) 메소드

    // 멤버 변수
    String model; // 차종, 세단, SUV 등
    String price; // 가격
    String company; // 제조사

    // 생성자
    // 1)기본 생성자
    // 2) 매개변수 생성자

    // 메소드
    public void showInfo() {
        // this : 현재 객체를 가리키는 키워드
        System.out.println("모델명 : " + this.model);
        System.out.println("가격 : " + this.price);
        System.out.println("제조사 : " + this.company);
    }
}
