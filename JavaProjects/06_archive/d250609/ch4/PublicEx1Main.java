package d250609.ch4; // 같은 폴더입니다. 현재 속한 폴더의 위치를 알려줌. 

public class PublicEx1 {
    // 접근 지정자.

    // public : 모든 클래스에서 접근 가능.
    // private : 같은 클래스 내부에서만 접근 가능.
    // protected : 같은 패키지 또는 상속 관계 클래스에서만 접근 가능.
    // (default) : 같은 패키지에서만 접근 가능함.
    // 결론, 접근 지정자는, 해당 클래스에 접근의 가능 여부.
    // 예시 ) 패키지(폴더) 개념,
    // exA 패키지 ->Ex1Test.java
    // exB 패키지 ->Ex2Test.java
    // 다른 폴더에 있는 내용(클래스)를 불러오기 위해서 필요한 키워드 : import

    // 멤버 변수를 설정.
    private String name; // 외부 접근 불가.
    public String eamil; // 모든 클래스에서 접근 가능.
    String phone; // default 생략 같은 패키지에서만 접근 가능함.
    protected String hobby; // 같은 패키지 또는 상속 관계 클래스에서만 접근 가능.
    
}
