package d250610.ch6;

public class Object_Ex1 {
    // 모든 클래스는 암묵적으로 Object 최고 상위 클래스 무조건 상속 받고 있음.
    // 자식 클래스는 , 부모가 만들어둔 기능을 사용이 가능함.
    // 하지만, 사용 가능하지만, 별 쓸모가 없음.
    // 그래서, 우리의 입맛에 맞게 변경해서 사용, 재정의
    String name;

    public Object_Ex1(String name) {
        this.name = name;
    }

    // Object 에서 지원 해주는 toString 에대해서,
    // 1) 기본 기능 으로 사용하기.
    // 2) 재정의해서 사용하기.
    // 해당 객체를 출력 할 때, 우리가 정의한 내용을 toString() 에 담을수 있음.
    // Member member = new Member();
    // System.out.println(member), 출력 하게 되면,
    // @Override
    // public String toString() { 여기의 내용을 반환을 함.
    //
    @Override
    public String toString() {
        String result = "이 클래스의 멤버 변수 name 의 값 : " + name;
        return result;
    }
}
