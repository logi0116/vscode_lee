package ch2;



public class Introduce {
    // 메소드1
    public static int sum(int n, int m) {
        return n + m;
    }

    // 메소드2
    public static int mul(int n, int m) {
        return n * m;
    }

    // 메소드3  
    public static int BBEGI(int n, int m) {
        return n - m;
    }

    // 메소드4

    public static int KKOKKO(int n, int m, int i){
        return n + m * i;
    }


    //메소드 5


    public static int PROCESS(int a, int b) {
        System.out.println(a + "+" + b + " = " + (a + b));
        return a + b;
    }

    


    // 메소드 6 (나누기)
    public static int 나누기(int n, int m)
    {
        return n / m;
    }

    // 메소드 7 문자열 출력
    // 메소드 7 문자열 출력
    public static String 프로필(String n, String p, String e) {
         
        return "저는 " + n + "입니다. 제 전화번호 : " + p + "이고, 이메일 : " + e + "입니다.";
    }
//기존의 틀렸던 것



    // 메서드 8 만들어보기

    public static String habbit(String F, String H, String g) {

        return "제가 좋아하는 음식은 :  " + "{"+F+"}" + "입니다.\n" + "제가 좋아하는 취미 : " + "<" + H + ">" + "입니다.\n" + "제가 좋아하는 게임 : " + "[" + g + "]"+"입니다.";

    }   




        public static void main(String[] args) {
            int result = sum(100, 200);
            System.out.println("sum이라는 함수 이용해서 결과 출력 : " + result);

            // 퀴즈1 ,
            // 정적 메소드 하나 만들어서, 곱하기 기능이고,
            // result2 에 담아서, 출력해보기



            // 퀴즈 2,
            // 메소드2 사용하기
            int result2 = mul(10, 20);
            System.out.println("mul 이라는 함수 이용해서 결과 출력 : " + result2);

            // 퀴즈3,
            // 정적 메소드 하나 만들어서, 빼기 기능이고,
            // result3 에 담아서, 출력해보기
            int result3 = BBEGI(100, 20);   
            System.out.println("BBEGI 이라는 함수 이용해서 결과 출력 : " + result3);


            // 퀴즈4,
            // 정적 메소드 하나 만들어서, 곱한 뒤 더하기 기능이고
            // result4 에 담아서, 출력해보되 과정과 결과 같이 출력하기기
            int result4 = KKOKKO(10, 20, 3);
            System.out.println("KKOKKO 이라는 함수 이용해서 결과 출력 : " + result4);

        

            //퀴즈 5
            // 정적 메소드 하나 만들어서, 더하기 기능이고
            // result5 에 담아서, 출력해보되 과정과 결과도 같이 출력하기

            int result5 = PROCESS(50, 70);
            System.out.println("PROCESS라는 함수를 이용해서 결과 출력 : " + result5);


            // 퀴즈 6,
            // 정적 메소드 하나 만들어서, 나누기 기능이고
            // result6 에 담아서, 출력해보기

            int result6 = 나누기(100, 20);
            System.out.println("나누기 이라는 함수 이용해서 결과 출력 : " + result6);


            // 퀴즈 7,
            // 본인의 이름과, 전화번호와 이메일을 입력 받는 매개변수가 3개이고, 
            // 출력값은 문자열 타입인데 : 결과는 
            // 저는 {이름}입니다. 
            // 제 전화번호는 : {전화번호}이고, 
            // 이메일 : {이메일} 입니다.
            // 출력하는 예제 해보기.




        
            String result7 = 프로필("이상록", "010-4040-6162", "roguewrite001@gmail.com");
            System.out.println("프로필을 출력 :" + result7);
        


        
        // // 퀴즈 8
        //     내가 좋아하는 음식, 취미, 게임 등 알려주는 기능
        //     좋아하는 음식, 취미, 게임 매개변수가 3개 정의
        //     출력

        //     제가 좋아하는 음식은 : {음식이름} 입니다.
        //     제 취미 : {취미명}이고,
        //     좋아하는 게임 : {게임명} 입니다.
        //     출력하는 예제 해보기
       
    

        String result8 = habbit("만두", "웹소설 읽기", "슬레이 더 스파이어");
        System.out.println("'habbit' 이라는 함수 이용해서 결과 출력 : \n" + result8);
    


    }




}

       
        