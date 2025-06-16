package user_mini_project;

import java.util.Scanner;

import ch2.OperConditionTest;
import ch3.Exs_ch3;
import util.random.RandomUtil;
import util.user.UserService;

public class MainClass_switch_case {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 따로 앞단 없어서, 현재는 콘솔을 화면 대체로 이용중.
            // 디비가 따로 없어서, 현재는 메모리에 임시 저장으로 이용함.
            // 나중에 jdbc 연결 하면, 그때 디비에 저장, 불러오고, 쓰기, 수정 등 할 예정.
            System.out.println("========================================================");
            System.out.println("회원 관리 시스템에 오신 것을 환영합니다. 배운거 복습 적용해보기");
            System.out.println("1. 회원 가입  2.로그인 3.산술 연산자 테스트  4.산술 연산자 테스트2  0.종료");
            System.out.println("5. 로또 번호 생성기:배열 없는 버전");
            System.out.println("6. 입력한 문재 갯수 체크");
            System.out.println("========================================================");
            System.out.println("메뉴 번호를 선택해주세요 (0~6): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    UserService.registerUser(scanner);
                    break;
                case "2":
                    UserService.loginUser(scanner);
                    break;
                case "3":
                    OperConditionTest.oper1();
                    break;
                case "4":
                    OperConditionTest.oper2();
                    break;
                case "5":
                    RandomUtil.generateLottoNumbers();
                    break;
                    case "6":
                    Exs_ch3.ex3_3(scanner);
                    System.out.println("입력한 문자 개수는 : " + 개 "입니다") ;
                    break; 
                case "0":
                    System.out.println("프로그램을 종료합니다. 감사합니다!");
                    scanner.close(); // 스캐너 자원 반납
                    return; // while 루프 종료
                default:
                    System.out.println("잘못된 입력입니다. 0, 1, 2 중에서 선택해주세요.");
            }
        }
    }
}
