package d250610.ch5;

public class ShapeMainEx1 {
    public static void main(String[] args) {
        // 기본 인스턴스 생성.
        CircleEx1 circleEx1 = new CircleEx1();
        circleEx1.draw();
        RectangleEx1 rectangleEx1 = new RectangleEx1();
        rectangleEx1.draw();

        // 질문, 부모클래스를 상속을 받은 상태이고,
        // 부모 클래스에도 , 메소드 : draw() 있고,
        // 자식 클래스에도 , 메소드 : draw() 있고,
        // 현재, circleEx1, 타입이 : 본인 타입 :CircleEx1
        // draw 사용시, -> 누구꺼 사용했니? 부모? 자식? , 정답 : 자식 본인꺼 사용.

        // 다형성 이용해서, 부모 타입으로 받는 모양,
        // (부모 타입) (인스턴스 변수 명) = new 자식클래스명();
        // (인스턴스 변수 명) 의 타입? -> 정답 : 부모 타입.
        // (인스턴스 변수 명) 으로 메소드 , draw() 사용시 누구꺼 사용하나요?
        // 정답 ? 부모? 자식ㅇ ,
        // 가상메소드 ? 부모, 자식에 같은 메소드가 있다면, 자식의 메소드를 이용하는 것.
        ShapeEx1 shapeEx12 = new CircleEx1(); // 자식 타입 -> 부모 타입 , 형변환, 업 캐스팅
        ShapeEx1 shapeEx13 = new RectangleEx1();
        shapeEx12.draw();
        shapeEx13.draw();

    }
}
