package util.user;

import java.util.Scanner;

public class UserServiceLee {
    private static final Scanner scanner = new Scanner(System.in);
    private static UserDataLee registeredUser; // ✅ 회원 정보 저장 변수 추가

    // ✅ 회원가입 기능 (사용자 정보 입력)
    public static void RegisterUser() {
        System.out.println("📝 회원가입을 시작합니다!");

        System.out.print("이름을 입력해주세요: ");
        String name = scanner.nextLine();

        System.out.print("메일을 입력해주세요: ");
        String email = scanner.nextLine();

        System.out.print("비밀번호를 설정하세요: ");
        String password = scanner.nextLine();

        String confirmPassword;

        // 🚀 비밀번호 일치 확인 (틀리면 계속 입력)
        while (true) {
            System.out.print("비밀번호를 다시 입력하세요: ");
            confirmPassword = scanner.nextLine();

            if (password.equals(confirmPassword)) {
                System.out.println("✅ 비밀번호가 일치합니다!");
                break;
            } else {
                System.out.println("❌ 비밀번호가 일치하지 않습니다! 다시 입력하세요.");
            }
        }

        // ✅ 회원 정보 저장 (UserData 객체 생성)
        registeredUser = new UserDataLee(name, email, password);

        // 저장된 정보 출력
        registeredUser.displayUserInfo();

        // ✅ 회원가입 완료 후 로그인 메뉴 자동 실행
        LoginUser();
    }

    // ✅ 로그인 기능 (이메일과 비밀번호 입력)
    public static void LoginUser() {
        if (registeredUser == null) {
            System.out.println("\n🚨 먼저 회원가입을 진행하세요!");
            return;
        }

        while (true) { // 🚀 로그인 시도를 반복할 수 있도록 루프 추가
            System.out.println("\n🔑 로그인 기능 실행");

            System.out.print("로그인 이메일을 입력하세요: ");
            String inputEmail = scanner.nextLine();

            System.out.print("로그인 비밀번호를 입력하세요: ");
            String inputPassword = scanner.nextLine();

            // ✅ 로그인 검증 (이메일과 비밀번호가 모두 일치해야 함)
            if (registeredUser.verifyLogin(inputEmail, inputPassword)) {
                System.out.println("\n✅ 로그인 성공! 환영합니다, " + registeredUser.getName() + "님! 🎉");
                break; // 로그인 성공하면 반복 종료
            } else {
                System.out.println("\n❌ 로그인 실패! 이메일 또는 비밀번호가 일치하지 않습니다.");
                System.out.println("🔄 다시 로그인 시도할까요? (예/아니요)");
                String retry = scanner.nextLine();
                if (!retry.equalsIgnoreCase("예")) {
                    break; // 로그인 실패 후 사용자가 "아니요"를 입력하면 종료
                }
            }
        }
    }

    // ✅ 프로그램 종료 시 Scanner 닫기
    public static void CloseScanner() {
        scanner.close();
        System.out.println("🔻 모든 입력이 완료되어 Scanner를 닫습니다.");
    }
}
