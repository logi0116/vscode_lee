package ch1; // package 폴더

// public : 접근 지정자, 파란색으로 표기 되는 부분은 예약어 키워드, 
// 변수명으로 따로 사용안됨. 
// 파일명.java -> 파일명 = 클래스명, 주의사항,) 클래스 명, 시작은 대문자 
// 특수문자는 _,$ 와 이용가능, 
// 패키지명, 변수명, 함수명(메소드) 소문자로 시작하고, 
// 
public class Hello2(자바 기본 개념 및 용어) { // class : 변수, 상수, 함수 기능들의 묶음.
    // 정적인 메소드 하나 생성.
    // static : 정적 자원, 공유 자원, 나중에 인스턴스 개념과 구분해서 따로 설명이 필요함.
    // int : 기본형 타입, 현재는 함수의 반환 타입,
    // sum : 함수의 이름
    // (int n, int m) : 매개변수, 받는 변수
    // return : 함수를 실행 후, 반환하는 값,
    // 결론, 정수로 , n, m 값이 들어오면, 2개의 값을 더해서, 반환한다.
    // public static [반환값의 타입] [함수의 이름]([매개변수1], [매개변수2]) {
    // return 반환 하는 값;
    // 함수의 정의
    public static int sum(int n, int m) {
        return n + m;
    }

    // public : 접근 지정자, 누구나 다 접근이 된다(모두 볼수 있다)
    // static : 공유 자원의 의미,
    // void : 반환값이 없다는 의미.
    // main : 함수 이름 , 메인 함수에서 실행해서, 메인으로 종료함.
    // String[] args : String : 문자열 타입 ,
    // [] : 배열을 의미
    // args , 배열의 이름 (변경 가능)
    public static void main(String[] args) {
        // sum(100, 200) : 함수 이용,
        // 사용법 : [받을 변수 타입] [받는 변수명] = 함수이름(인자값1, 인자값2)
        // 함수를 사용하면 -> 함수가 정의가 된곳으로 이동함.
        int result = sum(100, 200);
        // 자바, 문자열은 무조건 ("") 큰 따옴표 사이에 작성.
        // 문자열 + 숫자 = 문자열 (타입)
        System.out.println("sum 이라는 함수 이용해서 결과 출력 : " + result);
        // 퀴즈1 ,
        // 정적 메소드 하나 만들어서, 곱하기 기능이고,
        // result2 에 담아서, 출력해보기
    }
}

/*
 * 영역이,
 * public class Hello {
 * 클래스 영역 안1 = 영역1 시작
 * 
 * sum 메소드 존재
 * multiple 메소드 추가 -퀴즈1
 * 
 * public static void main(String[] args) {
 * 메인 메소드 영역 안2 = 영역2 시작
 * 
 * sum 메소드 사용해서, 문자열 출력.
 * 
 * * multiple 메소드 사용 출력. -퀴즈1
 * 
 * 메인 메소드 영역 안2 = 영역2 영역 끝부분
 * }
 * 
 * 클래스 영역 안1 = 영역1- 영역 끝부분
 * }
 */

 ////////////////////////////////////////////////////////////////////////////////////////////
 /// 
 /// 
 /// package ch2;



 
public class Hello2 {
    // 정적인 메소드 정의,(함수정의)
    // 메소드1 , 결과 반환값의 타입 : int
    public static int sum(int n, int m) {
        return n + m;
    }

    // 메소드2 , 결과 반환값의 타입 : int
    public static int mul(int n, int m) {
        return n * m;
    }

    // 메소드3 , 결과 반환값의 타입 : int
    public static int sub(int n, int m) {
        return n - m;
    }

    // 메소드4 , 결과 반환값의 타입 : int
    public static int div(int n, int m) {
        return n / m;
    }

    // 메소드5 , 결과 반환값의 타입 : float
    public static float div_float(int n, int m) {
        return (float) n / m; // 정수를 입력 받아서, 계산시 이것도 정수로 계산이 되니깐
    }

    // 정적 메소드, 이름 : main
    public static void main(String[] args) {
        int result = sum(100, 200);
        System.out.println("sum 이라는 함수 이용해서 결과 출력 : " + result);
        // 퀴즈1 ,
        // 정적 메소드 하나 만들어서, 곱하기 기능이고,
        // result2 에 담아서, 출력해보기
        //
        // 메소드2 사용하기
        int result2 = mul(10, 20);
        System.out.println("mul 이라는 함수 이용해서 결과 출력 : " + result2);

        // 퀴즈2,
        // 정적 메소드 하나 만들어서, 빼기 기능이고,
        // result3 에 담아서, 출력해보기
        // 함수 이용
        int result3 = sub(100, 20);
        System.out.println("sub 이라는 함수 이용해서 결과 출력 : " + result3);

        // 퀴즈3,
        // 정적 메소드 하나 만들어서, 나누기 기능이고,
        // result4 에 담아서, 출력해보기
        int result4 = div(1, 3);
        System.out.println("div 이라는 함수 이용해서 결과 출력 : " + result4);

        float result5 = div_float(1, 3); // 반환값의 타입이 :float 이니까, 받을 변수의 타입도 일치
        System.out.println("div_float 이라는 함수 이용해서 결과 출력 : " + result5);

        // 퀴즈 풀는 도중에, 정수로만 데이터 타입을 처리하고 있는데,
        // 소수로 -> 실수로 표현은 어떻게 할까?/
        // 데이터 타입에 대해서
        // 기본형,
        // byte, int, short ,float , long, double, char, boolean
        // 참조형 : 기본형을 제외한 나머지 모두를 가리킨다.
        // 객체(Object), 배열(Array), 문자열(String ) 등

        // 결론,
        /*
         * 1) 클래스 영역과, 메인 함수 영역 구분
         * 2) 메인 함수로 시작 , 끝으로 한다.
         * 3) 메인 함수도 알고 보니, 정적인 함수(메소드)
         * 4) 클래스명, 파일명(.java ) 동일해야한다.
         * 5) 변수에서 , 기본형, 참조형이 있는데, 현재는 2개, int , String 타입 이야기 했고,
         * 6) 문자열을 표기시에 , 큰 따옴표로 표기해서 사용한다.
         * 7) 정적 메소드(함수)를 정의하고,
         * 8) 정적 메소드를 사용(호출), 사용시, 정의한 메소드로 가서, 액션을 하고 돌아와서 재사용.
         * 9) 클래스 명, 대문자로 시작하고, 패키지 명과, 메소드(함수)명 은 소문자로 시작하고
         * 10) 이름 작성시, 사용 가능한 특수 문자는 $, _ , 달러기호와 언더바만 사용 가능.
         * 
         */

        int s; // 변수를 정의만 했고, 실제 할당은 안한 상태,
        char a; // 데이터 타입 char , 한 문자만을 의미 함.
        s = 100;
        a = 'd';
        System.out.println("정수 표현 : " + s);
        System.out.println("문자 표현 : " + a);

        // 타입, 스캐너 입력 방법등 설명 하면서,

        // 퀴즈 4 - 과제
        // 본인의 이름과, 전화번호, 이메일을 입력 받는 매개변수가 3개이고,
        // 출력값은 문자열 타입인데 : 결과는
        // 저는 {이름} 입니다.
        // 제 전화번호 : {전화번호}이고,
        // 이메일: {이메일} 입니다.
        // 출력 하는 예제 해보기.

    }
}
