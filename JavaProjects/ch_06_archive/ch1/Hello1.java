




//package ch2; //패키지 폴더
//
//public : 접근 지정자, 파란색으로 표기되는 부분은 예약어 키워드,
//변수명으로 따로 사용안됨.
//파일명.java -> 파일명 = 클래스명
//주의사항. 클래스명의 시작은 대문자로 해야함.
//특수문자는 _,$만 이용가능하다.
//패키지명, 변수명, 함수명(메소드) 소문자로 시작함.
//
//
//public class Hello1 {  //class : 변수나 상수나 함수 기능들의 묶음)
//
//	//정적인 메소드 하나 생성.
//	//static : 정적 자원, 공유 자원, 나중에 인스턴스 개념과 구분해서 따로 설명들을 것.
//	//int : 기본형 타입, 현재는 함수의 반환 타입,
//	//sum : 함수의 이름
//	//(int n, int m) : 매개변수, 받는 변수
//	//return : 함수를 실행 후, 반환하는 값,
//	//결론, 정수로, n,m 값이 들어오면 2개의 값을 더해서, 반환한다.
//	public static [반환값의 타입] [함수의 이름]([매개변수 1],[매개변수 2]) {
//	// return 반환 하는 값;
//	
//	
//	//public : 접근 지정자, 누구나 다 접근이 된다(모두 볼 수 있다)
//	//static : 공유 자원의 의미,
//	//voide : 반환값이 없다는 의미.
//	//main : 함수의 이름
//	//String[] args : String : 문자열 타입,
//	//[]: 배열을 의미
//	//args, 배열의 이름(변경 가능)
//	
//	public static void main(String[] args) {
//		int result = sum(n:100,m:200);
//		System.out.println("sum이라는 함수를 이용해서 결과 출력");
//	}
//
//

package ch1;



public class Hello1 {  
    // sum 메서드 추가
    public static int sum(int n, int m) {
        return n + m;
    }

    public static void main(String[] args) {
        int result = sum(100, 200); // 올바른 메서드 호출, n 과 m 은 흑색이라서 안 쳐도 되는. 
        System.out.println("결과: " + result); // 결과 출력
    }





    



}

//자바에선 문자열 큰 따옴표 "" 사이에 작성
// 문자열 + 숫자 = 문자열 (타입)



// 퀴즈 1. 정적 메소드 하나 만들어서, 두 수를 더해서 반환하는 함수를 만들어보세요.
// 퀴즈 2. 메인 함수에서 호출해서 결과를 출력해보세요.

