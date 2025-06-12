package d250610.ch5;

public class ShapeEx1 {
    // 설계 클래스인데, 내가 만든 기능인, draw 사용안하고, 각 자식 클래스에서 메서드를 다르게
    // 재정의 해서 사용하구나, 그럼? 여기 draw 의 기능은 필요가 없을까?
    // 다음 설계시 주의점
    // 추상클래스
    // 1) 내가 만든 기능은 이름만 정의를 하고, 기능을 구현을 안해야지 왜?, 어차피 내꺼 안쓰고, 각자
    // 알아서 재정의해서 사용하니.
    // 2) 인터페이스
    // 갑자기 자식 클래스에서 , 필수적으로 재정의해야할 기능을 사용을 누락하는 경우가 있음.
    // 그래서, 필수 기능은 강제 적으로 반드시 구현을 하게끔, 만약, 안하면, 경고 띄우기.
    // 3) 인터페이스
    // 공통 기능, 부모 클래스에 정의하고, 재사용하는데, 단점, 상속은 하나만 됨,
    // 그럼 다양한 기능을 추가 하고 싶을 때, 하나의 클래스에서 파일의 내용이 길어짐.
    // 그래서, 그럼 어떻게 다양한 기능을 추가하고, 재사용, 객체지향적으로 접근 할 까. ?

    private String kind;
    private String name;

    public void draw() {
        System.out.println("도형 그리기 기능");
    }

    // 기본 생성자는 안만들어줌. (매개변수 생성자가 있는 경우, )
    // 직접 만들기.
    public ShapeEx1() {
    }

    // 생성자 오버로딩. -> 메소드 오버로딩,
    // 오버로딩 -? 저그 이야기 -> 짐을 더 추가.
    // 여기서 의미는 , 생성자의 모양을 똑같지만, 매개변수의 모양, 갯수가 다른 것.
    // 생성자 만들지 여부,
    public ShapeEx1(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    // 게터/세터 여부,
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 실무, 세터 보다는 변경하는 메소드를 만들어서 수정하고,
    // 직접 수정을 안함. 불변성 유지하기 위해서, -> 리액트 다시 언급.,
    // 서버 사이드 렌더링 작업 중. 웹 1차 작업 위한 개별 학습 중.

    // showInfo 여부.
    public void showInfo() {
        System.out.println("종류 : " + kind);
        System.out.println("이름 : " + name);
    }

}
