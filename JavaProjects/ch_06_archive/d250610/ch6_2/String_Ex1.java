package d250610.ch6_2;

public class String_Ex1 {
    public static void main(String[] args) {
        // 자주 사용하는 문자열, 타입 : 기본형이 아님, 참조형임!!!!
        // 문자열
        // 결론,: 도장을 찍어 내듯이 사용함,
        // 문자열을 변경할 때, 새로운 메모리 값을 사용한다.
        // 그래서, 메모리 낭비가 많다.

        // 대책, 이 문자열을 업그레이드에서, 매법 메모리 새로 사용 안하고,
        // 재사용하는 StringBuffer 클래스가 등장.
        String str = "Hello"; // 리터럴 방식.
        String str2 = new String("Java"); // 객체 생성 방식

        String str3 = str + " HI~~";

        System.out.println("str 임시 메모리 주소 확인 : " + System.identityHashCode(str));
        System.out.println("str2 임시 메모리 주소 확인 : " + System.identityHashCode(str2));
        System.out.println("str3 임시 메모리 주소 확인 : " + System.identityHashCode(str3));
        // 출력 결과를 확인 해보면, 매번 다른 주소 값을 확인.
        System.out.println("결과물 확인 str3 : " + str3);

        // 이번에는 업그레이드가 된 , StringBuffer 클래스를 활용해서, 똑같이, 문자열을 생성 후, 연결
        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" HI~~");
        String result = sb.toString();
        System.out.println("업그레이드가 된 StringBuffer 클래스 이용시 : 메모리 주소 확인 : " + System.identityHashCode(sb));
        System.out.println("결과물 확인 2: " + result);
    }

}
