package d250610.ch5_2;

public class InterfaceClass_Ex1 {

    // 비교, 추상클래스 vs 인터페이스
    // 추상 클래스 : 템플릿 제공자, 케이크를 만들기 위한 반죽 틀을 주지만,
    // 데코는 알아서 하는 구조,

    // 인터페이스 : 설계 계약서, 모든 클래스는 이 규칙을 반드시 구현해야 하며
    // 기능 표준을 보장.

    // 추상클래스
    // is A : 개는 동물이다. , Dog extends Animal

    // 인터페이스
    // can do 관계 : 새는 날수 있다. Bird implements Flyable

    // 인터페이스
    // : 기능을 갖추기 위한 약속(계약)
    // 자바는 다중 상속을 지원하지 않음. 다중 구현을 하기 위해서 도입됨.
    // 키워드 :상속 abstract vs interface ,
    // 구현시 :상속 extends vs implements
    // 기능 규약 정의, 설계 기반 제공.
    // 구성품, 상수 또는 추상 메서드를 기본으로 구성함.
    // 자바 8이전에는 전부 추상 메서드로만 구성이 되었지만,
    // 현재는 static, default 그 밖의 여러 기능도 도입 이 가능함.
    // 기본 예시
    // interface Flyable {
    // void fly() ; // 추상 메서드
    // }
    // 구현
    // class Bird implements Flyable {
    // @Override
    // public void fly() { // 의무적으로 재정의 해야함.
    // System.out.println("훨훨 날기~~")
    // }
    // }
}
