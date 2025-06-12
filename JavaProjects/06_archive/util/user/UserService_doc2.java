package util.user;

import java.util.Scanner;

public class UserService_doc2 {

    public static void registerUser(Scanner scanner) {

        System.out.println("이상용 홈피 회원가입");
        System.out.println("이름 입력해주세요 > ");
        String name = scanner.nextLine(); // 이름 입력 받기
        System.out.println("이메일 입력해주세요 > ");
        String email = scanner.nextLine(); // 이메일 입력 받기

        // 기능 추가
        // ============================================================================
        String password;
        // while 문에서, 패스워드 부분이 입력이 맞으면 다음 단계, 아니면 , 계속 확인하기.
        while (true) {
            System.out.println("패스워드 입력해주세요 > ");
            password = scanner.nextLine(); // 패스워드 입력 받기

            System.out.println("패스워드 확인 입력해주세요 > ");
            String password2 = scanner.nextLine(); // 패스워드 입력 받기

            // 패스워드가 비어있지 않은지 확인
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
            } else if (password.equals(password2)) { // 패스워드와 확인 입력이 일치하는지 확인
                System.out.println("패스워드가 일치합니다");
                break; // 패스워드가 일치하면 루프 종료
            } else {
                System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }
        // 기능 추가
        // 기능 추가2, 현재 날짜를 저장하는 변수 , regDate 추가.
        // 화면에서, 사용자에게 현재 시간을 입력 받는 화면을 제공 안합니다.
        // 실제로 현재 시간은 , 시스템에서 자동으로 입력을 받고,
        // 나중에 디비에 저장하는 형태.
        String regDate = util.date.DateUtil.getCurrentDateTime(); // 현재 날짜 시간 가져오기
        // 기능 추가2
        // ============================================================================
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
        // 기능 추가2 출력
        System.out.println("가입 날짜 : " + regDate); // 현재 날짜 시간 출력
        System.out.println("회원 가입 완료되었습니다.");

    }

    public static void loginUser(Scanner scanner) { //
        System.out.println("이상용 홈피 로그인");

        String email = ""; // 이메일 변수 초기화
        String password = ""; // 패스워드 변수 초기화
        while (true) {

            System.out.println("이메일 입력해주세요 > ");
            email = scanner.nextLine(); // 이메일 입력 받기

            if (email.isEmpty()) {
                System.out.println("이메일은 비워둘 수 없습니다. 다시 입력해주세요.");
                continue; // 다시 입력 받기 -> while 루프의 처음으로 돌아감 -> 계속 반복 진행한다.
            }
            // 순서2, 패스워드 입력 받기
            System.out.println("패스워드 입력해주세요 > ");
            password = scanner.nextLine(); // 패스워드 입력 받기

            // 패스워드가 비어있으면, 다시 입력 받기
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
                continue; // 다시 입력 받기
            }
            if (email.equals("admin@naver.com") && password.equals("1234")) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("로그인 실패, 이메일 또는 패스워드를 확인해주세요.");
                continue; // 다시 입력 받기
            }
            break;

        }

        System.out.println("로그인 이메일 정보 : " + email);
        System.out.println("로그인 패스워드 정보 : " + password);
        System.out.println("로그인 완료되었습니다. 현재 임시로 단순 출력용입니다.");

    }

}
