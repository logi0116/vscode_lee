package d250610.ch5;

public class CircleEx1 extends ShapeEx1 {
    // 자식 클래스만의 멤버를 구성.
    private int edgeCount;

    // 부모의 draw 사용하니, 단순 도형 그리기 하니,
    // 원 모양으로 그리기 기능으로 재정의,
    // 오버라이딩
    // 메서드 이름과 반환 값은 같지만, 구현체 실행 기능이 다름.
    @Override
    public void draw() {
        System.out.println("원 모양 그리기");
    }
}
