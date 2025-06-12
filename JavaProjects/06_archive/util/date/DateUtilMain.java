package util.date;

public class DateUtilMain {
    public static void main(String[] args) {
        System.out.println("현재 시간을 불러오는 기능 확인.");
        String currentTime = DateUtil.getCurrentDateTime();
        System.out.println("현재 시간: " + currentTime);
    }

    // 퀴즈,
    // user_mini_project -> MainClass.java 파일에
    // MainClass.java 파일에서, 스위치 경우, if 경우로 나누어서 작업.
    // 1) MainClass_if_case
    // 2) MainClass_switch_case
    // 회원 가입 항목에, 현재 가입 시간을 추가하고, 출력도 해보기.
    // DateUtil.getCurrentDateTime() 메서드를 이용해서, 현재 시간을 불러와서 출력해보기.
    // 파일명 : UserService.java 에서, 회원 가입 기능에 날짜 항목을 추가하고,
    // 이용은 : 2) MainClass_switch_case.java 파일에서, 사용하기.
    // 실제 작업은 UserService.java 파일에서 회원 가입 기능을 구현하고,
    // 패턴, 실젝 작업 하는 클래스만 변경만하고, 나머지 클래스는 변경이 적은 형태인데,
    // 느스한 결합 이라고, 객체 지향에서, 유지 보수, 재사용을 잘해야합니다.
    // 상속, 인터페이스, 추상 클래스 등등을 이용해서,
    // mvc 패턴, 스프링에서, 사용하는 디자인 패턴을 이용합니다.

}
