package ch2;
public class Hello0530 {
    public static void main(String[] args) {
            System.out.println("Hello, World!");
       
       
        String myInfo = Introduce.프로필("이상록", "010-4040-6162", "roguewrite001@gmail.com");
        System.out.println(myInfo);
        String myHabbit = Introduce.habbit("만두", "웹소설 읽기", "슬레이 더 스파이어");
        System.out.println(myHabbit);

       // 퀴즈 1
        // Introduce 클래스에, 정의한 사칙연산 메소드를 이용해서, 각각 계산 결과를
        // result1, result2, result3, result4 변수에 담아서, 출력해보기
    
    
        int result1 = Introduce.sum(100, 200);
        System.out.println(result1);
        int result2 = Introduce.mul(10, 20);
        System.out.println(result2);
        int result3 = Introduce.BBEGI(100, 20);
        System.out.println(result3);
        int result4 = Introduce.KKOKKO(10, 20, 3);
        System.out.println(result4);
    
    
    
    }

       
       
        }




