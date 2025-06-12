package d250610.ch5_2;

// 추상 클래스 (공통 기능을 가지는 클래스 )
// 추상 메서드를 하나 이상 가져야함. 
// 추상 클래스는 인스턴스를 생성 할수 없음. 
// 추상 클래스를 상속 받은 자식 클래스는 의무적으로 반드시, 추상 메서드를 
// 구현해야함(재정의)
public abstract class Animal_Ex1 {
    // 추상 메서드 , 필수적으로 재정의 해야함.
    abstract void sound();

    // 일반 메서드
    void eat() {
        System.out.println("먹기");
    }

}
