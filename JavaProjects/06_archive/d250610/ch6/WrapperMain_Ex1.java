package d250610.ch6;

import java.util.ArrayList;

class WrapperMain_Ex1 {
    public static void main(String[] args) {
        // 자주 사용하는 옵션
        // 예시1, 문자열 -> Wrapper 객체 변환(Integer),
        Integer intObj1 = Integer.valueOf("123");
        // 기본형 -> 참조형 으로 변경을 왜 하나요? 배열, 업그레이드 된 배열(컬렉션(리스트,셋,맵)) 등 사용시,
        // 해당 요소를 클래스 형으로 담아야함. 왜냐하면, 컬렉션의 요소는 전부 타입으로 지정해야함.
        // 자바 -> 코틀린 언어, 모든 타입이 객체임. (물론 파이썬)
        // 자바스크립트 -> 리액트 문법 사용시, 타입 스크립트.
        Integer[] ints = { intObj1 };
        // ArrayList arrayList = new ArrayList<Integer>();
        // arrayList.add(intObj1);
        // arrayList.add(1); // 1 기본형 -> 참조형(Integer) 자동 박싱이 됨.

        // 문자열 -> 기본형 int
        // Integer : 클래스명, parseInt : 메소드 명, 정적 메소드 함.
        int num1 = Integer.parseInt("12345");

        // Wrapper 객체 문자열 -> 기본형
        double d = Double.parseDouble("123.0");

        // 최대값, 최솟값 많이 활용함.
        int num2 = Integer.MAX_VALUE;
        int num3 = Integer.MIN_VALUE;

    }
}