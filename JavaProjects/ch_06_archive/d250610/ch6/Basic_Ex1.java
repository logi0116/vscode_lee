package d250610.ch6;

public class Basic_Ex1 {
    // 1
    // 자바에서 제공하는 (JDK) 주요 패키지(폴더:기능(클래스)모아 둔 )
    //
    // java.lang : String, Object, Math 등 기본 클래스 제공.
    // java.util : 날짜, 컬렉션, Scanner 등 유틸리티 제공.
    // ============================================================================
    // 2
    // Object , 간단히 언급, 모든 클래스는 암묵적으로 Object 상속 하고 있다.
    // 상속은 받지만, Object 기능을 사용 안하고, 재정의해서 사용한다.
    //
    // Object 주요 메서드
    // Object obj = new Object();
    // obj.toString(); // 객체 정보를 문자열로 반환
    // obj.equals(other); // 객체 비교
    // obj.hashCode // 해시값 비교.

    // ============================================================================

    // 3
    // Wrapper 클래스 : 기본형 타입 -> 참조형 타입으로 변경하는 클래스
    // int 타입 -> Integer 클래스형 변경. , 또는 문자열 "123" -> 숫자형으로 변경하거나,
    //
    // Autoboxing : 기본형 -> 객체형(참조형) 타입으로 자동 변환
    // Unboxing : 객체형 -> 기본형 타입으로 자동 변환

    // Wrapper 클래스,
    // 기본형 || Wrapper 클래스
    // boolean | Boolean
    // char | Character
    // byte | Byte
    // short | Short
    // int | Integer
    // long | Long
    // float | Float
    // double | Double

    // 예시 , 박싱
    // int num = 10 ;
    // 박싱 , 기본형 -> 참조형(클래스타입)
    // Integer intObj = Integer.valueOf(10); // 수동으로 변경.
    // Integer intObj2 = num; // 자동으로 형변환,

    // 예시2 , 언박싱, 참조형 -> 기본형
    // Integer intObj = Integer.valueOf(10);
    // int num = intObj.intValue(); // 수동으로 변경
    // int num2 = intObj; // 자동으로 변경.

    // ============================================================================

}
