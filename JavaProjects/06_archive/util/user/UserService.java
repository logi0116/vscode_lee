package util.user;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UserService {
    
    // 현재 날짜 반환 메서드 추가
    private static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분", Locale.KOREAN);
        return formatter.format(now);
    }
    
    public static void registerUser(Scanner scanner) {
        System.out.println("이상록 홈피 회원가입");
        System.out.println("이름 입력해주세요 > ");
        String name = scanner.nextLine();
        
        System.out.println("이메일 입력해주세요 > ");
        String email = scanner.nextLine();
        
        String password;
        // while 문에서 패스워드 확인 로직
        while (true) {
            System.out.println("패스워드 입력해주세요 > ");
            password = scanner.nextLine();
            
            System.out.println("패스워드 확인 입력해주세요 > ");
            String password2 = scanner.nextLine();
            
            // 패스워드가 비어있지 않은지 확인
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
            } else if (password.equals(password2)) {
                System.out.println("패스워드가 일치합니다");
                break; // 패스워드가 일치하면 루프 종료
            } else {
                System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }
        
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
        System.out.println("회원 가입 완료를 축하합니다. 가입날짜 : " + getCurrentDate());
    }
    


    public static void loginUser(Scanner scanner) {
        System.out.println("이상록 홈피 로그인");
        
        // 관리자 계정 정보
        final String ADMIN_EMAIL = "admin@naver.com";
        final String ADMIN_PASSWORD = "1234";
        
        while (true) {
            System.out.println("이메일 입력해주세요 > ");
            String email = scanner.nextLine();
            
            System.out.println("패스워드 입력해주세요 > ");
            String password = scanner.nextLine();
            
            // 유효성 검사
            if (email.isEmpty()) {
                System.out.println("이메일은 비워둘 수 없습니다.");
                continue;
            }
            
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다.");
                continue;
            }
            
            // 로그인 검증
            if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("로그인 성공");
                System.out.println("로그인 이메일 정보 : " + email);
                break;
            } else {
                System.out.println("로그인 실패 - 이메일 또는 패스워드가 일치하지 않습니다.");
                System.out.println("다시 시도하시겠습니까? (y/n)");
                String retry = scanner.nextLine();
                if (!retry.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
    }
}