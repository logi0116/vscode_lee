package ch4;

public class MainClassCh4 {
    // 실행 하는 클래스
    public static void main(String[] args) {
        // 설계한 클래스를 이용해서
        // 객체 생성 ,
        // 순서1
        // [클래스명] 객체명(인스턴스 변수명) = new [클래스명]();
        // new Car() : 기본 생성자,
        Car car1 = new Car(); // 기본 생성자 호출
        // 순서2
        // 해당 자동차의 멤버 변수에 값 대입, 직접 값을 할당, 실무에서는 이렇게 사용안하고,
        // getter/setter 메소드를 사용 -> 불변성을 이용해서, 캡슐화, 밖에서 안보이게 , 접근 지정자로
        // 꽁꽁 숨길 예정. 지금은 기본이니, 참고만 함.
        car1.model = "suv";
        car1.price = "4000만원";
        car1.company = "기아자동차";
        // 순서3, 기능 확인. 객체명.메소드명(); 이런 형식으로 사용함,
        // 이전에 정적인 메소드는 , 사용 모양 : 클래스명.메소드명() , 비교.
        car1.showInfo();

        // 마치 공장에서 자동차를 찍어 내듯이, 또다른 인스턴스를 생성.
        Car car2 = new Car(); // 기본 생성자 호출
        car2.model = "k5세단";
        car2.price = "3000만원";
        car2.company = "기아자동차";
        car2.showInfo();
    }
}
